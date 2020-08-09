public class H76 {

    // sliding window
    // first increase end to find a valid window
    // then increase start to reduce the window size
    public String minWindow(String s, String t) {
        int m[] = new int[128], start = 0, end = 0, minLen = Integer.MAX_VALUE, minStart = 0, l = t.length();
        for(char c: t.toCharArray()) m[c]++;
        while(end < s.length()){
            if(m[s.charAt(end++)]-- > 0) l--; // find the char at "end" position, increase end, if that char is greater than 0, which means it is one char in t, decrease l
            while(l==0){
                if(end-start < minLen) minLen = end - (minStart = start);
                if(m[s.charAt(start++)]++==0) l++; // find the char at "start" position, increase start, if that char is equal to 0, which means we removed a valid char, increase l
            }
        }
        return minLen==Integer.MAX_VALUE ? "" : s.substring(minStart, minStart+minLen);
    }
}
