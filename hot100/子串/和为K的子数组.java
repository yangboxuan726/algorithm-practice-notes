import java.util.HashMap;
import java.util.Map;

public class 和为K的子数组 {
    //https://leetcode.cn/problems/subarray-sum-equals-k/?envType=study-plan-v2&envId=top-100-liked
    public static void main(String[] args) {
        //输入：nums = [1,2,3], k = 3
        //输出：2
        int[] nums = {1,2,3};
        int k = 3;
        int count = subarraySum(nums, k);
        System.out.println(count);

    }

    public  static  int subarraySum(int[] nums,int k){
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int sum = 0;
        int ans = 0;
        for (int num :nums){
            sum = sum + num;
           ans += map.getOrDefault(sum - k,0);
           map.put(sum,map.getOrDefault(sum,0)+1);

        }
        return  ans;
    }
}


