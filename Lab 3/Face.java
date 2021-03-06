class Face implements Cloneable {

    private final int[][] grid;

    Face(int[][] grid) {
        this.grid = grid;
    }

    Face right() {
        int rows = this.grid.length;
        int columns = this.grid[0].length;
        int[][] newgrid = new int[rows][columns];
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < columns; c++) {
                newgrid[c][rows - r - 1] = grid[r][c];
            }
        }
        return new Face(newgrid);
    }

    Face left() {
        return this.right().right().right();
    }

    Face half() {
        return this.right().right();
    }

    int[][] toIntArray() {
        return this.grid;
    }

    @Override
    public String toString() {

        String output = "\n";
        for (int i = 0; i < this.grid.length; i++) {
            for (int x = 0; x < this.grid[0].length; x++) {
                output += String.format("%02d",this.grid[i][x]);
            }
            output += "\n";
        }
        return output;
    }

    @Override
    public Face clone() {
        int[][] newGrid = new int[this.grid.length][this.grid[0].length];
        for (int i = 0; i < newGrid.length; i++) {
            for (int x = 0; x < newGrid[0].length; x++) {
                newGrid[i][x] = this.grid[i][x];
            }
        }

        return new Face(newGrid);
    }
}
