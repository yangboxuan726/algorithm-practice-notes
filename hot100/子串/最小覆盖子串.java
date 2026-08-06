public class 最小覆盖子串 {
    //https://leetcode.cn/problems/minimum-window-substring/description/?envType=study-plan-v2&envId=top-100-liked
    public static void main(String[] args) {
        //输入：s = "ADOBECODEBANC", t = "ABC"
        //输出："BANC"
        String s = "ADOBECODEBANC";
        String p = "ABC";

        String result = minWindow(s, p);
        System.out.println(result);


    }
    public static String minWindow(String str, String tar) {
        char[] s = str.toCharArray();
        char[] t = tar.toCharArray();
        // 每种字符的欠债情况
        // cnts[i] = 负数，代表字符i有负债
        // cnts[i] = 正数，代表字符i有盈余

        int[] cnts = new int[256];
        for (char cha : t) {
            cnts[cha]--;
        }
        // 最小覆盖子串的长度
        int len = Integer.MAX_VALUE;
        int start = 0;

        int debt = t.length;
        for (int l = 0, r = 0; r < s.length; r++) {
            if (cnts[s[r]]++ < 0) {
                debt--;
            }
            if (debt == 0) {
                while (cnts[s[l]] > 0) {
                    cnts[s[l]]--;
                    l++;
                }
                if (r - l + 1 < len) {
                    len = r - l + 1;
                    start = l;
                }

            }
        }
        return len == Integer.MAX_VALUE ? "" : str.substring(start, start + len);

    }
}
