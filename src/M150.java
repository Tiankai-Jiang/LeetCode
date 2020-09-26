import java.util.*;
public class M150 {
    public int evalRPN(String[] tokens) {
        Stack<String> s = new Stack<>();
        for(String str: tokens) {
            if(str.length() == 1 && (str.charAt(0) == '+' || str.charAt(0) == '-' || str.charAt(0) == '*' || str.charAt(0) == '/')){
                int i = Integer.parseInt(s.pop()), j = Integer.parseInt(s.pop());
                switch (str.charAt(0)){
                    case '+':
                        s.push(String.valueOf(i+j));
                        break;
                    case '-':
                        s.push(String.valueOf(j-i));
                        break;
                    case '*':
                        s.push(String.valueOf(i*j));
                        break;
                    default:
                        s.push(String.valueOf(j/i));
                        break;
                }
            }else s.push(str);
        }
        return Integer.parseInt(s.pop());
    }
}
