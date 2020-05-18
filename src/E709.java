import sun.awt.geom.AreaOp;

import java.util.*;

public class E709 {
    // My solution 1
    public String toLowerCase(String str) {
        return str.toLowerCase();
    }

    // My solution 2, really stupid
    public String toLowerCase2(String str) {
        Map<Character, Character> m = new HashMap<Character, Character>() {{
            put('A', 'a');
            put('B', 'b');
            put('C', 'c');
            put('D', 'd');
            put('E', 'e');
            put('F', 'f');
            put('G', 'g');
            put('H', 'h');
            put('I', 'i');
            put('J', 'j');
            put('K', 'k');
            put('L', 'l');
            put('M', 'm');
            put('N', 'n');
            put('O', 'o');
            put('P', 'p');
            put('Q', 'q');
            put('R', 'r');
            put('S', 's');
            put('T', 't');
            put('U', 'u');
            put('V', 'v');
            put('W', 'w');
            put('X', 'x');
            put('Y', 'y');
            put('Z', 'z');
        }};

        StringBuilder sb = new StringBuilder();
        String res = "";
        for(int i = 0; i < str.length(); ++i){
            char tmp = str.charAt(i);
            res =  m.containsKey(tmp) ? res + m.get(tmp) : res + tmp;
        }
        return res;
    }

    // bitwise computation
    public String toLowerCase3(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = (char)(str.charAt(i) | (char)(32));

            sb.append(c);
        }
        return sb.toString();
    }
}
