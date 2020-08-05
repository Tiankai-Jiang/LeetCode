import java.util.*;
public class M211 {
    Map<Integer, HashSet<String>> dict;
    Map<Integer, Map<Character, HashSet<String>>> start;
    Map<Integer, Map<Character, HashSet<String>>> end;

    /** Initialize your data structure here. */
    public M211() {
        dict = new HashMap<>();
        start = new HashMap<>();
        end = new HashMap<>();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {

        int l = word.length();
        if(!dict.containsKey(l)){
            dict.put(l, new HashSet<>());
            start.put(l, new HashMap<>());
            end.put(l, new HashMap<>());
        }
        dict.get(l).add(word);
        Map<Character, HashSet<String>> s = start.get(l), e = end.get(l);
        if(!s.containsKey(word.charAt(0))) s.put(word.charAt(0), new HashSet<>());
        if(!e.containsKey(word.charAt(l-1))) e.put(word.charAt(l-1), new HashSet<>());
        s.get(word.charAt(0)).add(word);
        e.get(word.charAt(l-1)).add(word);
    }

    private boolean helper(String word, HashSet<String> hs){
        for (String s: hs){
            boolean found = true;
            for(int i = 0; i < word.length(); ++i){
                if(word.charAt(i)=='.') continue;
                if(word.charAt(i)-s.charAt(i) != 0) {
                    found = false;
                    break;
                }
            }
            if(found) return true;
        }
        return false;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        int l = word.length();
        char f = word.charAt(0), r = word.charAt(l-1);
        if(f != '.') {
            if(!start.containsKey(l)) return false;
            if(!start.get(l).containsKey(f)) return false;
            return helper(word, start.get(l).get(f));
        }
        else if(r != '.') {
            if(!end.containsKey(l)) return false;
            if(!end.get(l).containsKey(r)) return false;
            return helper(word, end.get(l).get(r));
        }
        else {
            if(!dict.containsKey(l)) return false;
            return helper(word, dict.get(l));
        }
    }

    // Using Trie
    public class TrieNode {
        public TrieNode[] children = new TrieNode[26];
        public String item = "";
    }

    private TrieNode root = new TrieNode();

    public void addWord2(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new TrieNode();
            }
            node = node.children[c - 'a'];
        }
        node.item = word;
    }

    public boolean search2(String word) {
        return match(word.toCharArray(), 0, root);
    }

    private boolean match(char[] chs, int k, TrieNode node) {
        if (k == chs.length) return !node.item.equals("");
        if (chs[k] != '.') {
            return node.children[chs[k] - 'a'] != null && match(chs, k + 1, node.children[chs[k] - 'a']);
        } else {
            for (int i = 0; i < node.children.length; i++) {
                if (node.children[i] != null) {
                    if (match(chs, k + 1, node.children[i])) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}

// Using trie
