import java.io.*;
import java.util.Arrays;

public class 移动零_ACM {
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
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

        // 注意 hasNext 和 hasNextLine 的区别
        while (in.nextToken() != StreamTokenizer.TT_EOF) {
            int n = (int)in.nval;
            int[] nums = new int[n];
            for(int i = 0;i < n;i++){
                in.nextToken();
                nums[i] = (int)in.nval;
            }

            moveZeroes(nums);

            for (int i = 0; i < n; i++) {
                if (i > 0) {
                    out.print(" ");
                }
                out.print(nums[i]);
            }
            out.println();
        }
        out.flush();
        out.close();
        br.close();
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
