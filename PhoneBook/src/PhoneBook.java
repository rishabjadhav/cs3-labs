public class PhoneBook implements IMap {
    private Entry[] table;
    private int capacity = 500;

    public PhoneBook() {
        table = new Entry[capacity];
    }

    public PhoneBook(int capacity) {
        this.capacity = capacity;
        table = new Entry[capacity];
    }

    @Override
    public PhoneNumber put(Person person, PhoneNumber phone) {
        Entry e = new Entry(person, phone);

        int index = person.getName().hashCode() % capacity;

        while (table[index] != null) {
            table[index] = table[index].next;
        }
        table[index] = e;
        return null;
    }

    @Override
    public PhoneNumber get(Person person) {
        for (Entry e : table) {
            if (e.person.equals(person)) {
                return e.phoneNumber;
            }
        }
        return null;
    }

    @Override
    public int size() {
        int s = 0;
        for (Entry e : table) {
            s++;
        }
        return s;
    }

    @Override
    public PhoneNumber remove(Person person) {
        for (Entry e : table) {
            if (e.person.equals(person)) {
                e = null;
            }
        }
        return null;
    }




    private class Entry {
        private Person person; //key
        private PhoneNumber phoneNumber; //value
        private Entry next;

        public Entry(Person p, PhoneNumber phoneNum) {
            person = p;
            phoneNumber = phoneNum;
        }
        public Entry getNext() {
            return next;
        }
        public void setNext(Entry e) {
            this.next = e;
        }
        @Override
        public String toString() {
            return "Name : " + this.person.getName() + " // Phone Number : " + this.phoneNumber;
        }
    }
}
