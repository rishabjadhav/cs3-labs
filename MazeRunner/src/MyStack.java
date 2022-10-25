import java.util.Arrays;
import java.util.EmptyStackException;

public class MyStack implements StackADT {

    private Square[] contents;
    private int size = 0;
    private int capacity;

    public MyStack() {
        this(7);
    }

    public MyStack(int initCap) {
        contents = new Square[initCap];
        capacity = initCap;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        contents = null;
    }

    public Square peek() {
        if (this.isEmpty()) {
            throw new EmptyStackException();
        } else {
            return contents[this.size - 1];
        }
    }

    @Override
    public int size() {
        return size;
    }

    public Square pop() {
        if (this.isEmpty()) {
            throw new EmptyStackException();
        } else {
            Square returned = contents[this.size - 1];
            contents[this.size - 1] = null;
            size -= 1;
            return returned;
        }
    }

    @Override
    public void push(Square item) {
        if (contents.length == size) {
            doubleCapacity();
        }
        this.size += 1;
        contents[this.size - 1] = item;
    }

    private void doubleCapacity() {
        this.capacity *= 2;
        contents = Arrays.copyOf(contents, capacity);
    }

    @Override
    public String toString() {
        String str = "";
        for (int i = 0; i < this.size; i++) {
            str += "[" + contents[this.size - 1 - i] + "]" + "\n";
        }
        return str;
    }
}
