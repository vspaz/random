package trees;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TreeTest {

    @Test
    void contains() {
    }

    @Test
    void insert() {
        Tree tree = new Tree();
        tree.insert(10, 20);
        tree.insert(15, 30);
        tree.insert(5, 5);
        assert tree.contains(15).data == 30;
    }

    @Test
    void getMin() {
    }

    @Test
    void getMax() {
    }

    @Test
    void preOrder() {
    }

    @Test
    void inOrder() {
    }

    @Test
    void postOrder() {
    }

    @Test
    void remove() {
    }
}