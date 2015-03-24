public class BSTNode
{
	public int key;
	public BSTNode parent;
	public BSTNode left;
	public BSTNode right;

	public BSTNode(int key)
	{
		this.key = key;
		this.left = null;
		this.right = null;
		this.parent = null;
	}
}	