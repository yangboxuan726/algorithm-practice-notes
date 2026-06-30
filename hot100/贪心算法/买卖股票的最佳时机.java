public class 买卖股票的最佳时机 {
    //https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/description/?envType=study-plan-v2&envId=top-100-liked

    public static void main(String[] args) {
        int[] nums = {7,1,5,3,6,4};
        int result = maxProfit(nums);
        System.out.println(result);

    }
    public static int maxProfit(int[] prices) {
        int ans = 0;
        for(int i = 1,min = prices[0];i < prices.length;i++){
            min = Math.min(min,prices[i]);
            ans = Math.max(ans,prices[i] - min);
        }
        return ans;

    }

}
