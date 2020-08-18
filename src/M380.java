import java.util.*;

public class M380 {

    /** Initialize your data structure here. */
    Random r;
    LinkedList<Integer> l;
    HashMap<Integer, Integer> hm;
    public M380() {
        r = new Random();
        l = new LinkedList<>();
        hm = new HashMap<>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(hm.containsKey(val)) return false;
        l.addLast(val);
        hm.put(val, l.size()-1);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!hm.containsKey(val)) return false;
        int ind = hm.get(val);
        if(ind < l.size()-1){
            l.set(ind, l.getLast());
            hm.put(l.getLast(), ind);
        }
        hm.remove(val);
        l.removeLast();
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return l.get(r.nextInt(l.size()));
    }
}
