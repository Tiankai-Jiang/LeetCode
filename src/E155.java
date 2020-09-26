import java.util.Stack;

public class E155 {

    Stack<Integer> s;
    int min;
    /** initialize your data structure here. */
    public E155() {
        min = Integer.MAX_VALUE;
        s = new Stack<>();
    }

    public void push(int x) {
        if(x <= min){
            s.push(min);
            min=x;
        }
        s.push(x);
    }

    public void pop() {
        if(min == s.pop()) min = s.pop();
    }

    public int top() {
        return s.peek();
    }

    public int getMin() {
        return min;
    }
}
