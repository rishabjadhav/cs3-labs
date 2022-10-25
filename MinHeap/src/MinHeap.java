public class MinHeap {
    private Integer[] heap;
    private int size;
    private static final int DEFAULT_CAPACITY = 8;

    public MinHeap() {
        this.heap = new Integer[DEFAULT_CAPACITY - 1];
    }

    public int getSize() {
        return this.size;
    }

    public boolean isEmpty() {
        if (this.size == 0) {
            return true;
        }
        return false;
    }

    public int peekMinimum() {
        return this.heap[0]; //returns lowest number in the heap, defined as the first number
    }

    public int getLeftChildIndex(int i) {
        return (2 * i);
    }
    public int getRightChildIndex(int i) {
        return (2 * i) + 1;
    }
    public int getParentIndex(int i) {
        return i / 2;
    }

    public void doubleCapacity() {
        Integer[] dupe = this.heap.clone(); //creates a copy of the heap array
        this.heap = new Integer[(this.heap.length - 1) * 2]; //doubles the original heap size
        System.arraycopy(dupe, 0, this.heap, 0, dupe.length); //copies the array to the system
    }

    public void insert(int val) {
        if (this.size >= this.heap.length - 1) {
            doubleCapacity();
        }
        this.size++;
        heap[getParentIndex(val)] = val;
        this.heap[this.size] = val;
        bubbleUp(this.size);
    }

    public void bubbleUp(int index) {
        if (index > 1) {
            int parentIndex = getParentIndex(index);
            int parentVal = this.heap[parentIndex];
            int indexVal = this.heap[index];

            if (indexVal < parentVal) {
                this.heap[index] = parentVal;
                this.heap[parentIndex] = indexVal;
                bubbleUp(parentIndex);
            }
        }
    }

    public int popMinimum() {
        int minVal = heap[1];
        heap[1] = heap[size];
        siftDown(1);
        this.size--;
        return minVal;
    }



    public void siftDown(int i) {
        if (i > size) {
            return;
        }
        int leftChild = getLeftChildIndex(i);
        int rightChild = getRightChildIndex(i);

        if ((this.heap[rightChild] == null) || (this.heap[leftChild] < this.heap[rightChild])) {
            if (this.heap[i] > this.heap[leftChild]) {
                int heapVal = this.heap[i];
                this.heap[i] = this.heap[leftChild];
                this.heap[leftChild] = heapVal;
                siftDown(leftChild);
            }
        }
        else {
            if (this.heap[i] > this.heap[rightChild]) {
                int heapVal = this.heap[i];
                this.heap[i] = this.heap[rightChild];
                this.heap[rightChild] = heapVal;
                siftDown(rightChild);
            }
        }
    }

    @Override
    public String toString()
    {
        String str = "HEAP : ";
        for (int i = 1; i < getSize() - 1; i++) {
            str += heap[i];
        }
        return str.substring(0, str.lastIndexOf(","));
    }


    public void display() {
        int slots = 32;
        int columns = 0;
        int rows = 0;
        int i = 0;
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        while (i <= this.getSize()) {
            System.out.print((heap[i] == null));

            if ((rows - 1) == columns) {
                System.out.println();
                slots /= 2;
                rows *= 2;
                columns = 0;
            } else {
                i++;
            }
        }
        System.out.println("\n" + "~~~~~~~~~~~~~~~~~~~~~");
    }
}