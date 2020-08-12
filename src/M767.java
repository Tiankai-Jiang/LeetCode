public class M767 {

    public String reorganizeString(String S) {
        int freq[] = new int[26], max = Integer.MIN_VALUE, l = S.length(), maxInd=0;
        for(char c: S.toCharArray()) max = Math.max(max, ++freq[c-'a']);
        if(max > (l+(l&1))/2) return "";
        else{
            char[] res = new char[l];
            max = 0;
            for(int i = 0; i < 26; i++){
                if(freq[i] > max){
                    max = freq[i];
                    maxInd = i;
                }
            }
            int ind;
            for(ind = 0; ind/2 < max; ind+=2) res[ind] = (char)('a'+maxInd);
            freq[maxInd] = 0;
            for(int i=0; i < 26; i++){
                while(freq[i]>0){
                    if(ind>=l) ind = 1;
                    res[ind] = (char)('a'+ i);
                    ind += 2;
                    freq[i]--;
                }
            }
            return String.valueOf(res);
        }
    }
}
