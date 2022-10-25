public class MazeSolverQueue extends MazeSolver {
    private MyQueue<Square> worklist;

    public MazeSolverQueue(Maze maze) {
        super(maze);
    }

    @Override
    public void makeEmpty() {
        worklist.clear();
    }

    @Override
    public boolean isEmpty() {
        if (worklist.isEmpty()) {
            return true;
        }
        return false;
    }

    @Override
    public void add(Square s) {
        worklist.offer(s);

    }

    @Override
    public Square next() {
        return worklist.peek();
    }
}
