public class MyLinkedList<T> {
    private ListNode head;
    private ListNode tail;
    private int size;

    public MyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public MyLinkedList(T val) {
        this.head = new ListNode(val);
        this.tail = head;
        this.size = 1;
    }

    public MyLinkedList(T ... vals) {
        for (T val : vals) {
            add(val);
        }
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public int size() {
        return this.size;
    }

    public void add(T newVal) {
        if (head == null || tail == null) {
            head = new ListNode(newVal);
            tail = head;
        } else {
            tail.next = new ListNode(newVal);
            tail = tail.next;
        }
        size++;
    }

    public void set(T newVal, int index) {
        int i = 0;
        ListNode next = head;

        while (next != null) {
            if (i == index) {
                next.val = newVal;
            }
            next = next.next;
            i++;
        }
    }

    public void add(T newVal, int index) {
        int i = 0;
        ListNode next = head;
        ListNode temp;


        while (next != null) {
            if (i == index - 1) {
                temp = next.next;
                next.next = new ListNode(newVal);
                next.next.next = temp;
            }
            next = next.next;
            i++;
        }
        size++;
    }

    public T remove (int index) {
        int i = 0;
        ListNode next = head;
        T removedVal = null;
        if (index == 0) {
            removedVal = head.val;
            head = head.next;
            size--;
            return removedVal;
        }

        while (next != null) {
            if (i == index - 1) {
                removedVal = next.next.val;
                next.next = next.next.next;
            }
            next = next.next;
            i++;
        }
        size--;
        return removedVal;
    }

    public boolean contains(T target) {
        ListNode next = head;

        while (next != null) {
            if (next.val.equals(target)) {
                return true;
            }
            next = next.next;
        }
        return false;
    }

    public int indexOf (T target) {
        int index = 0;
        ListNode next = head;

        while (next != null) {
            if (next.val.equals(target)) {
                return index;
            }
            next = next.next;
            index++;
        }
        return -1;
    }

    public T get(int index) {
        int i = 0;
        ListNode next = head;

        while (next != null) {
            if (i == index) {
                return next.val;
            }
            next = next.next;
            i++;
        }
        return null;
    }

    @Override
    public String toString() {
        String str = "[";
        ListNode next = head;

        while (next != null) {
            str += next + " > ";
            next = next.next;
            if (next == null) {
                str = str.substring(0, str.length() - 2);
            }
        }
        str += "]";
        return str;
    }

    //LIST NODE CLASS
    private class ListNode {
        T val; //does a private inner class need private instance variables?
        ListNode next;

        public ListNode(T val) {
            this.val = val;

        }

        @Override
        public String toString() {
            return "" + this.val;
        }
    }

}
