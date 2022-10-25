import java.util.List;

public class Runner {

    public static void main (String[]args){
        Maze m = new Maze();
        m.loadMaze("maze-2");
        System.out.println(m.toString());
        Square s = new Square(6, 0, 0);
        List<Square> l;
        l = m.getNeighbors(s);
        for (int i = 0; i < l.size(); i++) {
            System.out.println("[" + l.get(i).getRow() + ", " + l.get(i).getCol() + "] - " + l.get(i));
        }

    }

}
