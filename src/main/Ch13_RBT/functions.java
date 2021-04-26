package Ch13_RBT;

public class functions {
    public Node TreeMaximum(Node x) {
        while (x.left != null)
            x = x.left;
        return x;
    }

    public Node TreeMinimum(Node x) {
        while (x.right != null)
            x = x.right;
        return x;
    }

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
        Node y = x.p; // set y
        //todo:
    }

    public void rbInsert(RBT T, Node z) {
        Node y = T.leaf;
        Node x = T.root;
        while (x != T.leaf) {
            y = x;
            if (z.key < x.key) {
                x = x.left;
            } else {
                x = x.right;
            }
        }
        z.p = y;
        if (y == T.leaf) {
            T.root = z;
        } else if (z.key < y.key) {
            y.left = z;
        } else {
            y.right = z;
        }
        z.left = T.leaf;
        z.right = T.leaf;
        z.isBlack = false;
        rbInsertFixup(T, z);
    }

    public void rbInsertFixup(RBT T, Node z) {
        while (z.p.isBlack == false) {
            if (z.p == z.p.p.left) {
                Node y = z.p.p.right;
                if (y.isBlack == false) {
                    z.p.isBlack = true;         // case1
                    y.isBlack = true;           // case1
                    z.p.p.isBlack = false;      // case1
                    z = z.p.p;                  // case1
                } else if (z == z.p.right) {
                    z = z.p;                   // case2
                    LeftRotate(T, z);           // case2
                }
                z.p.isBlack = true;
                z.p.p.isBlack = false;
                RightRotate(T, z.p.p);
            } else {
                //todo:
            }
        }
        T.root.isBlack = true;
    }

    public void rbTransPlant(RBT T, Node u, Node v) {
        if (u.p == T.leaf) {
            T.root = v;
        } else if (u == u.p.left) {
            u.p.left = v;
        } else {
            u.p.right = v;
        }
        v.p = u.p;
    }

    public void rbDelete(RBT T, Node z) {
        Node y = z;
        boolean y_origin = y.isBlack;
        if (z.left == T.leaf) {
            Node x = z.right;
            rbTransPlant(T, z, z.left);
        } else {
            //todo:

        }
    }

    public void rbDeleteFixup(RBT T, Node x) {
        //todo:
    }
}
