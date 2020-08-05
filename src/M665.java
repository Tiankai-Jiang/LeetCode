import java.util.Stack;

public class M665 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        for (int x : pushed) {
            stack.push(x);
            while (!stack.empty() && stack.peek() == popped[i]) {
                stack.pop();
                i++;
            }
        }
        return stack.empty();
    }

    // Use pushed as a stack
    public boolean validateStackSequences2(int[] pushed, int[] popped) {
        int i = 0, j = 0;
        for (int x : pushed) {
            pushed[i++] = x;
            while (i > 0 && pushed[i - 1] == popped[j]) {
                --i;
                ++j;
            }
        }
        return i == 0;
    }
}
