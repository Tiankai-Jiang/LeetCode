import java.util.*;
public class E13 {

    // My solution
    public int romanToInt(String s) {
        int a = 0;
        for(int i = s.length()-1; i >= 0; --i){
            char c = s.charAt(i);
            if(c=='I') a++;
            else if(c=='V'){
                if(i-1>=0 && s.charAt(i-1)=='I'){
                    a+=4;
                    --i;
                }else a+=5;
            }else if(c=='X'){
                if(i-1>=0 && s.charAt(i-1)=='I'){
                    a+=9;
                    --i;
                }else a+=10;
            }else if(c=='L'){
                if(i-1>=0 && s.charAt(i-1)=='X'){
                    a+=40;
                    --i;
                }else a+=50;
            }else if(c=='C'){
                if(i-1>=0 && s.charAt(i-1)=='X'){
                    a+=90;
                    --i;
                }else a+=100;
            }else if(c=='D'){
                if(i-1>=0 && s.charAt(i-1)=='C'){
                    a+=400;
                    --i;
                }else a+=500;
            }else if(c=='M'){
                if(i-1>=0 && s.charAt(i-1)=='C'){
                    a+=900;
                    --i;
                }else a+=1000;
            }
        }
        return a;
    }

    // When result is greater than 5, 'I' can only be minus ...
    public static int romanToInt2(String s) {
        int res = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            switch (c) {
                case 'I':
                    res += (res >= 5 ? -1 : 1);
                    break;
                case 'V':
                    res += 5;
                    break;
                case 'X':
                    res += 10 * (res >= 50 ? -1 : 1);
                    break;
                case 'L':
                    res += 50;
                    break;
                case 'C':
                    res += 100 * (res >= 500 ? -1 : 1);
                    break;
                case 'D':
                    res += 500;
                    break;
                case 'M':
                    res += 1000;
                    break;
            }
        }
        return res;
    }
}
