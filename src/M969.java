import java.util.*;
public class M969 {
    private void flip(int[] arr, int start, int end){
        for(int i=start; i<=(end+start)/2; i++) arr[i] += arr[end+start-i] - (arr[end+start-i] = arr[i]);
    }

    public List<Integer> pancakeSort(int[] arr) {
        List<Integer> res = new ArrayList<>();
        for(int i = arr.length-1; i>0; i--){
            int max = Integer.MIN_VALUE, maxInd = -1;
            for(int j=0; j<=i; j++){
                if(arr[j]>max){
                    max = arr[j];
                    maxInd = j;
                }
            }
            if(maxInd == i) continue;
            res.add(maxInd+1);
            res.add(i+1);
            flip(arr, 0, maxInd);
            flip(arr, 0, i);
        }
        return res;
    }
}
