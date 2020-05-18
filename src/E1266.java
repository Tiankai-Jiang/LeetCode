public class E1266 {

    // My solution
    public int minTimeToVisitAllPoints(int[][] points) {
        int a = 0;
        for(int i = 0; i < points.length - 1; ++i) a += Math.max(Math.abs(points[i+1][0]-points[i][0]), Math.abs(points[i+1][1]-points[i][1]));
        return a;
    }
}
