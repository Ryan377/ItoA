package Ch12_BST;

public class functions {
    public void InoderedTreeWalk(Node x) {
        if (x != null)
            InoderedTreeWalk(x.left);
        System.out.println(x.key);
        InoderedTreeWalk(x.right);
    }

    public Node TreeSearch(Node x, int k) {
        if (x == null || k == x.key)
            return x;
        if (k < x.key)
            return TreeSearch(x.left, k);
        return TreeSearch(x.right, k);
    }

    public Node IterativeTreeSearch(Node x, int k) {
        while (x != null && k != x.key) {
            if (k < x.key)
                x = x.left;
            else
                x = x.right;
        }
        return x;
    }

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

    public Node TreeSuccessor(Node x) {
        if (x.right != null)
            return TreeMinimum(x.right);
        Node y = x.p;
        while (y != null && x == y.right) {
            x = y;
            y = y.p;
        }
        return y;
    }

    public Node TreePreDecessor(Node x) {
        if (x.left != null)
            return TreeMaximum(x.left);
        Node y = x.p;
        while (y != null && x == y.left) {
            x = y;
            y = y.p;
        }
        return y;
    }

    public void TreeInsert(BST t, Node z) {
        Node y = null;
        Node x = t.root;
        while (x != null) {
            y = x;
            if (z.key < x.key) {
                x = x.left;
            } else {
                x = x.right;
            }
        }
        z.p = y;
        if (y == null)
            t.root = x;
        else if(z.key < y.key) {
            y.left = z;
        } else {
            y.right = z;
        }
    }

    public void TreeDelete(BST t, Node z) {
        if (z.left == null)
            Transplant(t, z, z.right);
        else if (z.right == null)
            Transplant(t, z, z.left);
        else {
            Node y = TreeMinimum(z.right);
            if (y.p != z) {
                Transplant(t, y, y.right);
                y.right = z.right;
                y.right.p = y;
            }
            Transplant(t, z, y);
            y.left = z.left;
            y.left.p = y;
        }
    }

    private void Transplant(BST t, Node u, Node v) {
        if (u.p == null)
            t.root = v;
        else if (u == u.p.left)
            u.p.left = v;
        else u.p.right = v;
        if (v != null)
            v.p = u.p;

    }
}
