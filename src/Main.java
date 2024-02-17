import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        /*handleSinglyLinkedList();
        handleBinaryTree();*/
        handleHashMap();
    }

    public static void handleHashMap() {
        HashMapImplementation<String, Integer> hashMap = new HashMapImplementation<>(16);

        hashMap.put("Hello", 1);
        hashMap.put("World", 5);

        System.out.println(hashMap.get("Hello"));
        System.out.println(hashMap.get("World"));

        hashMap.put("Hello", 2);
        hashMap.put("Bye", 6);

        System.out.println(hashMap.get("Hello"));
        System.out.println(hashMap.get("Bye"));
    }

    public static void handleBinaryTree() {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.insertNode(20);
        binaryTree.insertNode(10);
        binaryTree.insertNode(12);
        binaryTree.insertNode(11);
        binaryTree.insertNode(5);
        binaryTree.insertNode(30);
        binaryTree.insertNode(25);
        binaryTree.traverseInOrder(binaryTree.root);
        System.out.println();
        binaryTree.traversePreOrder(binaryTree.root);
        System.out.println();
        binaryTree.traversePostOrder(binaryTree.root);
        System.out.println();
    }

    public static void handleSinglyLinkedList() {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.addElement(1);
        singlyLinkedList.addElement(2);
        singlyLinkedList.addElement(3);
        singlyLinkedList.addElement(4);
        singlyLinkedList.addElement(5);
        singlyLinkedList.addElement(6);
        singlyLinkedList.addElement(7);
        singlyLinkedList.printList();
        System.out.println(singlyLinkedList.getSize());
        int value = singlyLinkedList.removeElement(5);
        if (value == -1) {
            System.out.println("List is already empty.");
        } else if (value == -2) {
            System.out.println("Invalid location.");
        } else if (value == -3) {
            System.out.println("Location is out of list.");
        }
        singlyLinkedList.printList();
        System.out.println(singlyLinkedList.getSize());
        singlyLinkedList.reverseList();
        singlyLinkedList.printList();
    }
}

