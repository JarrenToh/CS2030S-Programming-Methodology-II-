abstract class Rubik implements Cloneable {

    private final int [][][]grid;

    private static final int upNo = 0;
    private static final int leftNo = 1;
    private static final int frontNo = 2;
    private static final int rightNo = 3;
    private static final int downNo = 4;
    private static final int backNo = 5;


    protected Rubik(int[][][] grid) {
        this.grid = grid;
    }

    public int[][][] getGrid() {
        return this.grid;
    }

    abstract Rubik right();

    abstract Rubik left();

    abstract Rubik half();

    abstract Rubik rightView();

    abstract Rubik leftView();

    abstract Rubik upView();

    abstract Rubik downView();

    abstract Rubik backView();

    abstract Rubik frontView();

    @Override
    public String toString() {
        String whitespaces = "......";
        String output = "\n";

        for (int row = 0; row < this.grid[upNo].length; row++) {

            output += whitespaces;

            for (int column = 0; column < this.grid[upNo][row].length; column++) {

                output += String.format("%02d", this.grid[upNo][row][column]);

            }

            output += whitespaces + "\n";
        }

        for (int row = 0; row < this.grid[leftNo].length; row++) {

            for (int column = 0; column < this.grid[leftNo][row].length; column++) {

                output += String.format("%02d", this.grid[leftNo][row][column]);
            }

            for (int column = 0; column < this.grid[frontNo][row].length; column++) {

                output += String.format("%02d", this.grid[frontNo][row][column]);
            }

            for (int column = 0; column < this.grid[rightNo][row].length; column++) {

                output += String.format("%02d", this.grid[rightNo][row][column]);
            }

            output += "\n";
        } 

        for (int row = 0; row < this.grid[downNo].length; row++) {

            output += whitespaces;

            for (int column = 0; column < this.grid[downNo][row].length; column++) {

                output += String.format("%02d", this.grid[downNo][row][column]);

            }

            output += whitespaces + "\n";
        }

        for (int row = 0; row < this.grid[backNo].length; row++) {

            output += whitespaces;

            for (int column = 0; column < this.grid[backNo][row].length; column++) {

                output += String.format("%02d", this.grid[backNo][row][column]);

            }

            output += whitespaces + "\n";
        }


        return output;
    }

    public abstract Rubik clone();



}
