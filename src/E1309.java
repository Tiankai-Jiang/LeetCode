public class E1309 {
    public String freqAlphabets(String s) {
        StringBuilder sb = new StringBuilder();
        int i = s.length() - 1;
        while(i >= 0){
            if(s.charAt(i) == '#') {
                sb.insert(0, (char)(96 + (s.charAt(--i) - '0') + 10 * (s.charAt(--i) - '0')));
                i--;
            }
            else sb.insert(0, (char)(96 + (s.charAt(i--) - '0')));
        }
        return sb.toString();
    }
}
