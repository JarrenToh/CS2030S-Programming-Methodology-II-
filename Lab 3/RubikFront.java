class RubikFront extends Rubik {

    private static final int noOfFace = 6;
    private final Face[] rubikFaces = new Face[noOfFace];
    private final int[][][] grid;
    private static final int upNo = 0;
    private static final int leftNo = 1;
    private static final int frontNo = 2;
    private static final int rightNo = 3;
    private static final int downNo = 4;
    private static final int backNo = 5;

    RubikFront(int[][][] grid) {
        super(grid);
        this.grid = grid;

        for (int face = 0; face < grid.length; face++) {
            rubikFaces[face] = new Face(grid[face]);
        }
    }

    @Override
    Rubik right() {
        //this.rubikFaces[frontNo] = this.rubikFaces[frontNo].clone().right();
        int[][] up = this.rubikFaces[upNo].clone().toIntArray();
        int[][] left = this.rubikFaces[leftNo].clone().toIntArray();
        int[][] front = this.rubikFaces[frontNo].right().clone().toIntArray();
        int[][] right = this.rubikFaces[rightNo].clone().toIntArray();
        int[][] down = this.rubikFaces[downNo].clone().toIntArray();
        int[][] back = this.rubikFaces[backNo].clone().toIntArray();
        final int noOfMoves = 3;

        for (int i = 0; i < noOfMoves; i++) {
            int tempUp = up[2][i];
            int tempLeft = left[2 - i][2];
            int tempRight = right[i][0];
            int tempDown = down[0][2 - i];

            up[2][i] = tempLeft;
            left[2 - i][2] = tempDown;
            right[i][0] = tempUp;
            down[0][2 - i] = tempRight;
        }

        int[][][] newGrid = {up,left,front,right,down,back};

        return new RubikFront(newGrid);
    }

    @Override
    Rubik left() {
        return this.right().right().right();
    }

    @Override
    Rubik half() {
        return this.right().right();
    }
    
    @Override
    public Rubik clone() {
        int[][][] newGrid = new int[this.grid.length][this.grid[0].length][this.grid[0][0].length];
        for (int face = 0; face < this.grid.length; face++) {
            for (int row = 0; row < this.grid[face].length; row++) {
                for (int column = 0; column < this.grid[face][row].length; column++) {
                    newGrid[face][row][column] = this.grid[face][row][column];
                }
            }
        }
        return new RubikFront(newGrid);
    }

    @Override
    Rubik upView() {

        int[][] up = this.rubikFaces[upNo].clone().toIntArray();
        int[][] left = this.rubikFaces[leftNo].clone().right().toIntArray();
        int[][] front = this.rubikFaces[frontNo].clone().toIntArray();
        int[][] right = this.rubikFaces[rightNo].clone().left().toIntArray();
        int[][] down = this.rubikFaces[downNo].clone().toIntArray();
        int[][] back = this.rubikFaces[backNo].clone().toIntArray();
        int[][][] newGrid = {back,left,up,right,front,down};

        return new RubikFront(newGrid);
    }

    @Override
    Rubik downView() {
        return this.upView().upView().upView();
    }

    @Override
    Rubik rightView() {
        int[][] up = this.rubikFaces[upNo].clone().right().toIntArray();
        int[][] left = this.rubikFaces[leftNo].clone().half().toIntArray();
        int[][] front = this.rubikFaces[frontNo].clone().toIntArray();
        int[][] right = this.rubikFaces[rightNo].clone().toIntArray();
        int[][] down = this.rubikFaces[downNo].clone().left().toIntArray();
        int[][] back = this.rubikFaces[backNo].clone().half().toIntArray();
        int[][][] newGrid = {up,front,right,back,down,left};

        return new RubikFront(newGrid);
    }

    @Override
    Rubik leftView() {
        return this.rightView().rightView().rightView();
    }

    @Override
    Rubik backView() {
        return this.rightView().rightView();
    }

    @Override
    Rubik frontView() {
        return new RubikFront(this.grid);
    }
}
