public class E1370 {

    // My solution
    public String sortString(String s) {
        int[] alphabet = new int[26];
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()) alphabet[c-'a']++;
        int l = 0;
        while(l < s.length()){
            for(int i = 0; i < 26; ++i){
                if(alphabet[i] > 0) {
                    sb.append((char)('a'+ i));
                    alphabet[i]--;
                    l++;
                }
            }
            for(int i = 25; i >= 0; --i){
                if(alphabet[i] > 0) {
                    sb.append((char)('a'+i));
                    alphabet[i]--;
                    l++;
                }
            }
        }
        return sb.toString();
    }
}
