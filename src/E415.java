public class E415 {

    public String addStrings(String num1, String num2) {
        int c = 0, i1 = num1.length()-1, i2 = num2.length()-1;
        StringBuilder sb = new StringBuilder();
        while(i1 > -1 && i2 > -1){
            int a1 = num1.charAt(i1--)-'0', a2 = num2.charAt(i2--)-'0';
            sb.append((a1+a2+c)%10);
            c = (a1+a2+c)/10;
        }
        if(i1 > -1 || i2 > -1){
            int i = i1 > -1 ? i1 : i2;
            String s = i1 > -1 ? num1 : num2;
            while(i>-1){
                int a = s.charAt(i--)-'0';
                sb.append((a+c)%10);
                c = (a + c)/10;
            }
        }
        if(c > 0) sb.append(c);
        return sb.reverse().toString();
    }
}
