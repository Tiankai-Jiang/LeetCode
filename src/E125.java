public class E125 {
    public boolean isPalindrome(String s) {
        if(s.length() < 2) return true;
        for(int i=0, j=s.length()-1; i<j; i++, j--){
            while(i < j && !Character.isDigit(s.charAt(i)) && !Character.isLetter(s.charAt(i))) i++;
            while(i < j && !Character.isDigit(s.charAt(j)) && !Character.isLetter(s.charAt(j))) j--;
            char f = s.charAt(i), r = s.charAt(j);
            if(Character.isDigit(f) != Character.isDigit(r)) return false;
            if(f != r && Math.abs(f-r) != 32) return false;
        }
        return true;
    }
}
