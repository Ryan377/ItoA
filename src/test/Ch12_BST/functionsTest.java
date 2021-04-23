package Ch12_BST;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

class functionsTest {
    BST t;
    functions f;

    @BeforeEach
    public void BuildTree() {
        for (int i = 0; i < 10; i++) {
            Node temp = new Node(i);
            f.TreeInsert(t, temp);
        }
    }

    @AfterEach
    public void TearDownTree() {
        t.root = null;
    }

    @org.junit.jupiter.api.Test
    void inoderedTreeWalk() {

    }

    @org.junit.jupiter.api.Test
    void treeSearch() {
    }

    @org.junit.jupiter.api.Test
    void iterativeTreeSearch() {
    }

    @org.junit.jupiter.api.Test
    void treeMaximum() {
    }

    @org.junit.jupiter.api.Test
    void treeMinimum() {
    }

    @org.junit.jupiter.api.Test
    void treeSuccessor() {
    }

    @org.junit.jupiter.api.Test
    void treePreDecessor() {
    }

    @org.junit.jupiter.api.Test
    void treeInsert() {

    }

    @org.junit.jupiter.api.Test
    void treeDelete() {
    }
}