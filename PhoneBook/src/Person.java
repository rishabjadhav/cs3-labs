public class Person {
    private String name;

    public Person() {
        this.name = "UNNAMED";
    }
    public Person(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public String toString() {
        return name;
    }
    public boolean equals(Person p) {
        if (this.name.equals(p.name)) {
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
