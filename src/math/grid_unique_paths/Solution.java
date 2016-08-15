package math.grid_unique_paths;

/**
 * Created by user on 08/08/16.
 */
public class Solution {

    public static int uniquePaths(int m, int n) {

        long ans = 1;
        for (int i = n; i < (m + n - 1); i++) {
            ans *= i;
            ans /= (i - n + 1);
        }
        return (int)ans;
    }

}
