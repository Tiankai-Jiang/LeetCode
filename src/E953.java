public class E953 {
    public boolean isAlienSorted(String[] words, String order) {
        if(words.length <= 1) return true;
        order = " " + order;
        for(int i=0; i< words.length-1; i++) {
            String s1 = words[i], s2 = words[i+1];
            int len = s1.length();
            if(s1.length() > s2.length()){
                s2 += " ";
                len = s2.length();
            }else if(s1.length() < s2.length()) {
                s1 += " ";
                len += 1;
            }
            boolean res = true;
            for(int j=0; j<len; j++){
                int a = order.indexOf(s1.charAt(j)), b = order.indexOf(s2.charAt(j));
                if(a < b) break;
                else if(a > b){
                    res = false;
                    break;
                }
            }
            if(!res) return false;
        }
        return true;
    }
}
