import java.util.*;
public class M17 {

    char[][] letters = new char[][]{{'a', 'b', 'c'},{'d', 'e', 'f'},{'g', 'h', 'i'},{'j', 'k', 'l'},{'m', 'n', 'o'},{'p', 'q', 'r', 's'},{'t', 'u', 'v'},{'w', 'x', 'y', 'z'}};

    private void letterCombinations(String digits, int ind, StringBuilder curStr, List<String> res){
        if(ind == digits.length()) res.add(curStr.toString());
        else{
            for(int i=0; i < letters[digits.charAt(ind)-'0'-2].length; i++){
                curStr.append(letters[digits.charAt(ind)-'0'-2][i]);
                letterCombinations(digits, ind+1, curStr, res);
                curStr.deleteCharAt(curStr.length()-1);
            }
        }
    }

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits.length()==0) return res;
        letterCombinations(digits, 0, new StringBuilder(), res);
        return res;
    }
}
