import java.util.Arrays;

public class E1051 {

    // My solution
    public int heightChecker(int[] heights) {
        int a = 0;
        int[] s = new int[heights.length];
        System.arraycopy(heights, 0, s, 0, heights.length);
        Arrays.sort(s);
        for(int i = 0; i < heights.length; ++i) if(s[i]!=heights[i])a++;
        return a;
    }

    // count the frequency of each height and use 2 pointers to make comparison
    public int heightChecker2(int[] heights) {
        int[] heightToFreq = new int[101];
        for (int height : heights) heightToFreq[height]++;
        int result = 0, curHeight = 0;
        for (int i = 0; i < heights.length; i++) {
            while (heightToFreq[curHeight] == 0) curHeight++;
            if (curHeight != heights[i]) result++;
            heightToFreq[curHeight]--;
        }
        return result;
    }
}
