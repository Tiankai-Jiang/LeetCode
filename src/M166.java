import java.util.*;
public class M166 {
    public String fractionToDecimal(int numerator, int denominator) {
        StringBuilder result = new StringBuilder();
        String sign = (numerator < 0 == denominator < 0 || numerator == 0) ? "" : "-";
        long num = Math.abs((long) numerator), den = Math.abs((long) denominator);
        result.append(sign).append(num / den);
        long remainder = num % den;
        if (remainder == 0) return result.toString();
        result.append(".");
        HashMap<Long, Integer> hashMap = new HashMap<>();
        while (!hashMap.containsKey(remainder)) {
            hashMap.put(remainder, result.length());
            result.append(10 * remainder / den);
            remainder = 10 * remainder % den;
        }
        result.insert(hashMap.get(remainder), "(").append(")");
        return result.toString().replace("(0)", "");
    }
}
