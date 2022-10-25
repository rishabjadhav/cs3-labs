public class MyLinkedList {
    private ListNode head;
    private ListNode tail;
    private int size;

    public MyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public MyLinkedList(int val) {
        this.head = new ListNode(val);
        this.tail = new ListNode(val);
        this.size = 1;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public int size() {
        return this.size;
    }

    /* THIS "ADD METHOD" WAS CREATED BEFORE THE IMPLEMENTATION OF TAIL
    public void add(int newVal) {
        if (head == null) {
            head = new ListNode(newVal);
        }
        else {
            ListNode next = head;

            while (next.next != null) {
                next = next.next;
            }
            next.next = new ListNode(newVal);
        }
        size++;
    }
    */


    public void add(int newVal) {
        if (head == null || tail == null) {
            head = new ListNode(newVal);
            tail = head;
        } else {
            tail.next = new ListNode(newVal);
            tail = tail.next;
        }
        size++;
    }

    public void set(int newVal, int index) {
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

    public void add(int newVal, int index) {
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

    public int remove (int index) {
        int i = 0;
        ListNode next = head;
        int removedVal = 0;
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

    public boolean contains(int target) {
        ListNode next = head;

        while (next != null) {
            if (next.val == target) {
                return true;
            }
            next = next.next;
        }
        return false;
    }

    public int indexOf (int target) {
        int index = 0;
        ListNode next = head;

        while (next != null) {
            if (next.val == target) {
                return index;
            }
            next = next.next;
            index++;
        }
        return -1;
    }

    public int get(int index) {
        int i = 0;
        ListNode next = head;

        while (next != null) {
            if (i == index) {
                return next.val;
            }
            next = next.next;
            i++;
        }
        return -1;
    }

    @Override
    public String toString() {
        String str = "[";
        ListNode next = head;

        while (next != null) {
            str += next + ", ";
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
        int val; //does a private inner class need private instance variables?
        ListNode next;

        public ListNode(int val) {
            this.val = val;

        }

        @Override
        public String toString() {
            return "" + this.val;
        }
    }

}
