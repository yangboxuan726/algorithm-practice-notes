import java.util.Scanner;

public class 买卖股票的最佳时机_ACM {
    //https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/description/?envType=study-plan-v2&envId=top-100-liked

    public static void main(String[] args) {
        //int[] nums = {7, 1, 5, 3, 6, 4}; //5
        //int result = maxProfit(nums);
        //System.out.println(result);
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()){
            int m = sc.nextInt();
            int[] nums = new int[m];
            for (int i = 0; i < m ;i++){
                nums[i]  = sc.nextInt();
            }
            int result = maxProfit(nums);
            System.out.println(result);
        }
        //6 7 1 5 3 6 4 -> 5
    }

    public static int maxProfit(int[] prices) {
        int ans = 0;
        for (int i = 1, min = prices[0]; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            ans = Math.max(ans, prices[i] - min);

        }
        return ans;
    }

}
