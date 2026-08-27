
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 合并区间_ACM {
    //https://leetcode.cn/problems/merge-intervals/?envType=study-plan-v2&envId=top-100-liked
    public static void main(String[] args) {
        //输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
        //输出：[[1,6],[8,10],[15,18]]
        int[][] nums = {{1,3},{2,6},{8,10},{15,18}};
        int[][] result = merge(nums);
        System.out.println(Arrays.deepToString(result));
        //System.out.println(Arrays.toString(arr));这个只能打印一维数组

    }
    public static int[][] merge(int[][] intervals){
        Arrays.sort(intervals, (p, q) -> p[0] - q[0]); // 按照左端点从小到大排序

        List<int[]> ans = new ArrayList<>();
        for (int[] p : intervals){
            int m = ans.size();

            if (m > 0 && p[0] <= ans.get(m - 1)[1]) {
                ans.get(m-1)[1] = Math.max(p[1], ans.get(m-1)[1]);
            }else {
                ans.add(p);
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }

}
