import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 三数之和 {
    public static void main(String[] args) {

    }
    public List<List<Integer>> threeSum(int[] nums){
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i <n-2 ;i++){
            if(i > 0 && i == nums[i-1]) continue;
            if (nums[i] + nums[i+1] + nums[i+2] >0) break;
            if(nums[i] + nums[n-2] + nums[n-1] < 0) continue;
            int j = i + 1;
            int k = n - 1;
            while (j < k){
                int sum = nums[i] + nums[j] + nums[k];
                if (sum < 0){
                    j++;
                }else if(sum > 0){
                    k--;
                }else {
                    ans.add(List.of(nums[i],nums[j],nums[k]));
                    for (j++; j < k && nums[j] == nums[j - 1]; j++); // 跳过重复数字
                    for (k--; k > j && nums[k] == nums[k + 1]; k--); // 跳过重复数字


                }
            }


        }
        return ans;
    }
}
