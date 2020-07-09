import java.util.Stack;

public class M856 {

    // My solution n^2
    public int scoreOfParentheses(String S) {
        if(S.length()==0) return 0;
        int count = 0, sum = 0, last = 0;
        for(int i = 0; i < S.length(); ++i){
            count += S.charAt(i) == '(' ? 1 : -1;
            if(count == 0) {
                int tmp = scoreOfParentheses(S.substring(last+1, i));
                sum += tmp == 0 ? 1 : 2 * tmp;
                last = i+1;
            }
        }
        return sum;
    }

    // Using stack
    public int scoreOfParentheses2(String S) {
        Stack<Integer> stack = new Stack<>();
        int cur = 0;
        for (char c : S.toCharArray()) {
            if (c == '(') {
                stack.push(cur);
                cur = 0;
            } else cur = stack.pop() + Math.max(cur * 2, 1);
        }
        return cur;
    }

    // Using Array
    public int scoreOfParentheses3(String S) {
        int res[] = new int[30], i = 0;
        for (char c : S.toCharArray())
            if (c == '(') res[++i] = 0;
            else res[i - 1] += Math.max(res[i--] * 2, 1);
        return res[0];
    }

    //O(1)
    //We count the number of layers.
    //If we meet '(' layers number l++
    //else we meet ')' layers number l--
    //
    //If we meet "()", we know the number of layer outside,
    //so we can calculate the score res += 1 << l.
    public int scoreOfParentheses4(String S) {
        int res = 0, l = 0;
        for (int i = 0; i < S.length(); ++i) {
            if (S.charAt(i) == '(') l++; else l--;
            if (S.charAt(i) == ')' && S.charAt(i - 1) == '(') res += 1 << l;
        }
        return res;
    }
}
