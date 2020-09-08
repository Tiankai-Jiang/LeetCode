import java.util.*;
import java.util.regex.*;

public class M227 {
    public int calculate(String s) {
        String[] numbers = s.split("[+\\-*/]"), ops = new String[numbers.length-1];
        Matcher m = Pattern.compile("[+\\-*/]").matcher(s);
        int cur = 0;
        while (m.find()) ops[cur++] = m.group();
        Deque<Integer> deque = new LinkedList<Integer>(){{push(Integer.parseInt(numbers[0].trim()));}};
        for(int i=0; i< ops.length; i++){
            if(ops[i].equals("+") || ops[i].equals("-")) deque.addLast(Integer.parseInt(numbers[i+1].trim()));
            else{
                int last = deque.pollLast();
                if(ops[i].equals("*")) deque.addLast(last * Integer.parseInt(numbers[i+1].trim()));
                else deque.addLast(last / Integer.parseInt(numbers[i+1].trim()));
                ops[i] = ".";
            }
        }
        int res = deque.pollFirst();
        for(int i=0; i<ops.length; i++){
            if(ops[i].equals("+")) res += deque.pollFirst();
            else if(ops[i].equals("-")) res -= deque.pollFirst();
        }
        return res;
    }

    public int calculate2(String s) {
        if (s == null || s.length() == 0) return 0;
        Stack<Integer> stack = new Stack<>();
        s += '+';
        char op = '+';
        for (int i = 0, n = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') { n = n * 10 + c - '0'; continue; }
            if (c == ' ') continue;
            if (op == '+') stack.push(n);
            else if (op == '-') stack.push(-n);
            else if (op == '*') stack.push(stack.pop()*n);
            else if (op == '/') stack.push(stack.pop()/n);
            op = c;
            n = 0;
        }
        int total = 0;
        while (!stack.isEmpty()) total += stack.pop();
        return total;
    }
}
