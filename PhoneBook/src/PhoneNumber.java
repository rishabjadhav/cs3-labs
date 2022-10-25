public class PhoneNumber {
    private int number;

    public PhoneNumber() {
        this.number = 0;
    }
    public PhoneNumber(int num) {
        this.number = num;
    }
    public int getNumber() {
        return number;
    }
    public String toString() {
        return Integer.toString(number);
    }

}
