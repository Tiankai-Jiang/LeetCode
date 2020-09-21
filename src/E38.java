public class E38 {
    public String countAndSay(int n) {
        if(n==1) return "1";
        String[] res = new String[n];
        res[0] = "1";
        for(int i=1; i<n; i++){
            String prev = res[i-1];
            StringBuilder sb = new StringBuilder();
            int count = 1;
            for(int j=1; j<prev.length(); j++){
                if(prev.charAt(j-1)==prev.charAt(j)) count++;
                else{
                    sb.append(count).append(prev.charAt(j-1));
                    count = 1;
                }
            }
            res[i] = sb.append(count).append(prev.charAt(prev.length()-1)).toString();
        }
        return res[n-1];
    }
}
