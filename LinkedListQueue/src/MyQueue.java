public class MyQueue<T> implements QueueADT {
    MyLinkedList<T> queue;


    @Override
    public void offer(Object item) {
        queue.add((T) item);
    }

    @Override
    public T poll() {
        return queue.remove(queue.size() - 1);
    }

    @Override
    public T peek() {
        return queue.get(queue.size() - 1);
    }

    @Override
    public int size() {
        return queue.size();
    }

    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    @Override
    public void clear() {
        queue = new MyLinkedList<T>();
    }
}
