package Ch13_RBT;

public class RBT {
    public Node root;

    public Node leaf;

    public RBT(Node root) {
        this.root = root;
        this.leaf = new Node(0, true);
    }

    /*
     |      left-rotate(T,x)        |
     y       <——————————————        x
    / \      ——————————————>       / \
   x   γ    right-rotate(T,y)     α   y
  / \                                / \
 α   β                              β   γ

     */

    public void LeftRotate(Node x) {
        Node y = x.right;
        x.right = y.left;
        if (y.right != leaf)
            y.left.p = x;
        y.p = x.p;
        if (x.p == leaf)
            root = y;
        else if (x == x.p.left)
            x.p.left = y;
        else x.p.right = y;
        y.left = x;
        x.p = y;
    }

    public void RightRotate(Node x) {
        Node y = x.left;
        x.left = y.right;
        if (y.right != leaf)
            y.left.p = x;
        y.p = x.p;
        if (x.p == leaf)
            root = y;
        else if (x == x.p.right)
            x.p.right = y;
        else x.p.left = y;
        y.right = x;
        x.p = y;
    }

    public void RBInsert(Node z) {
        Node y = leaf;
        Node x = root;
        while (x != leaf) {
            y = x;
            if (z.key < x.key) {
                x = x.left;
            } else {
                x = x.right;
            }
        }
        z.p = y;
        if (y == leaf) {
            root = z;
        } else if (z.key < y.key) {
            y.left = z;
        } else {
            y.right = z;
        }
        z.left = leaf;
        z.right = leaf;
        z.isBlack = false;
        RBInsertFixup(z);
    }

    public void RBInsertFixup(Node z) {
        Node p =leaf;
        Node g = leaf;
        while ((p = z.p)!=null && !p.isBlack) {
            g = p.p;
            if (g != null && p == g.left) {
                Node u = g.right;
                if (u != null && !u.isBlack) {
                    u.isBlack = true;
                    p.isBlack = true;
                    g.isBlack = false;
                    z = g;
                    continue;
                }
                if ((u == null || u.isBlack) && (p.right == z)) {
                    z = p;
                    LeftRotate(p);
                    continue;
                }
                p.isBlack = true;
                g.isBlack = false;
                RightRotate(g);
            } else {
                Node u = g.left;
                if (u != null && !u.isBlack) {
                    u.isBlack = true;
                    p.isBlack = true;
                    g.isBlack = false;
                    z = g;
                    continue;
                }
                if ((u == null || u.isBlack) && (p.left == z)) {
                    z = p;
                    RightRotate(p);
                    continue;
                }
                p.isBlack = true;
                g.isBlack = false;
                LeftRotate(g);
            }
        }
        root.isBlack = true;
    }
}
