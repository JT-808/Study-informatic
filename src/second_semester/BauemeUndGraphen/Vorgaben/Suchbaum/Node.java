
public class Node  
{
    private Node lchild;
    private Node rchild;
    private int key;

    public Node(int key)
    {
        this.key=key;
        this.lchild=null;
        this.rchild=null;
    }
    public Node getLchild() {
		return lchild;
	}
	public void setLchild(Node lchild) {
		this.lchild = lchild;
	}
	public Node getRchild() {
		return rchild;
	}
	public void setRchild(Node rchild) {
		this.rchild = rchild;
	}
	public int getKey() {
		return key;
	}
	public void setKey(int key) {
		this.key = key;
	}
	
    
}