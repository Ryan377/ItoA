package Ch12_BST;

public class BST {
    private Node root;

    public BST(Node root) {
        this.root = root;
    }

    public void TreeWalk() {
        TreeWalk(root);
    }

    private void TreeWalk(Node x) {
        if (x != null) {
            TreeWalk(x.left);
            System.out.println(x.key);
            TreeWalk(x.right);
        }
    }

    public Node TreeSearch(int k) {
        return TreeSearch(root, k);
    }

    private Node TreeSearch(Node x, int k) {
        if ( x == null || k == x.key) {
            return x;
        }
        if (k < x.key) {
            return TreeSearch(x.left, k);
        }
        else {
            return TreeSearch(x.right, k);
        }
    }

    public Node TreeMinimum() {
        return TreeMinimum(root);
    }

    public Node TreeMinimum(Node x) {
        Node y = x;
        while (y.left != null) {
            y = y.left;
        }
        return y;
    }

    public Node TreeMaximum() {
        return TreeMaximum(root);
    }

    private Node TreeMaximum(Node x) {
        Node y = x;
        while (y.right != null) {
            y = y.right;
        }
        return y;
    }

    public Node TreeSuccessor(Node x) {
        if (x.right != null) {
            return TreeMinimum(x.right);
        }
        Node y = x.p;
        while (y != null && x == y.right) {
            x = y;
            y = y.p;
        }
        return y;
    }

    public Node TreePreDecessor(Node x) {
        if (x.left != null) {
            return TreeMaximum(x.left);
        }
        Node y = x.p;
        while (y != null && x == y.left) {
            x = y;
            y = y.p;
        }
        return y;
    }

    public void TreeInsert(Node z) {
        Node y = null;
        Node x = root;
        // x占据的位置就是z要插入的位置
        while (x != null) {
            y = x;
            if (z.key < x.key) {
                x = x.left;
            } else {
                x = x.right;
            }
        }
        z.p = y;
        if (y == null) {
            root = z;
        }
        else if (z.key < y.key) {
            y.left = z;
        } else {
            y.right = z;
        }
    }

    // 删除
    // 1.没有孩子节点直接删除，修改其父节点的孩子节点为null
    // 2.只有一个孩子，将孩子换到它原来的位置，并修改其父节点
    // 3.有两个孩子，用其后继占据其位置

    /*
        q           q
        |           |
        z     ->    r
       / \
     null r

        q           q
        |           |
        z     ->    l
       / \
      l  null

        q           q
        |           |
        z     ->    y
       / \         / \
      l   y       l   x
         / \
       null x

        q           q               q
        |           |               |
        z     ->    z    y   ->     y
       / \         /    / \        / \
      l   r       l  null  r      l   r
         / \              / \        / \
        y   ...          x  ...     x  ...
       / \
    null  x
     */

    // 把v换到u的位置上，同时修改u的父节点
    public void TransPlant(Node u, Node v) {
        if (u.p == null)
            root = v;
        else if (u == u.p.left)
            u.p.left = v;
        else
            u.p.right = v;
        if (v != null)
            v.p = u.p;
    }

    public void TreeDelete(Node z) {
        if (z.left == null)
            TransPlant(z, z.right);
        else if (z.right == null)
            TransPlant(z, z.left);
        else {
            Node y = TreeMaximum(z.right);
            if (y.p != z) {
                TransPlant(y, y.right);
                y.right = z.right;
                y.right.p = y;
            }
            TransPlant(z, y);
            y.left = z.left;
            y.left.p = y;
        }
    }
}



