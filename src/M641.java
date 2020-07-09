public class M641 {

    // My solution
    int s, deque[], f, r, k;
    /** Initialize your data structure here. Set the size of the deque to be k. */
    public M641(int k) {
        this.k = k;
        deque = new int[k];
        s = 0;
        f = 0;
        r = k-1;
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if(s!=k){
            deque[f] = value;
            f = (f+1)%k;
            s++;
            return true;
        }else return false;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if(s!=k){
            deque[r] = value;
            r = r == 0 ? k - 1 : r - 1;
            s++;
            return true;
        }else return false;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if(s != 0){
            f = f == 0 ? k - 1: f-1;
            s--;
            return true;
        }else return false;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if(s != 0){
            r = (r+1)%k;
            s--;
            return true;
        }else return false;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        return s == 0 ? -1 : deque[f == 0 ? k - 1: f-1];
    }

    /** Get the last item from the deque. */
    public int getRear() {
        return s == 0 ? -1 : deque[(r+1)%k];
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return s == 0;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return s == k;
    }
}
