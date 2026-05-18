package BinarySearchTree;

public class Main {
    public static void main(String[] args) {
        BST tree1 = new BST();

        tree1.insert(5);
        tree1.insert(6);
        tree1.insert(2);
        tree1.insert(12);
        tree1.insert(3);
        tree1.delete(5);
        tree1.inorder();
    }
}
