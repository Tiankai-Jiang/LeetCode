import java.util.*;

public class M721 {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int[] parents = new int[accounts.size()];
        Map<String, Integer> ids = new HashMap<>();
        Map<Integer, TreeSet<String>> users = new HashMap<>();

        for(int i=0; i<accounts.size(); i++) parents[i] = i;

        for(int i=0; i<accounts.size(); i++){
            for(int j=1; j < accounts.get(i).size(); j++){
                String email = accounts.get(i).get(j);
                if(ids.containsKey(email)){
                    int id1 = findParent(parents, i), id2 = findParent(parents, ids.get(email));
                    if(id1 != id2) parents[id2] = id1;
                }else ids.put(email, i);
            }
        }

        for(int i=0; i<accounts.size(); i++){
            int parent = findParent(parents, i);
            users.putIfAbsent(parent, new TreeSet<>());
            users.get(parent).addAll(accounts.get(i).subList(1, accounts.get(i).size()));
        }

        List<List<String>> res = new ArrayList<>();
        for(Integer i: users.keySet()){
            List<String> tmp = new ArrayList<>(users.get(i));
            tmp.add(0, accounts.get(i).get(0));
            res.add(tmp);
        }

        return res;
    }

    private int findParent(int[] parents, int idx) {
        while (idx != parents[idx]) {
            parents[idx] = parents[parents[idx]];
            idx = parents[idx];
        }
        return idx;
    }
}
