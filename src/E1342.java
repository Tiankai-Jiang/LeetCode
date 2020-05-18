public class E1342 {
    // My solution
    public int numberOfSteps (int num) {
        int step = 0;
        while(num != 0){
            num = num % 2 == 0 ? num >> 1 : num - 1;
            step ++;
        }
        return step;
    }

    // Count 0 and 1s
    public int numberOfSteps2 (int num) {
        if(num == 0) return 0;
        int step = 0;
        while(num != 0){
            step += ((num & 1) == 1) ? 2 : 1;
            num >>= 1;
        }
        return step - 1;
    }
}
