public class E557 {

    // My solution
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        for(String t : s.split("\\s")) sb.append(new StringBuilder(t).reverse().toString()).append(" ");
        return sb.toString().trim();
    }
}
