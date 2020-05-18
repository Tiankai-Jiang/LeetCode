public class E1281 {
    // My solution
    public int subtractProductAndSum(int n) {
        int sum = 0, product = 1;
        while(n>9){
            sum += n%10;
            product *= n%10;
            n /= 10;
        }
        return product * n - sum - n;
    }

    // no need to consider n <=9
    public int subtractProductAndSum2(int n) {
        int sum = 0, product = 1;
        while(n>0){
            sum += n%10;
            product *= n%10;
            n /= 10;
        }
        return product - sum;
    }
}
