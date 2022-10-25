import java.util.Hashtable;

public class EmployeeDatabase {
    private Entry[] table;
    private int capacity = 11;


    public EmployeeDatabase(int capacity) {
        this.capacity = capacity;
        table = new Entry[capacity];
    }
    public EmployeeDatabase() {
        table = new Entry[capacity];
    }

    public void put(int ID, Employee e) {
        Entry entry = new Entry(ID, e);
        int index = hash(ID);
        while (table[index] != null) {
            index = linearProbingResolver(index);
        }
        table[index] = entry;
    }
    public Employee get(int ID) {
        for (Entry e : table) {
            if (e.ID == ID) {
                return e.employee;
            }
        }
        return null;
    }
    private int hash(int ID) {
        return (Integer.hashCode(ID) % capacity);
    }
    private int brokenHash(int ID) {
        return ID % capacity;
    }

    private int linearProbingResolver(int index) {
        return (index + 1) % this.capacity;

    }



    private class Entry {
        private int ID;
        private Employee employee;

        public Entry(int ID, Employee employee) {
            this.ID = ID;
            this.employee = employee;
        }
        @Override
        public String toString() {
            return "Name : " + this.employee.getName() + " // ID : " + this.ID;
        }
    }
}
