package 字符串;

//纵向扫描
public class _14_最长公共前缀 {
    public String longestCommonPrefix(String[] strs) {
        int len = Integer.MAX_VALUE; //公共前缀至多有多长 = 字符串数组中最短的字符串长度
        for (String str : strs) {
            int s_len = str.length();
            if (s_len < len) {
                len = s_len;
            }
        }

        //记录最长前缀
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            char tmp = strs[0].charAt(i); //拿出第一个字符串的第i个字符来逐一比较
            for (String str : strs) {
                if (str.charAt(i) != tmp) {
                    return String.valueOf(sb);
                }
            }
            sb.append(tmp);
        }
        return String.valueOf(sb);
    }

}
