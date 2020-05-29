public class E258 {

    // My solution
    public int addDigits(int num) {
        return num == 0? 0 : (num%9==0? 9:num%9);
    }

    // Simpler
    public int addDigits2(int num) {
        return 1 + (num - 1) % 9;
    }
}
