public class StudentScore implements Comparable<StudentScore>{
	
	private String name;
	private int score;
	
	public StudentScore(){ //Default input
		name = "Student";
		score = 0;
	}
	
	public StudentScore(String name, int score)
	{
		this.name = name;
		setScore(score);
	}
	
	public String name()
	{
		return name;
	}
	
	public int score()
	{
		return score;
	}
	
	public void setScore(int score)
	{
		if (score >= 0 && score <= 100)
		{
			this.score = score;
		}
		else
		{
			this.score = 0; //if score is outside of 0-100, set as 0
		}
	}


	public int compareTo(StudentScore parmSS) 
	{
		if (this.score == parmSS.score)
		{
			// check the names
			return this.name.compareTo(parmSS.name);
		}
		else
		{
			return this.score - parmSS.score;
		}
	}

	public String toString(){
		return "Name: " + name + " |  Score:" + score;
	}

	

}