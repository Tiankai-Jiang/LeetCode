import java.util.*;

public class M1381 {

    // My solution
    int maxSize;
    LinkedList<Integer> stack;

    public M1381(int maxSize) {
        stack = new LinkedList<>();
        this.maxSize = maxSize;
    }

    public void push(int x) {
        if(stack.size() < maxSize) stack.add(x);
    }

    public int pop() {
        return stack.size()==0 ? -1 : stack.removeLast();
    }

    public void increment(int k, int val) {
        for(int i = 0; i < Math.min(stack.size(), k); ++i) stack.set(i, stack.get(i)+val);
    }

    /**
    // O(1) solution
    // Use an additional array to record the increment value.
    // inc[i] means for all elements stack[0] ~ stack[i],
    // we should plus inc[i] when popped from the stack.
    // Then inc[i-1]+=inc[i], so that we will keep it from next pop.
    int n;
    int[] inc;
    Stack<Integer> stack;

    public CustomStack(int maxSize) {
        n = maxSize;
        inc = new int[n];
        stack = new Stack<>();
    }

    public void push(int x) {
        if (stack.size() < n)
            stack.push(x);
    }

    public int pop() {
        int i = stack.size() - 1;
        if (i < 0)
            return -1;
        if (i > 0)
            inc[i - 1] += inc[i];
        int res = stack.pop() + inc[i];
        inc[i] = 0;
        return res;
    }

    public void increment(int k, int val) {
        int i = Math.min(k, stack.size()) - 1;
        if (i >= 0)
            inc[i] += val;
    }
     */
}
