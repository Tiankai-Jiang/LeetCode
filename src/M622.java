public class M622 {

    int[] queue;
    int k;
    int front;
    int rear;
    int curSize;
    /** Initialize your data structure here. Set the size of the queue to be k. */
    public M622(int k) {
        queue = new int[k];
        this.k = k;
        this.front = 0;
        this.rear = 0;
        this.curSize = 0;
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if(!isFull()){
            queue[rear] = value;
            rear = rear == 0 ? k-1 : rear-1;
            curSize++;
            return true;
        }else return false;
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if(!isEmpty()){
            front = front == 0 ? k-1: front-1;
            curSize--;
            return true;
        }else return false;
    }

    /** Get the front item from the queue. */
    public int Front() {
        return isEmpty() ? -1 : queue[front];
    }

    /** Get the last item from the queue. */
    public int Rear() {
        return isEmpty() ? -1 : queue[(rear+1)%k];
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return curSize == 0;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return curSize == k;
    }
}
