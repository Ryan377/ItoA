package Ch16_Greedy;

public class ActivitySelect {
    public static void main(String[] args) {
        int[] s = { 1, 3, 0, 5, 3, 5, 6, 8, 8, 2, 12 };
        int[] f = { 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14 };
        boolean[] a = new boolean[s.length];

        int result = greedySelector(s, f, a);
        System.out.println("Result is: " + result);
        for (int i = 0; i <= s.length - 1; i++) {
            if (a[i]) {
                int temp = i + 1;
                System.out.println("第" + temp + "活动被选中，其开始时间为：" + s[i] + "，结束时间为：" + f[i]);
            }
        }
    }

    public static int greedySelector(int[] s, int[] f, boolean[] a) {
        int n = s.length - 1;
        a[0] = true;
        int j = 1;
        int count = 1;
        for (int i = 1; i <= n; i++) {
            if (s[i] >= f[j]) {
                a[i] = true;
                j = i;
                count++;
            } else {
                a[i] = false;
            }

        }
        return count;

    }
}
