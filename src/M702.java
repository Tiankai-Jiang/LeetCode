public class M702 {
    interface ArrayReader {
        public int get(int index);
    }

    public int search(ArrayReader reader, int target) {
        int lo = 0, hi = 10000, cur = reader.get(hi);
        while(cur == Integer.MAX_VALUE){
            hi /= 2;
            cur = reader.get(hi);
        }
        if(cur < target) hi *= 2;
        while(lo < hi){
            int mid = lo + (hi-lo)/2;
            if(target < reader.get(mid)) hi = mid - 1;
            else if(target > reader.get(mid)) lo = mid + 1;
            else return mid;
        }
        return -1;
    }
}
