import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.commons.*;
import org.apache.commons.lang3.StringUtils;

public class BuildExcel 
{
	public static int TALLY = 0;
	
	public static void main(String[] args) throws IOException
	{
		System.out.println("Which folder in the desktop would you like to use? (PNG, CAL, SOCA, etc.)");
		Scanner in = new Scanner(System.in);
		String prefix = in.nextLine();
		System.out.println("- - - - - - - - - - - - - - - - ");
		System.out.println();
		
		//CREATE WORKBOOK
		Workbook wb = new HSSFWorkbook();
	    FileOutputStream fileOut = new FileOutputStream("/Users/James/Desktop/" + prefix + ".xls");
	    
	    //NEW SHEET
	    Sheet sheet1 = wb.createSheet("sheet1");
	    
	    //OPEN FOLDER AND GET LIST OF FILES
	    String directory = "/Users/James/Desktop/" + prefix;
	    File folder = new File(directory);
	    
		// gets you the list of files at this folder
		File[] listOfFiles = folder.listFiles();
		
		//CONVERT FILE NAMES TO STRINGS
		String[] fileNames;
		fileNames = new String[listOfFiles.length];
		for (int i = 0; i < listOfFiles.length; ++i)
		{
			fileNames[i] = listOfFiles[i].toString().substring(directory.length());
		}
		
		
		//CYCLE THROUGH
		for(int i=1; i < fileNames.length; i++)
		{
		    //NEW ROW
		    Row row = sheet1.createRow(i);
		    
		    //SKU
		    String SKU = fileNames[i].substring(1, prefix.length()+4);
		    row.createCell(0).setCellValue(SKU);
		    		
		    //POST TITLE
		    String postTitleJPG = fileNames[i].substring(SKU.length()+1).replace("-", " ").replace("_", " "); //remove unused characters
		    String postTitle = postTitleJPG.substring(0,postTitleJPG.length() - 4);
		    row.createCell(1).setCellValue(postTitle);
		    
		    //SIZE CATEGORY
		    String category = "Custom";
		    
		    if (postTitle.contains("20x5")||postTitle.contains("5x20")){category = "20x5";}
		    if (postTitle.contains("36x6")||postTitle.contains("6x36")){category = "36x6";}
		    if (postTitle.contains("16x24")){category = "16x24";}
		    if (postTitle.contains("24x16")){category = "24x16";}
		    if (postTitle.contains("8x14")||postTitle.contains("14x8")){category = "8x14";}
		    if (postTitle.contains("12x12")){category = "12x12";}
		    if (postTitle.contains("Plasma")||postTitle.contains("5x20")){category = "Plasma";}
		    
		    row.createCell(2).setCellValue(category);
		    
		    //TAGS
		    List<String> Beach = Arrays.asList("Beach","Seahorse","Ocean","Sea","Surf","Mermaid","Starfish","Sailing");
		    List<String> Hawaii = Arrays.asList("Oahu","Maui","Kawaii","Aloha","Mahalo","Island Time","Hawaii","Kailua");
		    List<String> California = Arrays.asList("Laguna", "Malibu", "Monterrey","Newport", "Huntington", "Manhattan");
		    List<String> Love = Arrays.asList("Love");
		    List<String> Maps = Arrays.asList("Map");
		    
		    List<List<String>> arrayOfArrays = Arrays.asList(Maps, Love, California, Hawaii, Beach);//Add all tag options to array
		    List<String> listOfOptions = Arrays.asList("Maps","Love","California","Hawaii","Beach");//MUST BE IDENTICAL to above array
		    ArrayList<String> tagsArray = new ArrayList<String>();
		    
		    for(int t = 0; t < arrayOfArrays.size(); t++)//cycle through arrayOfArrays
		    {
		    	for(int s = 0; s < arrayOfArrays.get(t).size(); s++)//cycle through arrayOfArrays inner arrays
		    	{
		    		if(postTitle.contains(arrayOfArrays.get(t).get(s)))
		    				{
		    					tagsArray.add(listOfOptions.get(t));
		    					break;
		    				}
		    	}
		    }
		    String tags = StringUtils.join(tagsArray, "|"); //need the | separator for WooCommerce
		    row.createCell(3).setCellValue(tags);
		    
		    //FINISHED WITH FILE
		    TALLY++;
		    System.out.println(TALLY + " " + SKU + postTitle);
		}
	    
		System.out.println("# OF FILES COMPLETED:" + TALLY);
	    //CLOSE AND SAVE
	    wb.write(fileOut);
	    fileOut.close();
	}
	
}
