public class M567 {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;
        int[] arr1 = new int[26], arr2 = new int[26];
        for(int i=0; i<s1.length(); i++) {
            arr1[s1.charAt(i)-'a']++;
            arr2[s2.charAt(i)-'a']++;
        }

        for(int i=0; i<26; i++) arr1[i] -= arr2[i];
        boolean res = true;
        for(int i=0; i<26; i++) if(arr1[i]!=0) res = false;
        if(res) return true;
        for(int i=0; i< s2.length()-s1.length(); i++){
            arr1[s2.charAt(i)-'a']++;
            arr1[s2.charAt(s1.length()+i)-'a']--;
            res = true;
            for(int j=0; j<26; j++) if(arr1[j]!=0) res = false;
            if(res) return true;
        }
        return false;
    }
}
