public class M208 {

    M208[] trie;
    boolean endsHere;

    /** Initialize your data structure here. */
    public M208() {
        endsHere = false;
        trie = new M208[26];
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        M208[] start = trie;
        for(int i=0; i< word.length()-1; i++){
            int ind = word.charAt(i)-'a';
            if(start[ind]==null) start[ind] = new M208();
            start = start[ind].trie;
        }
        int lastInd = word.charAt(word.length()-1)-'a';
        if(start[lastInd]==null) start[lastInd] = new M208();
        start[lastInd].endsHere = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        M208[] start = trie;
        for(int i=0; i< word.length()-1; i++){
            int ind = word.charAt(i)-'a';
            if(start[ind]==null) return false;
            start = start[ind].trie;
        }
        int lastInd = word.charAt(word.length()-1)-'a';
        return start[lastInd]!=null && start[lastInd].endsHere;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        M208[] start = trie;
        for(char c: prefix.toCharArray()){
            if(start[c-'a']==null) return false;
            start = start[c-'a'].trie;
        }
        return true;
    }
}
