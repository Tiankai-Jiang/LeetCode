import java.util.*;
public class H224 {
    public int calculate(String s) {
        Stack<Integer> stk = new Stack<>();
        int number = 0, sign = 1, res = 0;
        for(int i=0; i< s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)) number = 10 * number + (c-'0');
            else if(c == '+'){
                res += sign * number;
                number = 0;
                sign = 1;
            }else if(c == '-'){
                res += sign * number;
                number = 0;
                sign = -1;
            }else if(c == '('){
                stk.push(res);
                stk.push(sign);
                res = 0;
                sign = 1;
            }else if(c == ')'){
                res += sign * number;
                res *= stk.pop();
                res += stk.pop();
                number = 0;
            }
        }
        return res + (sign * number);
    }
}
