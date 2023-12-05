package leetcode周赛;

import java.util.*;

/**
 * @description:
 * @author: ylc
 * @date: 2023/11/12 10:37
 */
public class _100128_高访问员工 {
    public List<String> findHighAccessEmployees(List<List<String>> access_times) {
        List<String> res = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (List<String> accessTime : access_times) {
            String name = accessTime.get(0);
            String time = accessTime.get(1);
            if (map.containsKey(name)) {
                List<String> times = map.get(name);
                times.add(time);
            } else {
                List<String> times = new ArrayList<>();
                times.add(time);
                map.put(name, times);
            }
        }

        for (String name : map.keySet()) {
            List<String> times = map.get(name);
            if (times.size() < 3) continue; // 不可能是高访问员工

            // 按时间升序排序
            times.sort(new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return o1.compareTo(o2);
                }
            });

            int m = times.size();
            for (int i = 0; i < m; i++) {
                String time = times.get(i);
                String new_time = timePlusOne(time);
                int count = 1;
                for (int j = i + 1; j < m; j++) {
                    String s = times.get(j);
                    if (s.compareTo(new_time) < 0) {
                        count++;
                    }
                    if (count >= 3) {
                        break;
                    }
                }
                if (count >= 3) {
                    res.add(name);
                    break;
                }
            }


        }

        return res;
    }

    private String timePlusOne(String time) {
        String hour = time.substring(0, 2);
        String min = time.substring(2);
        int h = Integer.parseInt(hour);
        if (h + 1 < 10) {
            return '0' + String.valueOf(h + 1) + min;
        } else {
            return String.valueOf(h + 1) + min;
        }
    }

    public static void main(String[] args) {
        System.out.println("0549".compareTo(new _100128_高访问员工().timePlusOne("0532"))<0);
    }

}
