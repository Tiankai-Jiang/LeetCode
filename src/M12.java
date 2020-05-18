public class M12 {

    // My solution
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        while(num>=1000){
            num -= 1000;
            sb.append('M');
        }
        if(num>=900){
            num -= 900;
            sb.append("CM");
        }
        if(num>=500){
            num -= 500;
            sb.append('D');
        }
        if(num>=400){
            num -= 400;
            sb.append("CD");
        }
        while(num>=100){
            num -= 100;
            sb.append('C');
        }
        if(num>=90){
            num -= 90;
            sb.append("XC");
        }
        if(num>=50){
            num -= 50;
            sb.append('L');
        }
        if(num>=40){
            num -= 40;
            sb.append("XL");
        }
        while(num>=10){
            num -= 10;
            sb.append('X');
        }
        if(num>=9){
            num -= 9;
            sb.append("IX");
        }
        if(num>=5){
            num -= 5;
            sb.append('V');
        }
        if(num>=4){
            num -= 4;
            sb.append("IV");
        }
        while(num>=1){
            num--;
            sb.append('I');
        }
        return sb.toString();
    }

    // lol
    public static String intToRoman2(int num) {
        String M[] = {"", "M", "MM", "MMM"};
        String C[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String X[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String I[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        return M[num/1000] + C[(num%1000)/100] + X[(num%100)/10] + I[num%10];
    }
}
