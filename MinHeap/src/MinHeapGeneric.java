public class MinHeapGeneric<T extends Comparable<T>> {
    private T[] heap;

    private int size;
    private static final int DEFAULT_CAPACITY = 8;

    public MinHeapGeneric () {
        this.heap = new T[DEFAULT_CAPACITY - 1];
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

    public T peekMinimum() {
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
        T[] dupe = this.heap.clone(); //creates a copy of the heap array
        //heap.length *= 2;
        System.arraycopy(dupe, 0, this.heap, 0, dupe.length); //copies the array to the system
    }

    public void insert(T val) {
        if (this.size >= this.heap.length - 1) {
            doubleCapacity();
        }
        this.size++;
        heap[getParentIndex(heap.length)] = val;
        this.heap[this.size] = val;
        bubbleUp(this.size);
    }

    public void bubbleUp(int index) {
        if (index > 1) {
            int parentIndex = getParentIndex(index);
            T parentVal = this.heap[parentIndex];
            T indexVal = this.heap[index];

            if (indexVal.compareTo(parentVal) > 0) {
                this.heap[index] = parentVal;
                this.heap[parentIndex] = indexVal;
                bubbleUp(parentIndex);
            }
        }
    }

    public T popMinimum() {
        T minVal = heap[1];
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

        if ((heap[rightChild] == null) || (heap[leftChild].compareTo(heap[rightChild]) > 0 )) {
            if (heap[i].compareTo(heap[leftChild]) > 0) {
                T heapVal = heap[i];
                heap[i] = heap[leftChild];
                heap[leftChild].equals(heapVal);
                siftDown(leftChild);
            }
        }
        else {
            if (heap[i].compareTo(heap[rightChild]) < 0){
                T heapVal = heap[i];
                heap[i] = heap[rightChild];
                heap[rightChild] = heapVal;
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
