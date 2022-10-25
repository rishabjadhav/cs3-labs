public class MazeSolverStack extends MazeSolver {

    MyStack worklist;

    public MazeSolverStack(Maze maze) {
        super(maze);
    }

    @Override
    public void makeEmpty() {
        worklist = new MyStack();
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void add(Square s) {
        worklist.push(s);
    }

    @Override
    public Square next() {
        return worklist.pop();
    }
}
