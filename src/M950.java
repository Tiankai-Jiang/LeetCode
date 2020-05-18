import java.util.*;

public class M950 {

    // My solution, fastest
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        if(deck.length < 3) return deck;
        int a = deck.length, b = deck.length;
        while(b!=2){
            a += b/2;
            b = b%2 + b/2;
        }
        int[] d = new int[a], res = new int[deck.length];
        int move = a-1, addNew = a-2;
        d[move] = deck[deck.length-1];
        for(int j = deck.length-2; j>=0; --j){
            d[addNew] = deck[j];
            if(addNew==0) break;
            d[(addNew-=2)+1] = d[move--];
        }
        for(int i = 0; i < deck.length; ++i) res[i] = d[i];
        return res;
    }

    // Using a queue
    public int[] deckRevealedIncreasing2(int[] deck) {
        int n = deck.length;
        Arrays.sort(deck);
        Queue<Integer> q = new LinkedList<>();
        for (int i = n - 1; i >= 0; --i) {
            if (q.size() > 0) q.add(q.poll());
            q.add(deck[i]);
        }
        int[] res = new int[n];
        for (int i = n - 1; i >= 0; --i) res[i] = q.poll();
        return res;
    }
}
