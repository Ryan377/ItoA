package Ch15_DP;

public class RodCutting {
    public static void main(String[] args) {
        int[] p = {1, 5, 8, 9, 10, 17, 17, 20, 24, 30};
        int n = 9;
        int ans;
        //ans = cutRod(p, n);
        //ans = memoCutRod(p ,n);
        ans = bottomUpCutRod(p, n);
        System.out.println(ans);
    }

    // 自顶向下递归
    public static int cutRod(int[] p, int n) {
        if (n == 0) {
            return 0;
        }
        int q = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            q = Math.max(q, p[i] + cutRod(p, n - i - 1));
        }
        return q;
    }

    // 动态规划，自顶向下带备忘录
    public static int memoCutRod(int[] p, int n) {
        int[] dp = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            dp[i] = Integer.MIN_VALUE;
        }
        return memoCutRodAux(p, n, dp);
    }

    public static int memoCutRodAux(int[] p, int n, int[] dp) {
        if(dp[n] >= 0)
            return dp[n];
        int ans;
        if (n == 0)
            ans = 0;
        else {
            ans = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                ans = Math.max(ans, p[i] + memoCutRodAux(p, n - i - 1, dp));
            }
        }
        dp[n] = ans;
        return ans;
    }

    // 自底向上版本
    public static int bottomUpCutRod(int[] p, int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            int ans = Integer.MIN_VALUE;
            for (int j = 1; j <= i; j++) {
                ans = Math.max(ans, p[j - 1] + dp[i - j]);
            }
            dp[i] = ans;
        }
        return dp[n];
    }
}
