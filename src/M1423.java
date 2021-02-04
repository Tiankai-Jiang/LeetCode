public class M1423 {
    public int maxScore(int[] cardPoints, int k) {
        int curPoint = 0;
        for(int i=0; i<k; i++){
            curPoint += cardPoints[i];
        }

        int res = curPoint;
        for(int i=k-1; i>=0; i--){
            curPoint = curPoint - cardPoints[i] + cardPoints[cardPoints.length - (k-i)];
            res = Math.max(res, curPoint);
        }
        return res;
    }
}
