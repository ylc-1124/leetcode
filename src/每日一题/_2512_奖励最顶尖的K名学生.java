package 每日一题;

import java.util.*;

public class _2512_奖励最顶尖的K名学生 {
    public List<Integer> topStudents(String[] positive_feedback,
                                     String[] negative_feedback,
                                     String[] report,
                                     int[] student_id,
                                     int k) {
        List<Integer> res = new ArrayList<>();
        StuInfo[] infos = new StuInfo[student_id.length]; // 学生的分数

        Set<String> pos_word = new HashSet<>();
        Set<String> neg_word = new HashSet<>();
        for (int i = 0; i < positive_feedback.length; i++) {
            pos_word.add(positive_feedback[i]);
        }
        for (int i = 0; i < negative_feedback.length; i++) {
            neg_word.add(negative_feedback[i]);
        }

        for (int i = 0; i < report.length; i++) {
            int score = 0;
            String[] words = report[i].split(" ");
            for (String word : words) {
                if (pos_word.contains(word)) {
                    score += 3;
                } else if (neg_word.contains(word)) {
                    score -= 1;
                }
            }
            infos[i] = new StuInfo(score, student_id[i]);
        }

        Arrays.sort(infos, new Comparator<StuInfo>() {
            @Override
            public int compare(StuInfo o1, StuInfo o2) {
                if (o1.score == o2.score) {
                    return o1.stuId - o2.stuId;
                } else {
                    return o2.score - o1.score;
                }
            }
        });

        for (int i = 0; i < k; i++) {
            res.add(infos[i].stuId);
        }

        return res;
    }

    static class StuInfo {
        int score;
        int stuId;

        public StuInfo(int score, int stuId) {
            this.score = score;
            this.stuId = stuId;
        }
    }
}
