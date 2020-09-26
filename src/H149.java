import java.util.*;
/*
 *  A line is determined by two factors,say y=ax+b
 *
 *  If two points(x1,y1) (x2,y2) are on the same line(Of course).

 *  Consider the gap between two points.

 *  We have (y2-y1)=a(x2-x1),a=(y2-y1)/(x2-x1) a is a rational, b is canceled since b is a constant

 *  If a third point (x3,y3) are on the same line. So we must have y3=ax3+b

 *  Thus,(y3-y1)/(x3-x1)=(y2-y1)/(x2-x1)=a

 *  Since a is a rational, there exists y0 and x0, y0/x0=(y3-y1)/(x3-x1)=(y2-y1)/(x2-x1)=a

 *  So we can use y0&x0 to track a line;
 */

public class H149{
    public int maxPoints(int[][] points) {
        if (points==null) return 0;
        if (points.length<=2) return points.length;
        Map<Integer,Map<Integer,Integer>> map = new HashMap<>();
        int result=0;
        for (int i=0;i<points.length;i++){
            map.clear();
            int overlap=0,max=0;
            for (int j=i+1;j<points.length;j++){
                int x=points[j][0]-points[i][0];
                int y=points[j][1]-points[i][1];
                if (x==0&&y==0){
                    overlap++;
                    continue;
                }
                int gcd=generateGCD(x,y);
                if (gcd!=0){
                    x/=gcd;
                    y/=gcd;
                }
                map.putIfAbsent(x, new HashMap<>());
                map.get(x).put(y, map.get(x).getOrDefault(y, 0)+1);
                max=Math.max(max, map.get(x).get(y));
            }
            result=Math.max(result, max+overlap+1);
        }
        return result;
    }
    private int generateGCD(int a,int b){
        return b==0? a: generateGCD(b,a%b);
    }
}