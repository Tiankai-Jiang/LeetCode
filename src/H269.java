import java.util.*;
public class H269 {

    public String alienOrder(String[] words) {
        if(words.length == 1) return words[0];
        boolean[] occur = new boolean[26];
        int[][] graph = new int[26][26];
        int num = 0;
        for(String word: words){
            for(int i = 0; i < word.length(); i++){
                if(!occur[word.charAt(i)-'a']) num++;
                occur[word.charAt(i)-'a'] = true;
            }
        }

        for(int i = 1; i < words.length; i++){
            int ind = 0;
            while(ind < words[i-1].length() && ind < words[i].length()){
                if(words[i-1].charAt(ind) != words[i].charAt(ind)){
                    graph[words[i-1].charAt(ind)-'a'][words[i].charAt(ind)-'a'] = 1;
                    break;
                }else {
                    ind++;
                    if(ind < words[i-1].length() && ind == words[i].length()) return "";
                }
            }
        }

        int cnt = 0;
        int[] inDegree = new int[26];
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < 26; i++) for(int j = 0; j < 26; j++) if(graph[j][i] == 1) inDegree[i]++;

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < 26; i++) if(inDegree[i] == 0 && occur[i]) q.offer(i);
        while(!q.isEmpty()){
            int u = q.poll();
            sb.append((char)(u+'a'));
            for(int i = 0; i < 26; i++) if(graph[u][i]>0 && --inDegree[i] == 0) q.offer(i);
            cnt ++;
        }

        if (cnt != num) return "";
        return sb.toString();
    }
}
