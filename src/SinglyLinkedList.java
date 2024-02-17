public class SinglyLinkedList {
    Node head;
    public void addElement(int data) {
        Node node = new Node(data, null);
        if (this.head == null) {
            this.head = node;
        } else {
            Node temp = this.head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;
        }
    }

    public int removeElement(int loc) {
        Node temp;
        if (this.head == null) {
            return -1;
        } else if (loc <= 0) {
            return -2;
        } else if (loc == 1) {
            temp = this.head;
            this.head = this.head.next;
            return temp.data;
        } else {
            temp = this.head;
            for (int i=1; i<loc-1 && temp.next!=null; i++) {
                temp = temp.next;
            }
            if (temp.next != null) {
                Node p = temp.next;
                temp.next = p.next;
                return p.data;
            }
            return -3;
        }
    }

    public int getSize() {
        int length = 0;
        Node temp = this.head;
        while (temp != null){
            length++;
            temp = temp.next;
        }
        return length;
    }

    public void reverseList() {
        int length = this.getSize();
        if (length > 1) {
            Node p = null;
            Node q;
            while (head.next != null) {
                q = head.next;
                head.next = p;
                p = head;
                head = q;
            }
            head.next = p;
        }
    }

    public void printList() {
        Node temp = this.head;
        while (temp != null) {
            System.out.printf("%d->", temp.data);
            temp = temp.next;
        }
        System.out.println("NULL");
    }
}

class Node {

    public Node() {}

    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }

    int data;
    Node next;
}