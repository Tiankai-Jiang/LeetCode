import java.util.*;
import java.util.regex.*;

public class M241 {

    // My solution, recursion
    Pattern p = Pattern.compile("\\*|\\+|\\-");
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> a = new ArrayList<>();
        if (input == null || input.length() == 0) return a;
        Matcher m = p.matcher(input);
        if (!m.find()) {
            a.add(Integer.parseInt(input));
            return a;
        }else {
            m = p.matcher(input);
            while (m.find()) {
                List<Integer> l1 = diffWaysToCompute(input.substring(0, m.start()));
                List<Integer> l2 = diffWaysToCompute(input.substring(m.start() + 1));
                if (input.charAt(m.start()) == '+') for (int i : l1) for (int j : l2) a.add(i + j);
                else if (input.charAt(m.start()) == '-') for (int i : l1) for (int j : l2) a.add(i - j);
                else for (int i : l1) for (int j : l2) a.add(i * j);
            }
        }
        return a;
    }

    // DP, where dp[i][j] stores all possible results from the i-th integer to the j-th integer (inclusive) in the list.
    public List<Integer> diffWaysToCompute2(String input) {
        List<Integer> result=new ArrayList<>();
        if(input==null||input.length()==0)  return result;
        List<String> ops=new ArrayList<>();
        for(int i=0; i<input.length(); i++){
            int j=i;
            while(j<input.length()&&Character.isDigit(input.charAt(j))) j++;
            ops.add(input.substring(i, j));
            if(j!=input.length()) ops.add(input.substring(j, j+1));
            i=j;
        }
        int N=(ops.size()+1)/2; //num of integers
        ArrayList<Integer>[][] dp=(ArrayList<Integer>[][]) new ArrayList[N][N];
        for(int d=0; d<N; d++){
            if(d==0){
                for(int i=0; i<N; i++){
                    dp[i][i]=new ArrayList<>();
                    dp[i][i].add(Integer.valueOf(ops.get(i*2)));
                }
                continue;
            }
            for(int i=0; i<N-d; i++){
                dp[i][i+d]=new ArrayList<>();
                for(int j=i; j<i+d; j++){
                    ArrayList<Integer> left=dp[i][j], right=dp[j+1][i+d];
                    String operator=ops.get(j*2+1);
                    for(int leftNum:left)
                        for(int rightNum:right){
                            if(operator.equals("+")) dp[i][i+d].add(leftNum+rightNum);
                            else if(operator.equals("-")) dp[i][i+d].add(leftNum-rightNum);
                            else dp[i][i+d].add(leftNum*rightNum);
                        }
                }
            }
        }
        return dp[0][N-1];
    }
}
