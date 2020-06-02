public class M11 {

    // My solution
    public int maxArea(int[] height) {
        int m = -1, i = 0, j = height.length-1;
        while(j-i>0){
            m = Math.max(m, (j-i)*Math.min(height[i], height[j]));
            if(height[i]<height[j]) i++;
            else j--;
        }
        return m;
    }
}
