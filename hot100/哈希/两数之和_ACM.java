import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 两数之和_ACM {
    //https://leetcode.cn/problems/two-sum/description/?envType=study-plan-v2&envId=top-100-liked
    public static void main(String[] args) {
        //int[] nums = {2, 7, 11, 15};
        //int target = 9;
        //int[] result = twoSum(nums, target);
        //System.out.println(result[0] + " " + result[1]);
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = sc.nextInt();
            }
            int target = sc.nextInt();
            int[] result = twoSum(nums, target);
            System.out.println(result[0] + " " + result[1]);
        }
        //4 2 7 11 15 9 -> 0 1
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int need = target - nums[i];
            if (map.containsKey(need)) {
                return new int[]{map.get(need), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }
}
