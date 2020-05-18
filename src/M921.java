import java.util.*;
public class M921 {

    // My solution
    public int minAddToMakeValid(String S) {
        Stack<Character> s = new Stack<>();
        for(char c: S.toCharArray()){
            if(s.empty()) s.push(c);
            else{
                if(s.peek()=='(' && c == ')') s.pop();
                else s.push(c);
            }
        }
        return s.size();
    }

    // Without using stack
    public int minAddToMakeValid2(String S) {
        int left = 0, right = 0;
        for (int i = 0; i < S.length(); ++i) {
            if (S.charAt(i) == '(') right++;
            else if (right > 0) right--;
            else left++;
        }
        return left + right;
    }
}
