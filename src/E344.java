public class E344 {

    // My solution
    public void reverseString(char[] s) {
        char tmp;
        for(int i = 0; 2*i < s.length; ++i){
            tmp = s[i];
            s[i] = s[s.length - 1 - i];
            s[s.length - 1 - i] = tmp;
        }
    }
}
