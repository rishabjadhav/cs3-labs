public class FireModel
{
    public static int SIZE = 47;
    private FireCell[][] myGrid;
    private FireView myView;

    public FireModel(FireView view)
    {
        myGrid = new FireCell[SIZE][SIZE];
        int setNum = 0;
        for (int r=0; r<SIZE; r++)
        {
            for (int c=0; c<SIZE; c++)
            {
                myGrid[r][c] = new FireCell();
            }
        }
        myView = view;
        myView.updateView(myGrid);
    }

    /*
        recursiveFire method here
     */

    public void spread(int row, int col) {
        if (row < 0 || row >= SIZE || col < 0 || col >= SIZE) {
            return;
        }

        if (myGrid[row][col].getStatus() == FireCell.GREEN) {
            myGrid[row][col].setStatus(FireCell.BURNING);
            myView.updateView(myGrid);

            spread(row + 1, col);
            spread(row, col + 1);
            spread(row - 1, col);
            spread(row, col-1);
        }


    }

    public void solve()
    {
        for (int i = 0; i < SIZE; i++) {
            spread(SIZE-1, i);
        }

        for (int j = 0; j < SIZE; j++) {
            if (myGrid[0][j].getStatus() == FireCell.BURNING) {
                System.out.println("ONETT IS IN DANGER");
                myView.updateView(myGrid);
                return;
            }
        }
        System.out.println("ONETT IS SAFE");
        myView.updateView(myGrid);
        return;
    }

}
