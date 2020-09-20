import java.util.*;

public class H212 {

    class TrieNode{
        TrieNode[] next = new TrieNode[26];
        String word;
    }

    private TrieNode buildTrie(String[] words){
        TrieNode root = new TrieNode();
       for(String w: words){
            TrieNode cur = root;
            for(char c: w.toCharArray()){
                if(cur.next[c-'a']==null) cur.next[c-'a']=new TrieNode();
                cur = cur.next[c-'a'];
            }
            cur.word = w;
       }
       return root;
    }

    private void dfs(char[][] board, TrieNode root, List<String> res, int i, int j){
        char c = board[i][j];
        if(c == ' ' || root.next[c-'a']==null) return;
        root = root.next[c-'a'];
        if(root.word!=null){
            res.add(root.word);
            root.word = null;
        }
        board[i][j] = ' ';
        for(int[] k : new int[][]{{-1,0},{1,0},{0,-1},{0,1}})
            if(i+k[0]>=0&&i+k[0]< board.length&&j+k[1]>=0&&j+k[1]< board[0].length)
                dfs(board, root, res, i+k[0], j+k[1]);
        board[i][j] = c;
    }

    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        TrieNode root = buildTrie(words);
        for(int i=0; i< board.length; i++) for(int j=0; j<board[0].length; j++) dfs(board, root, res, i, j);
        return res;
    }
}
