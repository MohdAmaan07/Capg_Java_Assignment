public class Matrix {

    public static int[][] multiply(int[][] a, int[][] b) {
        int r1 = a.length;
        int c1 = a[0].length;
        int c2 = b[0].length;

        int[][] result = new int[r1][c2];

        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c2; j++) {
                for (int k = 0; k < c1; k++) {
                    result[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return result;
    }

    public static int[][] transpose(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        int[][] transposed = new int[c][r];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                transposed[j][i] = matrix[i][j];
            }
        }
        return transposed;
    }

    public static int[][] flip(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        int[][] flipped = new int[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                flipped[i][j] = matrix[i][c - 1 - j];
            }
        }
        return flipped;
    }

    public static int[][] rotate(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        int[][] rotated = new int[c][r];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                rotated[j][r - 1 - i] = matrix[i][j];
            }
        }
        return rotated;
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[][] A = {
            {1, 2},
            {3, 4}
        };

        int[][] B = {
            {5, 6},
            {7, 8}
        };

        System.out.println("Multiplication:");
        printMatrix(multiply(A, B));

        System.out.println("Transpose:");
        printMatrix(transpose(A));

        System.out.println("Flip:");
        printMatrix(flip(A));

        System.out.println("Rotate 90°:");
        printMatrix(rotate(A));
    }
}
