package 每日一题;

public class _2678_老人的数目 {
    public int countSeniors(String[] details) {
        int count = 0;
        for (String detail : details) {
            String age_str = detail.substring(11, 13);
            int age = Integer.parseInt(age_str);
            if (age > 60) {
                count++;
            }
        }
        return count;
    }

}
