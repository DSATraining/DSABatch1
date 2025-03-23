class SinglyLinkedList {
    private class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;
    private int size;

    public SinglyLinkedList() {
        head = null;
        size = 0;
    }

    // Add to the front
    public void addFront(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        size++;
    }

    // Remove from the front
    public void removeFront() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        head = head.next;
        size--;
    }

    // Get the front element
    public int getFront() {
        if (head == null) {
            throw new IllegalStateException("List is empty");
        }
        return head.data;
    }

    // Add to the middle
    public void addMiddle(int data) {
        if (head == null) {
            addFront(data);
            return;
        }
        
        int mid = size / 2;
        Node newNode = new Node(data);
        Node temp = head;

        for (int i = 0; i < mid - 1; i++) {
            temp = temp.next;
        }

        newNode.next = temp.next;
        temp.next = newNode;
        size++;
    }

    // Remove from the middle
    public void removeMiddle() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (size == 1) {
            head = null;
            size--;
            return;
        }

        int mid = size / 2;
        Node temp = head;
        for (int i = 0; i < mid - 1; i++) {
            temp = temp.next;
        }

        temp.next = temp.next.next;
        size--;
    }

    // Get the middle element
    public int getMiddle() {
        if (head == null) {
            throw new IllegalStateException("List is empty");
        }
        
        int mid = size / 2;
        Node temp = head;
        for (int i = 0; i < mid; i++) {
            temp = temp.next;
        }

        return temp.data;
    }

    // Display the list
    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.addFront(10);
        list.addFront(20);
        list.addFront(30);
        list.display(); // 30 -> 20 -> 10 -> null

        list.addMiddle(25);
        list.display(); // 30 -> 20 -> 25 -> 10 -> null

        System.out.println("Middle: " + list.getMiddle()); // 25

        list.removeMiddle();
        list.display(); // 30 -> 20 -> 10 -> null

        list.removeFront();
        list.display(); // 20 -> 10 -> null
    }
}
