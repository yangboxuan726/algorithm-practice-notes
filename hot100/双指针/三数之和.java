import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 三数之和 {
    //https://leetcode.cn/problems/3sum/?envType=study-plan-v2&envId=top-100-liked
    public static void main(String[] args) {
        //输入：nums = [-1,0,1,2,-1,-4]
        //输出：[[-1,-1,2],[-1,0,1]]
        int[] arr = {-1,0,1,2,-1,-4};
        List<List<Integer>> lists = threeSum(arr);
        System.out.println(lists);

    }

    public  static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n - 2; i++) {
            int x = nums[i];
            if( i > 0 && x == nums[i-1]){
                continue;
            }
            if(x + nums[i+1] + nums[i+2] > 0) break;
            if(x + nums[n-2] + nums[n-1] < 0) continue;

            int j = i + 1;
            int k = n - 1;
            while (j < k) {
                int s = x + nums[j] + nums[k];
                if (s > 0){
                    k--;
                } else if (s < 0) {
                    j++;
                }else {
                    ans.add(List.of(x,nums[j],nums[k]));
                    for (j++;j < k && nums[j] == nums[j-1];j++);
                    for (k--;k > j && nums[k] == nums[k+1];k--);
                }
            }
        }
        return ans;
    }
}
