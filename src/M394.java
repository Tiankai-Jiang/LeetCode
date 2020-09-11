import java.util.*;
public class M394 {
    public String decodeString(String s) {
        int num = 0;
        LinkedList<Character> chars = new LinkedList<>();
        Stack<Integer> nums = new Stack<>();
        for(char c: s.toCharArray()){
            if(Character.isDigit(c)) num = 10 * num + c - '0';
            else if(c == '['){
                nums.push(num);
                num = 0;
                chars.addLast(c);
            }else if(Character.isAlphabetic(c)){
                chars.addLast(c);
            }else{
                int repeat = nums.pop();
                LinkedList<Character> tmp = new LinkedList<>();
                while(chars.peekLast() != '[') tmp.addFirst(chars.pollLast());
                chars.pollLast();
                for(int i=0; i<repeat; i++) for(int j=0; j< tmp.size(); j++) chars.addLast(tmp.get(j));
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!chars.isEmpty()) sb.append(chars.pollFirst());
        return sb.toString();
    }
}
