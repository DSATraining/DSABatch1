/**
 * Node class representing a single node in the linked list
 */
class ListNode {
    int val;        // Value stored in the node
    ListNode next;  // Reference to the next node
    
    /**
     * Constructor to create a new node
     * @param val The value to be stored in the node
     */
    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
    
    /**
     * Constructor to create a new node with specified next node
     * @param val The value to be stored in the node
     * @param next Reference to the next node
     */
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

/**
 * Linked List class implementing all standard operations
 */
class LinkedList {
    private ListNode head;  // Head of the linked list
    private int size;       // Size of the linked list
    
    /**
     * Constructor to initialize an empty linked list
     */
    public LinkedList() {
        this.head = null;
        this.size = 0;
    }
    
    /**
     * Get the size of the linked list
     * @return The number of nodes in the linked list
     */
    public int size() {
        return this.size;
    }
    
    /**
     * Check if the linked list is empty
     * @return true if the list is empty, false otherwise
     */
    public boolean isEmpty() {
        return this.size == 0;
    }
    
    /**
     * Get the value of the node at a specific index
     * @param index The index of the node (0-based)
     * @return The value at the specified index
     * @throws IndexOutOfBoundsException if index is invalid
     */
    public int get(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + this.size);
        }
        
        ListNode current = this.head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.val;
    }
    
    /**
     * Add a node with the given value at the beginning of the list
     * @param val The value to be added
     */
    public void addAtHead(int val) {
        ListNode newNode = new ListNode(val);
        newNode.next = this.head;
        this.head = newNode;
        this.size++;
    }
    
    /**
     * Add a node with the given value at the end of the list
     * @param val The value to be added
     */
    public void addAtTail(int val) {
        if (this.head == null) {
            addAtHead(val);
            return;
        }
        
        ListNode current = this.head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new ListNode(val);
        this.size++;
    }
    
    /**
     * Add a node with the given value at the specified index
     * @param index The index where the node should be added (0-based)
     * @param val The value to be added
     * @throws IndexOutOfBoundsException if index is invalid
     */
    public void addAtIndex(int index, int val) {
        if (index < 0 || index > this.size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + this.size);
        }
        
        if (index == 0) {
            addAtHead(val);
            return;
        }
        
        if (index == this.size) {
            addAtTail(val);
            return;
        }
        
        ListNode current = this.head;
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }
        ListNode newNode = new ListNode(val);
        newNode.next = current.next;
        current.next = newNode;
        this.size++;
    }
    
    /**
     * Delete the node at the beginning of the list
     * @throws NoSuchElementException if list is empty
     */
    public void deleteAtHead() {
        if (this.head == null) {
            throw new java.util.NoSuchElementException("List is empty");
        }
        
        this.head = this.head.next;
        this.size--;
    }
    
    /**
     * Delete the node at the end of the list
     * @throws NoSuchElementException if list is empty
     */
    public void deleteAtTail() {
        if (this.head == null) {
            throw new java.util.NoSuchElementException("List is empty");
        }
        
        if (this.head.next == null) {
            deleteAtHead();
            return;
        }
        
        ListNode current = this.head;
        while (current.next.next != null) {
            current = current.next;
        }
        current.next = null;
        this.size--;
    }
    
    /**
     * Delete the node at the specified index
     * @param index The index of the node to be deleted (0-based)
     * @throws IndexOutOfBoundsException if index is invalid
     */
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + this.size);
        }
        
        if (index == 0) {
            deleteAtHead();
            return;
        }
        
        ListNode current = this.head;
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }
        current.next = current.next.next;
        this.size--;
    }
    
    /**
     * Reverse the linked list in-place
     */
    public void reverse() {
        ListNode prev = null;
        ListNode current = this.head;
        ListNode next = null;
        
        while (current != null) {
            next = current.next;   // Store next node
            current.next = prev;   // Reverse current node's pointer
            prev = current;         // Move pointers one position ahead
            current = next;
        }
        
        this.head = prev;  // Update head to new first node
    }
    
    /**
     * Check if the linked list contains a node with the given value
     * @param val The value to search for
     * @return true if the value is found, false otherwise
     */
    public boolean contains(int val) {
        ListNode current = this.head;
        while (current != null) {
            if (current.val == val) {
                return true;
            }
            current = current.next;
        }
        return false;
    }
    
    /**
     * Display the linked list as a string
     * @return String representation of the linked list
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        ListNode current = this.head;
        while (current != null) {
            sb.append(current.val);
            if (current.next != null) {
                sb.append(" -> ");
            }
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }
    
    /**
     * Main method to demonstrate the linked list operations
     */
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        
        // Add elements
        list.addAtHead(1);
        list.addAtTail(3);
        list.addAtIndex(1, 2);  // List: [1 -> 2 -> 3]
        
        System.out.println("Initial list: " + list);
        System.out.println("Size: " + list.size());
        System.out.println("Element at index 1: " + list.get(1));
        
        // Delete elements
        list.deleteAtIndex(1);  // List: [1 -> 3]
        System.out.println("After deletion at index 1: " + list);
        
        list.deleteAtHead();     // List: [3]
        System.out.println("After deleting head: " + list);
        
        list.deleteAtTail();     // List: []
        System.out.println("After deleting tail: " + list);
        
        // Test reverse
        list.addAtTail(1);
        list.addAtTail(2);
        list.addAtTail(3);
        System.out.println("Before reverse: " + list);
        list.reverse();
        System.out.println("After reverse: " + list);
        
        // Test contains
        System.out.println("Contains 2: " + list.contains(2));
        System.out.println("Contains 5: " + list.contains(5));
    }
}
