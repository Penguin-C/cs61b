public class LinkedListDeque<T> {
    public class Node {
        private Node prev;
        private Node next;
        private T item;

        public Node(Node p, Node n, T i) {
            item = i;
            next = n;
            prev = p;
        }
    }

    private int size;
    private Node sentinel;

    public LinkedListDeque() {
        size = 0;
        sentinel = new Node(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
    }

    public LinkedListDeque(T item) {
        sentinel = new Node(null, null, null);
        sentinel.next = new Node(sentinel, sentinel, item);
        sentinel.prev = sentinel.next;
        size = 1;
    }

    public void addFirst(T item) {
        sentinel.next = new Node(sentinel, sentinel.next, item);
        sentinel.next.next.prev = sentinel.next;
        size += 1;
    }

    public void addLast(T item) {
        sentinel.prev = new Node(sentinel.prev, sentinel, item);
        sentinel.prev.prev.next = sentinel.prev;
        size++;
    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        Node t = sentinel;
        while (t.next != sentinel) {
            t = t.next;
            System.out.print(t.item);
            System.out.print(" ");
        }
        System.out.println();
    }

    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        Node r = sentinel.next;
        sentinel.next = r.next;
        r.next.prev = sentinel;
        size--;
        return r.item;
    }

    public T removeLast() {
        if (size == 0) {
            return null;
        }
        Node r = sentinel.prev;
        sentinel.prev = r.prev;
        r.prev.next = sentinel;
        size--;
        return r.item;
    }

    public T get(int index) {
        Node t = sentinel;
        for (int i = 0; i < size; i++) {
            t = t.next;
            if (i == index) {
                return t.item;
            }
        }
        return null;
    }

    private T getRecursiveHelper(int index, int count, Node ptr) {
        if (index == count) {
            return ptr.item;
        }
        return getRecursiveHelper(index, count + 1, ptr.next);
    }

    public T getRecursive(int index) {
        if (index >= size || index < 0) {
            return null;
        }
        int count = 0;
        Node ptr = sentinel.next;
        return getRecursiveHelper(index, count, ptr);
    }

}
