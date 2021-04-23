package Ch13_RBT;

public class RBT {
    public Node root;

    public Node leaf;

    public RBT(Node root) {
        this.root = root;
        this.leaf = new Node(0, true);
    }
}
