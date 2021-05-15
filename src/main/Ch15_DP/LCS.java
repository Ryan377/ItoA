package Ch15_DP;

public class LCS {
    public static void main(String[] args) {
        char[] X = {'A', 'B', 'C', 'B', 'D', 'A', 'B'};
        char[] Y = {'B', 'D', 'C', 'A', 'B', 'A'};
        int[][] c = new int[X.length + 1][Y.length + 1];
        int[][] b = new int[X.length + 1][Y.length + 1];
        LCS(X, Y, c, b);
        printLCS(b, X, X.length, Y.length);
    }

    public static void LCS(char[] x, char[] y, int[][] c, int[][] b) {
        int m = x.length;
        int n = y.length;
        for (int i = 0; i <= m; i++) {
            c[i][0] = 0;
        }
        for (int j = 1; j <= n; j++) {
            c[0][j] = 0;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (x[i - 1] == y[j - 1]) {
                    c[i][j] = c[i - 1][j - 1] + 1;
                    b[i][j] = 2;
                } else if (c[i - 1][j] >= c[i][j - 1]) {
                    c[i][j] = c[i - 1][j];
                    b[i][j] = 1;
                } else {
                    c[i][j] = c[i][j - 1];
                    b[i][j] = 0;
                }
            }
        }
    }

    public static void printLCS(int[][] b, char[] X, int i, int j) {
        if (i == 0 || j == 0)
            return;
        if (b[i][j] == 2) {
            printLCS(b, X, i - 1, j - 1);
            System.out.print(X[i - 1] + " ");
        } else if (b[i][j] == 1) {
            printLCS(b, X, i - 1, j);
        } else {
            printLCS(b, X, i, j - 1);
        }
    }
}
