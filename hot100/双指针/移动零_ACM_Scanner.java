import java.util.Arrays;
import java.util.Scanner;

public class 移动零_ACM_Scanner {
    //https://leetcode.cn/problems/move-zeroes/description/?envType=study-plan-v2&envId=top-100-liked
    /*
    给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
    请注意 ，必须在不复制数组的情况下原地对数组进行操作。
    示例 1:
    输入: nums = [0,1,0,3,12]
    输出: [1,3,12,0,0]
    示例 2:
    输入: nums = [0]
    输出: [0]
    */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            int[] nums = new int[n];

            for (int i = 0; i < n; i++) {
                nums[i] = scanner.nextInt();
            }

            moveZeroes(nums);

            StringBuilder result = new StringBuilder();
            for (int i = 0; i < n; i++) {
                if (i > 0) {
                    result.append(' ');
                }
                result.append(nums[i]);
            }
            System.out.println(result);
        }

        scanner.close();
    }

    public static void moveZeroes(int[] nums) {
        int stackSize = 0;
        for (int x : nums) {
            if (x != 0) {
                nums[stackSize++] = x;
            }

        }
        Arrays.fill(nums, stackSize, nums.length, 0);
    }
}
