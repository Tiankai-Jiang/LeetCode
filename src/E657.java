public class E657 {

    // My solution
    public boolean judgeCircle(String moves) {
        int v = 0, h = 0;
        for(int i = 0; i < moves.length(); ++i){
            if(moves.charAt(i) == 'U') v++;
            else if(moves.charAt(i) == 'D') v--;
            else if(moves.charAt(i) == 'R') h++;
            else h--;
        }
        return v == 0 & h == 0;
    }
}
