import javax.sql.rowset.spi.SyncResolver;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class 最长连续序列_ACM {
    //https://leetcode.cn/problems/longest-consecutive-sequence/?envType=study-plan-v2&envId=top-100-liked
    public static void main(String[] args) {
        //int[] nums = {100, 4, 200, 1, 3, 2};
        //int result = longestConsecutive(nums);
        //System.out.println(result);
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = sc.nextInt();
            }
            int result = longestConsecutive(nums);
            System.out.println(result);
        }

        // 6 100 4 200 1 3 2 -> 4
    }

    public static int longestConsecutive(int[] nums) {
        Set<Integer> st = new HashSet<>();
        for (int num : nums) {
            st.add(num);
        }
        int ans = 0;
        for (int x : st) {
            if (st.contains(x - 1)) {
                continue;
            }

            int y = x + 1;
            while (st.contains(y)) {
                y++;
            }
            ans = Math.max(ans, y - x);
        }
        return ans;
    }
}
