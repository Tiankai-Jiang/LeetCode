public class E266 {
    public boolean canPermutePalindrome(String s) {
        int[] alphabets = new int[128];
        for(char c: s.toCharArray()) alphabets[c]++;
        int oddCount = 0;
        for(int i=0; i<128; i++){
            if((alphabets[i]&1)==1) oddCount++;
            if(oddCount>1) return false;
        }
        return true;
    }
}
