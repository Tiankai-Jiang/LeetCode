public class E859 {

    // My solution
    public boolean buddyStrings(String A, String B) {
        if(A.length() != B.length()) return false;
        int count=0;
        boolean same = false;
        int[] re = new int[26], diff = new int[]{-1,-1};
        for(int i = 0; i < A.length(); ++i){
            char c = A.charAt(i);
            if(c!=B.charAt(i)){
                if(count == 2) return false;
                else diff[count++] = i;
            }
            if(++re[c-'a'] == 2) same = true;
        }
        if(diff[0]==-1 && diff[1]==-1) return same;
        else if(diff[0]==-1 && diff[1]!=-1) return false;
        else return A.charAt(diff[0]) == B.charAt(diff[1]) && A.charAt(diff[1]) == B.charAt(diff[0]);
    }
}
