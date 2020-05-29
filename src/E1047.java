public class E1047 {

    // My solution
    public String removeDuplicates(String S) {
        StringBuilder sb = new StringBuilder();
        for(char c : S.toCharArray()){
            if(sb.length()==0 || c!=sb.charAt(sb.length()-1)) sb.append(c);
            else sb.setLength(sb.length() - 1);
        }
        return sb.toString();
    }

    // Using two pointers
    // i refers to the index to set next character in the output string.
    // j refers to the index of current iteration in the input string.
    //
    // Iterate characters of S one by one by increasing j.
    //
    // If S[j] is same as the current last character S[i - 1],
    // we remove duplicates by doing i -= 2.
    //
    // If S[j] is different as the current last character S[i - 1],
    // we set S[i] = S[j] and increment i++.
    public String removeDuplicates2(String s) {
        int i = 0, n = s.length();
        char[] res = s.toCharArray();
        for (int j = 0; j < n; ++j, ++i) {
            res[i] = res[j];
            if (i > 0 && res[i - 1] == res[i])  i -= 2; // count = 2
        }
        return new String(res, 0, i);
    }
}
