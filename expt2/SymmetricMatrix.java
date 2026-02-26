import java.util.Scanner;

public class SymmetricMatrix {

    static void transpose(int mat[][], int tr[][], int N) {
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                tr[i][j] = mat[j][i];
    }

    static boolean isSymmetric(int mat[][], int N) {
        int tr[][] = new int[N][N];
        transpose(mat, tr, N);

        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                if (mat[i][j] != tr[i][j])
                    return false;

        return true;
    }

    static void trace(int mat[][], int N) {
        int sum = 0;
        for (int i = 0; i < N; i++)
            sum += mat[i][i];

        System.out.println("Trace of matrix: " + sum);
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of rows of the matrix: ");
        int rows = sc.nextInt();

        System.out.print("Enter number of cols of the matrix: ");
        int cols = sc.nextInt();
        if (rows != cols) {
            System.out.println("Matrix cannot be symmetric (not square).");
            sc.close();
            return;
        }

        int[][] mat = new int[rows][cols];

        System.out.println("Enter elements of the Matrix:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                mat[i][j] = sc.nextInt();
            }
        }

        if (isSymmetric(mat, rows)){
            System.out.println("Matrix is Symmetric");
		   trace(mat, rows);
		}
        else
            System.out.println("Matrix is not Symmetric");

     

        sc.close();
    }
}
