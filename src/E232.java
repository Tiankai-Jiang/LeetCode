import java.util.*;
public class E232 {

    Stack<Integer> queue, tmp;
    int front;
    /** Initialize your data structure here. */
    public E232() {
        queue = new Stack<>();
        tmp = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        if(queue.isEmpty()) front = x;
        queue.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        while(queue.size()>1) tmp.push(queue.pop());
        int res = queue.pop();
        front = tmp.isEmpty() ? -1 : tmp.peek();
        while(!tmp.isEmpty()) queue.push(tmp.pop());
        return res;
    }

    /** Get the front element. */
    public int peek() {
        return front;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }
}
