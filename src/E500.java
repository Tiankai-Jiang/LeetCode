import java.util.ArrayList;
import java.util.stream.Stream;

public class E500 {

    // My solution, which does not use set
    public String[] findWords(String[] words) {
        ArrayList<String> a = new ArrayList<>();
        boolean[] firstRow = new boolean[]{false, false, false, false, true, false, false, false, true, false, false, false, false, false, true, true, true, true, false, true, true, false, true, false, true, false};
        boolean[] secondRow = new boolean[]{true, false, false, true, false, true, true, true, false, true, true, true, false, false, false, false, false, false, true, false, false, false, false, false, false, false};
        boolean[] thirdRow = new boolean[]{false, true, true, false, false, false, false, false, false, false, false, false, true, true, false, false, false, false, false, false, false, true, false, true, false, true};
        for(String word : words){
            boolean f = false, s = false, t = false;
            for(char l : word.toCharArray()){
                int ind = Character.toLowerCase(l) - 'a';
                if(firstRow[ind]) f = true;
                if(secondRow[ind]) s = true;
                if(thirdRow[ind]) t = true;
            }
            if(!f ^ !s ^ !t ^ !(f && s && t)) a.add(word);
        }
        return a.toArray(new String[0]);
    }

    // Using regex, slow but elegant
    public String[] findWords2(String[] words) {
        return Stream.of(words).filter(s -> s.toLowerCase().matches("[qwertyuiop]*|[asdfghjkl]*|[zxcvbnm]*")).toArray(String[]::new);
    }
}
