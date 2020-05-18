import java.util.*;

public class E929 {

    // My solution
    public int numUniqueEmails(String[] emails) {
        Set<String> a = new HashSet<>();
        for(String s: emails){
            int ind1 = s.indexOf('@');
            String local = s.substring(0, ind1);
            int ind2 = local.indexOf('+');
            if(ind2 != -1) local = local.substring(0, ind2);
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < local.length(); ++i) if(local.charAt(i)!='.') sb.append(local.charAt(i));
            a.add(sb.append(s.substring(ind1, s.length()-1)).toString());
        }
        return a.size();
    }
}
