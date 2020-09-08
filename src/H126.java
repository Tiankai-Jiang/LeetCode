import java.util.*;
public class H126 {

    // 1). Use BFS to find the shortest distance between start and end,
    // tracing the distance of crossing nodes from start node to end node,
    // and store node's next level neighbors to HashMap;
    //
    // 2). Use DFS to output paths with the same distance as the shortest distance
    // from distance HashMap: compare if the distance of the next level node equals
    // the distance of the current node + 1.
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> dict = new HashSet<>(wordList);
        List<List<String>> res = new ArrayList<>();
        HashMap<String, ArrayList<String>> neighbours = new HashMap<>();
        HashMap<String, Integer> distance = new HashMap<>();
        List<String> sol = new ArrayList<>();
        dict.add(beginWord);
        bfs(beginWord, endWord, dict, neighbours, distance);
        dfs(beginWord, endWord, neighbours, distance, sol, res);
        return res;
    }

    private void bfs(String beginWord, String endWord, HashSet<String> dict, HashMap<String, ArrayList<String>> neighbours, HashMap<String, Integer> distance){
        for(String str : dict) neighbours.put(str, new ArrayList<>());
        Queue<String> q = new LinkedList<String>(){{offer(beginWord);}};
        distance.put(beginWord, 0);

        while(!q.isEmpty()){
            int count = q.size();
            boolean foundEnd = false;
            for(int i=0; i<count; i++){
                String curWord = q.poll();
                int curDistance = distance.get(curWord);
                ArrayList<String> neigh = getNeighbours(curWord, dict);
                for(String nei: neigh){
                    neighbours.get(curWord).add(nei);
                    if(!distance.containsKey(nei)){
                        distance.put(nei, curDistance+1);
                        if(nei.equals(endWord)) foundEnd = true;
                        else q.offer(nei);
                    }
                }

                if(foundEnd) break;
            }
        }
    }

    private ArrayList<String> getNeighbours(String word, HashSet<String> dict){
        ArrayList<String> res = new ArrayList<>();
        char[] chs = word.toCharArray();
        for (char ch ='a'; ch <= 'z'; ch++){
            for (int i = 0; i < chs.length; i++){
                if(ch != chs[i]){
                    char oldChar = chs[i];
                    chs[i] = ch;
                    if(dict.contains(String.valueOf(chs))) res.add(String.valueOf(chs));
                    chs[i] = oldChar;
                }
            }
        }
        return res;
    }

    private void dfs(String curWord, String endWord, HashMap<String, ArrayList<String>> neighbours, HashMap<String, Integer> distance, List<String> sol, List<List<String>> res){
        sol.add(curWord);
        if(endWord.equals(curWord)) res.add(new ArrayList<>(sol));
        else for(String next: neighbours.get(curWord)) if(distance.get(next) == distance.get(curWord)+1) dfs(next, endWord, neighbours, distance, sol, res);
        sol.remove(sol.size()-1);
    }
}
