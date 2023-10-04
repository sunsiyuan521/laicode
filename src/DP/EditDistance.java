package DP;

import java.util.Arrays;

public class EditDistance {
    public int editDistance(String one, String two) {
        int[][] dp = new int[one.length() + 1][two.length() + 1];
        for(int i = 0; i <= one.length(); i++) {
            for(int j = 0; j <= two.length(); j++) {
                if(i == 0) {
                    dp[i][j] = j;
                } else if(j == 0) {
                    dp[i][j] = i;
                } else if(one.charAt(i - 1) == two.charAt(j - 1)) {
                    System.out.println(one.charAt(i - 1));
                    System.out.println(one.charAt(j - 1));
                    dp[i][j] = dp[i - 1][j - 1];
                    System.out.println(Arrays.deepToString(dp));
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1);
                    dp[i][j] = Math.min(dp[i - 1][j - 1] + 1, dp[i][j]);
                    System.out.println(Arrays.deepToString(dp));
                }
            }
        }


        return dp[one.length()][two.length()];
    }

}
