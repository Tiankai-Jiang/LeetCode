import java.util.*;
public class M692 {
    public List<String> topKFrequent(String[] words, int k) {
        PriorityQueue<String>[] l = new PriorityQueue[words.length+1];
        Map<String, Integer> m = new HashMap<>();
        for(String s: words) m.merge(s, 1, Integer::sum);
        for(Map.Entry<String, Integer> e: m.entrySet()){
            int num = e.getValue();
            if(l[num] == null) l[num] = new PriorityQueue<>();
            l[num].offer(e.getKey());
        }
        List<String> res = new ArrayList<>();
        int cur = words.length;
        while(k > 0){
            if(l[cur] == null || l[cur].size() == 0){
                cur--;
                continue;
            }
            res.add(l[cur].poll());
            k--;
        }
        return res;
    }
}
