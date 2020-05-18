import java.util.*;

public class E1108 {
    // My solution
    public String defangIPaddr(String address) {
        return address.replaceAll("\\.", "[.]");
    }

    // String builder, faster
    public String defangIPaddr2(String address) {

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < address.length(); i++) {
            if(address.charAt(i) == '.') {
                sb.append("[.]");
            }
            else sb.append(address.charAt(i));
        }

        return sb.toString();
    }
}
