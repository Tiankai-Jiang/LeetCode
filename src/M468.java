public class M468 {

    private String checkIPv4(String IP){
        for(String str: IP.split("\\.")){
            if(!str.matches("[\\d]{1,3}")) return "Neither";
            if(str.length() > 1 && str.charAt(0) == '0') return "Neither";
            if(Integer.parseInt(str) > 255) return "Neither";
        }
        return "IPv4";
    }

    private String checkIPv6(String IP){
        String[] strs = IP.split(":");
        if(strs.length != 8) return "Neither";
        for(String str: strs) if(!str.matches("[\\da-fA-F]{1,4}")) return "Neither";
        return "IPv6";
    }

    public String validIPAddress(String IP) {
        if(IP.length() < 7 || IP.length() > 39) return "Neither";
        int numPeriod = 0, numColumn = 0;
        for(char c: IP.toCharArray()){
            if(c == '.') numPeriod++;
            else if(c == ':') numColumn++;
        }
        if(numPeriod == 3 || numColumn == 7){
            if(numPeriod > 0 && numColumn > 0) return "Neither";
            else if(numPeriod == 3) return checkIPv4(IP);
            else return checkIPv6(IP);
        }else return "Neither";
    }
}
