import java.util.*;

public class DpKnapSack {
    public static void knapsack(int[] weights, int[] profits, int bagsize) {
        int n = weights.length;
        int dp[][] = new int[n + 1][bagsize + 1];
        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= bagsize; w++) {
                if (i == 0) {
                    dp[i][w] = 0;
                } else if (weights[i - 1] <= w) {
                    dp[i][w] = Math.max(profits[i - 1] + dp[i - 1][w - weights[i - 1]], dp[i - 1][w]);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }
        int w = bagsize;
        int res = dp[n][w];
        System.out.println("Total profit: " + dp[n][bagsize]);
        for (int i = n; i > 0 && res > 0; i--) {
            if (res != dp[i - 1][w]) {
                System.out.println("The item " + i + " has been included");
                res -= profits[i];
                w -= weights[i];
            }
        }

    }

    public static void main(String[] args) {
        int[] weights = { 2, 4, 5, 6, 8 };
        int[] profits = { 10, 20, 30, 40, 50 };
        int bagsize = 10;
        knapsack(weights, profits, bagsize);
    }
}