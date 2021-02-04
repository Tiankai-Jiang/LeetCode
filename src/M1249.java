import java.util.Stack;

public class M1249 {
    public String minRemoveToMakeValid(String s) {
        if(s.length()==0) return "";
        Stack<Integer> stack = new Stack<>();
        for(int i=1; i<=s.length(); i++){
            if(s.charAt(i-1)=='(') stack.push(i);
            else if(s.charAt(i-1)==')'){
                if(!stack.isEmpty() && stack.peek()>0) stack.pop();
                else stack.push(-i);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(s);
        while(!stack.isEmpty()) sb.deleteCharAt(Math.abs(stack.pop())-1);
        return sb.toString();
    }
}
