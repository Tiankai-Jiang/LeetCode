public class M277 {

    private boolean knows(int a, int b){
        // not defined here
        return true;
    }
    public int findCelebrity(int n) {
        int candidate = 0;
        for(int i = 1; i < n; i++) if(knows(candidate, i)) candidate = i;
        for(int i = 0; i < n; i++) if(i != candidate && (knows(candidate, i) || !knows(i, candidate))) return -1;
        return candidate;
    }
}
