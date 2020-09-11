import java.util.*;
public class E20 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chs = s.toCharArray();
        for(char c: chs){
            if(c == '(' || c == '{' || c == '[') stack.push(c);
            else{
                if(stack.isEmpty() || (c == ')' && stack.peek() != '(') || (c==']' && stack.peek() != '[') || (c=='}' && stack.peek() != '{')) return false;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
