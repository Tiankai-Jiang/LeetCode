public class H44 {
    public boolean isMatch(String s, String p) {
        if (p.equals(s) || p.equals("*")) return true;
        if (p.isEmpty() || s.isEmpty()) return false;
        boolean[][] d = new boolean[p.length() + 1][s.length() + 1];
        d[0][0] = true;

        for(int i = 1; i < p.length() + 1; i++) {
            if (p.charAt(i - 1) == '*') {
                int j = 1;
                // d[p_idx - 1][s_idx - 1] is a string-pattern match
                // on the previous step, i.e. one character before.
                // Find the first idx in string with the previous match.
                while ((!d[i - 1][j - 1]) && (j < s.length() + 1)) j++;
                // If (string) matches (pattern),
                // when (string) matches (pattern)* as well
                d[i][j - 1] = d[i - 1][j - 1];
                // If (string) matches (pattern),
                // when (string)(whatever_characters) matches (pattern)* as well
                while (j < s.length() + 1) d[i][j++] = true;
            } else if (p.charAt(i - 1) == '?') for(int j = 1; j < s.length() + 1; j++) d[i][j] = d[i - 1][j - 1];
            else for(int j = 1; j < s.length() + 1; j++) d[i][j] = d[i - 1][j - 1] && (p.charAt(i - 1) == s.charAt(j - 1));
        }
        return d[p.length()][s.length()];
    }
}
