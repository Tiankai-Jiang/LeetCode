import java.util.*;

public class M146 {

    // Cheating
//    public LinkedHashMap<Integer, Integer> lhm;
//    int size;
//
//    public M146(int size){
//        this.size = size;
//        lhm = new LinkedHashMap<Integer, Integer>(size, 0.75f, true){
//            @Override
//            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
//                return size()>size;
//            }
//        };
//
//    }
//
//    public int get(int key){
//        return lhm.getOrDefault(key, -1);
//    }
//
//    public void put(int key, int value){
//        lhm.put(key, value);
//    }

    private class DLLNode{
        int key, value;
        DLLNode prev, next;

        public DLLNode(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    HashMap<Integer, DLLNode> hm;
    int count ,capacity;
    DLLNode head, tail;

    public M146(int capacity){
        hm  = new HashMap<>();
        this.capacity = capacity;
        head = new DLLNode(0, 0);
        tail = new DLLNode(0, 0);

        head.next = tail;
        tail.prev = head;

        count = 0;
    }

    public void deleteNode(DLLNode n){
        n.prev.next = n.next;
        n.next.prev = n.prev;
    }

    public void addHead(DLLNode n){
        n.next = head.next;
        head.next.prev = n;
        head.next = n;
        n.prev = head;
    }

    public int get(int key){
        if(hm.containsKey(key)){
            DLLNode n = hm.get(key);
            int res = n.value;
            deleteNode(n);
            addHead(n);
            return res;
        }else return -1;
    }

    public void put(int key, int value){
        if(hm.containsKey(key)){
            DLLNode n = hm.get(key);
            n.value = value;
            deleteNode(n);
            addHead(n);
        }else{
            DLLNode n = new DLLNode(key, value);
            hm.put(key, n);
            if(count < capacity) count++;
            else{
                hm.remove(tail.prev.key);
                deleteNode(tail.prev);
            }
            addHead(n);
        }
    }
}
