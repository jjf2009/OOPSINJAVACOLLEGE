import java.util.Scanner;

public class IdentityMatrix {


    static boolean  isIdentity(int mat[][], int N) {
        boolean id = true;
        for (int i = 0; i < N; i++){
            if(mat[i][i]!=1) 
				id= false;
		}
			return id;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of rows of the matrix: ");
        int rows = sc.nextInt();

        System.out.print("Enter number of cols of the matrix: ");
        int cols = sc.nextInt();

        if (rows != cols) {
            System.out.println("Matrix cannot be Identity(not square).");
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

        if (isIdentity(mat, rows)){
            System.out.println("Matrix is Identity");
		}
        else
            System.out.println("Matrix is not Identity");

     

        sc.close();
    }
}
