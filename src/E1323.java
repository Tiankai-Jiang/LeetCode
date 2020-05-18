public class E1323 {

    // My solution
    public int maximum69Number (int num) {
        return Integer.parseInt(Integer.toString(num).replaceFirst("6", "9"));
    }

    // Find the first 6, faster
    public int maximum69Number2 (int num) {
        int firstSix = -1;
        int number = num;
        for(int i = 0; number > 0; i++){
            if(number % 10 == 6)firstSix = i;
            number /= 10;
        }
        return num + 3 * (int)Math.pow(10,firstSix);
    }
}
