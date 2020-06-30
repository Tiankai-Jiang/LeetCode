public class E171 {

    // My solution
    public int titleToNumber(String s) {
        return s.length()==0 ? 0 : (int)((s.charAt(0)-'@')*Math.pow(26, s.length()-1)) + titleToNumber(s.substring(1));
    }
}
