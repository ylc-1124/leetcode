package 每日一题;

import java.util.*;

/**
 * @description:
 * @author: ylc
 * @date: 2023/11/15 13:08
 */
public class _692_前K个高频单词 {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> res = new ArrayList<>(k);

        Map<String, Integer> map = new HashMap<>();
        // 统计每个单词出现的次数
        for (String word : words) {
            Integer freq = map.getOrDefault(word, 0);
            map.put(word, freq + 1);
        }

        Queue<State> heap = new PriorityQueue<>((o1, o2) -> o1.freq != o2.freq ? o2.freq - o1.freq : o1.word.compareTo(o2.word));
        for (String word : map.keySet()) {
            State state = new State(word, map.get(word));
            heap.add(state);
        }
        while (k-- > 0) {
            res.add(heap.poll().word);
        }
        return res;
    }

    static class State {
        String word;

        Integer freq;

        public State(String word, Integer freq) {
            this.word = word;
            this.freq = freq;
        }
    }

}
