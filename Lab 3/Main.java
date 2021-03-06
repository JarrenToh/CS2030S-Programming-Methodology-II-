import java.util.Scanner;

class Main {
    static final int NFACES = 6;
    static final int NROWS = 3;
    static final int NCOLS = 3;

    static Rubik oneMove(Rubik rubik, String move) {
        //System.out.print("Face " + move.charAt(0));

        if (move.length() == 1) {
            if (move.charAt(0) == 'F') {
                return rubik.right();
            } else if (move.charAt(0) == 'R') {
                return new RubikRight(rubik).right();
            } else if (move.charAt(0) == 'U') {
                return new RubikUp(rubik).right();
            } else if (move.charAt(0) == 'L') {
                return new RubikLeft(rubik).right();
            } else if (move.charAt(0) == 'B') {
                return new RubikBack(rubik).right();
            } else if (move.charAt(0) == 'D') {
                return new RubikDown(rubik).right();
            }

            //System.out.println(" right turn");
        } else {
            if (move.charAt(1) == '\'') {
                //System.out.println(" left turn");
                if (move.charAt(0) == 'F') {
                    return rubik.left();
                } else if (move.charAt(0) == 'R') {
                    return new RubikRight(rubik).left();
                } else if (move.charAt(0) == 'U') {
                    return new RubikUp(rubik).left();
                } else if (move.charAt(0) == 'L') {
                    return new RubikLeft(rubik).left();
                } else if (move.charAt(0) == 'B') {
                    return new RubikBack(rubik).left();
                } else if (move.charAt(0) == 'D') {
                    return new RubikDown(rubik).left();
                }
            } else {
                //System.out.println(" half turn");
                if (move.charAt(0) == 'F') {
                    return rubik.half();
                } else if (move.charAt(0) == 'R') {
                    return new RubikRight(rubik).half();
                } else if (move.charAt(0) == 'U') {
                    return new RubikUp(rubik).half();
                } else if (move.charAt(0) == 'L') {
                    return new RubikLeft(rubik).half();
                } else if (move.charAt(0) == 'B') {
                    return new RubikBack(rubik).half();
                } else if (move.charAt(0) == 'D') {
                    return new RubikDown(rubik).half();
                }
            }
        }

        return rubik;
    }


    public static void main(String[] args) {
        int[][][] grid = new int[NFACES][NROWS][NCOLS];

        Scanner sc = new Scanner(System.in);
        for (int k = 0; k < NFACES; k++) {
            for (int i = 0; i < NROWS; i++) {
                for (int j = 0; j < NCOLS; j++) {
                    grid[k][i][j] = sc.nextInt();
                }
            }
        }
        Rubik rubik = new RubikFront(grid);

        while (sc.hasNext()) {
            rubik = oneMove(rubik, sc.next());
        }
        System.out.println(rubik);
    }
}
