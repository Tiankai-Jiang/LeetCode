import java.util.*;
public class H273 {

    Map<Integer, String> m = new HashMap<Integer, String>(){{
        put(0, ""); put(1, "One"); put(2, "Two"); put(3, "Three"); put(4, "Four"); put(5, "Five");
        put(6, "Six"); put(7, "Seven"); put(8, "Eight"); put(9, "Nine"); put(10, "Ten");
        put(11, "Eleven"); put(12, "Twelve"); put(13, "Thirteen"); put(14, "Fourteen"); put(15, "Fifteen");
        put(16, "Sixteen"); put(17, "Seventeen"); put(18, "Eighteen"); put(19, "Nineteen"); put(20, "Twenty");
        put(30, "Thirty"); put(40, "Forty"); put(50, "Fifty"); put(60, "Sixty"); put(70, "Seventy"); put(80, "Eighty"); put(90, "Ninety");
    }};

    private String helper(int num) {
        if(num == 0) return "";
        else if(num < 20) return m.get(num);
        else if(num < 100) return (m.get(num - num%10) + " " + m.get(num%10)).trim();
        else if(num < 1000) return (m.get(num/100) + " Hundred " + helper(num%100)).trim();
        else if(num < 1000000) return (helper(num/1000) + " Thousand " + helper(num%1000)).trim();
        else if(num < 1000000000) return (helper(num/1000000) + " Million " + helper(num%1000000)).trim();
        else return (helper(num/1000000000) + " Billion " + helper(num%1000000000)).trim();
    }

    public String numberToWords(int num) {
        if(num == 0) return "Zero";
        return helper(num).trim();
    }
}
