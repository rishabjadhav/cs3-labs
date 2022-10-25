public class Square {

    public static final int empty = 0;
    public static final int wall = 1;
    public static final int start = 2;
    public static final int end = 3;

    public static final int worklist = 4;
    public static final int explored = 5;
    public static final int fPath = 6;

    private int row;
    private int col;
    private int type;
    private int status;

    public Square(int row, int col, int type) {
        this.row = row;
        this.col = col;
        this.type = type;
    }

    @Override
    public String toString() {
        if (this.getType() == empty) {
            if (status == worklist) {
                return "o";
            }
            if (status == explored) {
                return ".";
            }
            if (status == fPath) {
                return "x";
            }
            return "_";
        }
        else if (this.getType() == wall) {
            return "#";
        }
        else if (this.getType() == start) {
            return "S";
        }
        else if (this.getType() == end) {
            return "E";
        } else {
            return "error";
        }
    }

    public boolean equals (Square s) {
        if (s.getCol() == this.getCol() && s.getRow() == this.getRow()) {
            return true;
        }
        return false;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public int getType() {
        return type;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int s) {
        status = s;
    }
}
