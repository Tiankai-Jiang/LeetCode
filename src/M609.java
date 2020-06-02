import java.util.*;
public class M609 {

    // My solution
    public List<List<String>> findDuplicate(String[] paths) {
        List<List<String>> a = new ArrayList<>();
        Map<String, List<String>> m = new HashMap<>();
        for(String s: paths){
            String[] splited = s.split("\\s");
            for(int i=1; i<splited.length;++i){
                int ind = splited[i].indexOf('(');
                String content = splited[i].substring(ind+1, splited[i].length()-1), path = splited[0].concat("/").concat(splited[i].substring(0, ind));
                if(m.get(content)==null) m.put(content, new ArrayList<String>(){{add(path);}});
                else m.get(content).add(path);
            }
        }
        for(List<String> l: m.values()) if(l.size()>1) a.add(l);
        return a;
    }
}
