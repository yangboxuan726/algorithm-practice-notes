import java.util.Arrays;
import java.util.Scanner;

public class 滑动窗口最大值_ACM {
    //https://leetcode.cn/problems/sliding-window-maximum/description/?envType=study-plan-v2&envId=top-100-liked
    public static void main(String[] args) {
        //输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
        //输出：[3,3,5,5,6,7]
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = sc.nextInt();
            }
            int k = sc.nextInt();
            int[] result = maxSlidingWindow(nums, k);
            System.out.println(Arrays.toString(result));
        }
        // 8 1 3 -1 -3 5 3 6 7 3
        //[3, 3, 5, 5, 6, 7]

    }
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n - k + 1]; // 会出现几个窗口
        int[] q = new int[n];
        int head = 0, tail = -1;

        for (int i = 0; i < n; i++) {
            // 1. 右边入
            while (head <= tail && nums[q[tail]] <= nums[i]) { //删除“队尾所有小于等于新元素的元素”
                tail--; // 右边出队
            }
            q[++tail] = i; // 右边入队

            // 2. 左边出
            int left = i - k + 1; // 窗口左端点
            if (q[head] < left) { // 队首离开窗口
                head++;
            }

            // 3. 在窗口左端点处记录答案
            if (left >= 0) {
                // 由于队首到队尾单调递减，所以窗口最大值就在队首
                ans[left] = nums[q[head]];
            }
        }

        return ans;
    }

}



