package Ch13_RBT;

public class Node {
    public int key;
    public Node left;
    public Node right;
    public Node p;
    public boolean isBlack;

    public Node (int key, boolean isBlack) {
        this.key = key;
        this.isBlack = isBlack;
    }
}
