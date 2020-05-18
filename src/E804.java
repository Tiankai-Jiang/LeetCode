import java.util.*;
public class E804 {

    // My solution
    public int uniqueMorseRepresentations(String[] words) {
        Set<String> a = new HashSet<>();
        Map<Character, String> m = new HashMap<Character, String>(){{
            put('a', ".-");
            put('b', "-...");
            put('c', "-.-.");
            put('d', "-..");
            put('e', ".");
            put('f', "..-.");
            put('g', "--.");
            put('h', "....");
            put('i', "..");
            put('j', ".---");
            put('k', "-.-");
            put('l', ".-..");
            put('m', "--");
            put('n', "-.");
            put('o', "---");
            put('p', ".--.");
            put('q', "--.-");
            put('r', ".-.");
            put('s', "...");
            put('t', "-");
            put('u', "..-");
            put('v', "...-");
            put('w', ".--");
            put('x', "-..-");
            put('y', "-.--");
            put('z', "--..");
        }};
        for(int i = 0; i < words.length; ++i){
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < words[i].length(); ++j) sb.append(m.get(words[i].charAt(j)));
            a.add(sb.toString());
        }
        return a.size();
    }

    // No need to use a map
    public int uniqueMorseRepresentations2(String[] words) {
        String[] d = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
        HashSet<String> s = new HashSet<>();
        for (String w : words) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < w.length(); ++i)
                sb.append(d[w.charAt(i) - 'a']);
            s.add(sb.toString());
        }
        return s.size();
    }
}
