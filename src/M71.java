import java.util.*;
public class M71 {
    public String simplifyPath(String path) {
        Deque<String> stack = new LinkedList<>();
        for (String dir : path.split("/")) {
            if (dir.equals("..") && !stack.isEmpty()) stack.pop();
            else if (!dir.equals(".") && !dir.equals("..") && !dir.equals("")) stack.push(dir);
        }
        String res = "";
        for (String dir : stack) res = "/" + dir + res;
        return res.isEmpty() ? "/" : res;
    }
}
