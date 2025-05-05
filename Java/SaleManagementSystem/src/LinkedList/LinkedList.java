package LinkedList;

public class LinkedList<E> {
    
    private class Node<E> {

        private E info;
        private Node next;

        public Node() {
        }

        public Node(E info, Node next) {
            this.info = info;
            this.next = next;
        }

        public E getInfo() {
            return info;
        }

        public void setInfo(E info) {
            this.info = info;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    private Node head, tail;

    public LinkedList() {
        head = tail = null;
    }

    public boolean isEmpty() {
        return (head == null);
    }

    public void clear() {
        head = tail = null;
    }

    public void add(E x) {
        if (isEmpty()) {
            head = tail = new Node(x, null);
        } else {
            Node q = new Node(x, null);
            tail.next = q;
            tail = q;
        }
    }

    public void traverse() {
        Node p = head;
        while (p != null) {
            System.out.printf("%4d", p.info);
            p = p.next;
        }
        System.out.println();
    }

    public void addFirst(E x) {
        if (isEmpty()) {
            head = tail = new Node(x, null);
        } else {
            Node q = new Node(x, null);
            q.next = head;
            head = q;
        }
    }

    public void addLast(E x) {
        if (isEmpty()) {
            head = tail = new Node(x, null);
        } else {
            Node q = new Node(x, null);
            tail.next = q;
            tail = q;
        }
    }

    public void deleteFirst() {
        if (isEmpty()) {
            System.out.println("List is empty");
        } else {
            head = head.next;
        }
    }

    public void deleteLast() {
        if (isEmpty()) {
            System.out.println("List is empty");
        } else {
            Node q = head;
            while (q.next != tail) {
                q = q.next;
            }
            tail = q;
            q.next = null;
        }
    }

    public boolean search(E x) {
        Node q = head;
        while (q != null) {
            if (q.info.equals(x)) {
                return true;
            }
            q = q.next;
        }
        return false;
    }
    
    public int size() {
        int count = 0;
        Node p = head;
        while (p != null) {
            count++;
            p = p.next;
        }
        return count;
    }
    
    public E get(int i){
        int count = 0;
        Node p = head;
        while (count!=i) {
            count++;
            p = p.next;
        }
        return (E) p.info;
    }
    
    public void remove(int i) {
        int count = 0;
        Node p = head;
        Node q = head;
        while (count != i) {
            count++;
            q = p;
            p = p.next;
        }
        q.next = p.next;
    }
    
    public void set(int i, E info){
        int count = 0;
        Node p = head;
        while (count != i) {
            count++;
            p = p.next;
        }
        p.info = info;
    }
    
    public void add(int i, E x) {
        int count = 0;
        Node p = head;
        while (count != i) {
            count++;
            p = p.next;
        }
        Node q = new Node(x, null);
        q.next = p.next;
        p.next = q;
    }
}
