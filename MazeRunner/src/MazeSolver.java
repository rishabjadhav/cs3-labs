import java.lang.invoke.SwitchPoint;
import java.util.List;

public abstract class MazeSolver {

    protected Maze maze;
    private boolean solvable = true;
    private boolean solved = false;

    public MazeSolver(Maze maze) {
        this.maze = maze;
        this.makeEmpty();
        this.add(maze.getStart());
    }

    public abstract void makeEmpty();
    public abstract boolean isEmpty();
    public abstract void add (Square s);
    public abstract Square next();

    public boolean isSolved() {
        if (!solvable || solved) {
            System.out.println("isSolved is true");
            return true;
        }
        System.out.println("isSolved is false");
        return false;

    }

    public void step() {
        if (isEmpty()) {
            solvable = false;
            return;
        }
        Square s = next();
        System.out.println("[" + s.getRow() + ", " + s.getCol() + "] - " + s);

        if (s.getType() == Square.end) {
            System.out.println("End found....");
            solved = true;
            return;
        }
        List<Square> list = maze.getNeighbors(s);

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getType() == Square.empty) {
                if (list.get(i).getStatus() != Square.explored) {
                    add(list.get(i));
                }
            }
            if (list.get(i).getType() == Square.end) {
                add(list.get(i));
            }
        }
        s.setStatus(Square.explored);
    }


    public void solve() {
        if (!isSolved()) {
            step();
        }
        //make everything on final path "X"
    }

    public String getPath() {
        if (solved) {return "Solved!";}
        if (!solved) {return "Not solved yet!";}
        if (solvable) {return "Not solved yet!";}
        if (!solvable) {return "Cannot be solved";}
        return "error";
    }
}
