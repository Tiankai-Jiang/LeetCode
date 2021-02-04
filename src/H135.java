public class H135 {
    public int candy(int[] ratings) {
        int[] lToR = new int[ratings.length];
        int[] rToL = new int[ratings.length];
        for(int i=1; i< ratings.length; i++){
            if(ratings[i] > ratings[i-1]) {
                lToR[i] = lToR[i-1] + 1;
            }
        }
        for(int i= ratings.length-2; i>=0; i--){
            if(ratings[i] > ratings[i+1]) {
                rToL[i] = rToL[i+1] + 1;
            }
        }
        int res = ratings.length;
        for(int i=0; i< ratings.length; i++){
            res += Math.max(lToR[i], rToL[i]);
        }
        return res;
    }
}
