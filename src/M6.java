public class M6 {

    public String convert(String s, int numRows) {
        if(numRows == 1) return s;
        int len = s.length(), maxInterval = 2 * (numRows - 1);
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<numRows; i++){
            int cur = i;
            int firstInterval = maxInterval - 2*i, secondInterval = maxInterval - firstInterval;
            int cycle = 0;
            while(cur<len){
                if((cycle++&1)==0 && firstInterval != 0){
                    sb.append(s.charAt(cur));
                    cur += firstInterval;
                }
                if((cycle++&1)==1 && cur<len && secondInterval != 0){
                    sb.append(s.charAt(cur));
                    cur += secondInterval;
                }
            }
        }
        return sb.toString();
    }
}
