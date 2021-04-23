package Ch13_RBT;

public class functions {
    public void LeftRotate(RBT T, Node x) {
        Node y = x.right; // set y
        x.right = y.left;
        if (y.left != T.leaf)
            y.left.p = x;
        y.p = x.p;
        if (x.p == T.leaf)
            T.root = y;
        else if (x == x.p.left)
            x.p.left = y;
        else
            x.p.right = y;
        y.left = x;
        x.p = y;
    }

    public void RightRotate(RBT T, Node x) {
        Node y = x.left; // set y
    }
}
