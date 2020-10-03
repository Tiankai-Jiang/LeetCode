import java.util.*;
public class E937 {

    private boolean allDigits(String str){
        for(char c: str.toCharArray()) if(c != ' ' && !Character.isDigit(c)) return false;
        return true;
    }

    public String[] reorderLogFiles(String[] logs) {
        String[] res = new String[logs.length];

        PriorityQueue<String> letterLogs = new PriorityQueue<>((o1, o2) -> {
            int ind1 = o1.indexOf(' '), ind2 = o2.indexOf(' ');
            String log1 = o1.substring(ind1), log2 = o2.substring(ind2);
            if(log1.equals(log2)) return o1.substring(0, ind1).compareTo(o2.substring(0, ind2));
            else return log1.compareTo(log2);
        });
        List<String> digitLogs = new ArrayList<>();

        for(String str: logs){
            if(allDigits(str.substring(str.indexOf(' ')))) digitLogs.add(str);
            else letterLogs.offer(str);
        }

        int cur = 0;
        while(!letterLogs.isEmpty()) res[cur++] = letterLogs.poll();
        while(!digitLogs.isEmpty()) res[cur++] = digitLogs.remove(0);
        return res;
    }
}
