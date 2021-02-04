import java.util.*;

public class M120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int res = Integer.MAX_VALUE;

        if(triangle.size()==1){
            return triangle.get(0).get(0);
        }

        for(int i=1; i<triangle.size(); i++){
            List<Integer> line = triangle.get(i);
            line.set(0, line.get(0) + triangle.get(i-1).get(0));
            for(int j=1; j<i; j++){
                line.set(j, line.get(j) + Math.min(triangle.get(i-1).get(j-1), triangle.get(i-1).get(j)));
            }

            line.set(i, line.get(i)+triangle.get(i-1).get(i-1));
        }

        for(int i=0; i<triangle.size(); i++){
            res = Math.min(res, triangle.get(triangle.size()-1).get(i));
        }
        return res;
    }

    public int minimumTotal2(List<List<Integer>> triangle) {
        for(int i=triangle.size()-2; i>=0; i--){
            for(int j=0; j<=i; j++){
                triangle.get(i).set(j, triangle.get(i).get(j) + Math.min(triangle.get(i+1).get(j), triangle.get(i+1).get(j+1)));
            }
        }
        return triangle.get(0).get(0);
    }
}
