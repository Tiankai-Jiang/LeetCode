import java.util.Stack;
public class E122 {

    // My solution 1, slow
    public int maxProfit(int[] prices) {
        int a = 0, last = 0;
        Stack<Integer> s = new Stack<>();
        for(int i:prices){
            if(s.empty()) s.push(i);
            else{
                if(i-s.peek()>last) last=i-s.peek();
                else{
                    s.push(i);
                    a += last;
                    last=0;
                }
            }
        }
        return a+last;
    }

    // My solution 2, faster
    public int maxProfit2(int[] prices) {
        if(prices.length == 1) return 0;
        int cur1 = 0, cur2 = 1, a = 0;
        while(cur2 < prices.length){
            if(prices[cur2]-prices[cur1]>0) a+=(prices[cur2]-prices[cur1]);
            cur1++;
            cur2++;
        }
        return a;
    }

    // Actually it is simpler than I thought
    public int maxProfit3(int[] prices) {
        int total = 0;
        for (int i=0; i< prices.length-1; i++) if (prices[i+1]>prices[i]) total += prices[i+1]-prices[i];
        return total;
    }
}
