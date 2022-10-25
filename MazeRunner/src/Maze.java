import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

        public class Maze {

            private Square[][] maze;
            private Square start;
            private Square end;


            public Maze() {

            }

            public boolean loadMaze(String fileName) {
                try {
                    File f = new File(fileName);
                    Scanner reader = new Scanner(f);
                    if (reader.hasNextLine()) {
                        maze = new Square[reader.nextInt()][reader.nextInt()];
                    }

                    if (reader.hasNextLine()) {
                        for (int row = 0; row < maze.length; row++) {
                            for (int col = 0; col < maze[0].length; col++) {
                                Square s = new Square(row, col, reader.nextInt());
                                maze[row][col] = s;
                            }
                        }
                    }
                    reader.close();
                }
                catch (FileNotFoundException e) {
                    System.out.println("Error Reading File - " + fileName);
                    e.printStackTrace();
                    return false;
                }
                return true;
            }

            public List<Square> getNeighbors(Square s) {
                List<Square> list = new ArrayList<Square>();
                int row = s.getRow();
                int col = s.getCol();

                //North
                if (row > 0) {
                    list.add(maze[row - 1][col]);
                }

                //East
                if (col < maze[0].length - 1) {
                    list.add(maze[row][col + 1]);
                }

                //South
                if (row < maze.length - 1) {
                    list.add(maze[row + 1][col]);
                }

                //West
                if (col > 0) {
                    list.add(maze[row][col - 1]);
                }
                return list;
            }

            public Square getStart() {
                //start = 2
                for (int row = 0; row < maze.length; row++) {
                    for (int col = 0; col < maze[0].length; col++) {
                        if (maze[row][col].getType() == Square.start){
                            return maze[row][col];
                        }
                    }
                }
                return null;
            }

            public Square getExit() {
                //end == 3
                for (int row = 0; row < maze.length; row++) {
                    for (int col = 0; col < maze[0].length; col++) {
                        if (maze[row][col].getType() == Square.end){
                            return maze[row][col];
                        }
                    }
                }
                return null;
            }

            public void reset() {
                for (int row = 0; row < maze.length; row++) {
                    for (int col = 0; col < maze[0].length; col++) {
                        maze[row][col].setStatus(0);
                    }
                }
            }

            public String toString() {
                String str = "";
                for (int row = 0; row < maze.length; row++) {
                    for (int col = 0; col < maze[0].length; col++) {
                        str += maze[row][col].toString() + " ";
                    }
                    str += "\n";
                }
                return str;
            }
        }