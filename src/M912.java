public class M912 {

    // My solution, bucket sort
    public int[] sortArray(int[] nums) {
        int[] bucket = new int[100001], a = new int[nums.length];
        for(int i: nums) bucket[i+50000]++;
        int p = 0;
        for(int i = 0; i < 100001; ++i){
            while(bucket[i]!=0){
                a[p++] = i-50000;
                bucket[i]--;
            }
        }
        return a;
    }
}
