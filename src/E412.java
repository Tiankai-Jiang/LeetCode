import java.util.*;
public class E412 {

    // My solution
    public List<String> fizzBuzz(int n) {
        List<String> a = new LinkedList<>();
        for(int i = 1; i <= n; ++i){
            if(i%3==0) a.add(i%5==0 ? "FizzBuzz" : "Fizz");
            else if(i%5==0) a.add("Buzz");
            else a.add(Integer.toString(i));
        }
        return a;
    }
}
