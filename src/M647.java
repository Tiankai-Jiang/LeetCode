public class M647 {

    // My solution 1, O(n^3) super slow
    private boolean isPalindromic(String s, int i, int j){
        return j-i<2 ? s.charAt(i) == s.charAt(j) : s.charAt(i) == s.charAt(j) && isPalindromic(s, i+1, j-1);
    }

    public int countSubstrings(String s) {
        int a = 0;
        for(int i = 0; i < s.length()-1; ++i) for(int j = i+1; j<s.length(); ++j) if(isPalindromic(s, i, j)) a++;
        return a + s.length();
    }

    // start from each index and try to extend palindrome for both odd and even length
    public int countSubstrings2(String s) {
        int count=0;
        for(int i=0;i<s.length();i++){
            count+=extractPalindrome(s,i,i);//odd length
            count+=extractPalindrome(s,i,i+1);//even length
        }
        return count;
    }
    public int extractPalindrome(String s, int left, int right){
        int count=0;
        while(left>=0 && right<s.length()&& (s.charAt(left)==s.charAt(right))){
            left--;
            right++;
            count++;
        }
        return count;
    }
}
