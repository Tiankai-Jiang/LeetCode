import java.util.Stack;
public class E1021 {

    // My solution 1, slow
    public String removeOuterParentheses(String S) {
        if(S.length() == 0) return "";
        Stack<Character> s = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int current = 0;
        for(int i = 0; i < S.length(); ++i){
            if(s.empty()){
                current = i;
                s.push(S.charAt(i));
            }else{
                if(S.charAt(i) != s.peek().charValue()){
                    s.pop();
                    if(s.empty()) sb.append(S.substring(current+1, i));
                }else{
                    s.push(S.charAt(i));
                }
            }
        }
        return sb.toString();
    }

    // My solution 2, faster
    public String removeOuterParentheses2(String S){
        StringBuilder sb = new StringBuilder();
        int current = 0, count = 0;
        for(int i = 0; i < S.length(); ++i){
            count += (S.charAt(i) == '(' ? 1 : -1);
            if(count == 0) {
                sb.append(S.substring(current+1, i));
                current = i + 1;
            }
        }
        return sb.toString();
    }

    // Count the number of open parenthesis
    public String removeOuterParentheses3(String S) {
        StringBuilder s = new StringBuilder();
        int opened = 0;
        for (char c : S.toCharArray()) {
            if (c == '(' && opened++ > 0) s.append(c);
            if (c == ')' && opened-- > 1) s.append(c);
        }
        return s.toString();
    }
}
