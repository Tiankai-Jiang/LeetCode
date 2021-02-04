import java.util.*;
public class M1209 {

    public String removeDuplicates(String s, int k) {
        if(s.length()<2) return s;
        char[] arr = s.toCharArray();
        Stack<Character> charStack = new Stack<>();
        Stack<Integer>[] lens = new Stack[26];
        for(int i=0; i<26; i++) lens[i] = new Stack<>();
        for(int i=0; i<arr.length; i++){
            if(charStack.isEmpty()){
                charStack.push(arr[i]);
                lens[arr[i]-'a'].push(1);
            }else{
                if(charStack.peek() == arr[i]){
                    if(lens[arr[i]-'a'].peek()==k-1){
                        for(int j=0; j<k-1; j++) charStack.pop();
                        lens[arr[i]-'a'].pop();
                    }else{
                        charStack.push(arr[i]);
                        Stack<Integer> curCharStack = lens[arr[i]-'a'];
                        curCharStack.push(curCharStack.pop()+1);
                    }
                }else{
                    charStack.push(arr[i]);
                    lens[arr[i]-'a'].push(1);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!charStack.isEmpty()) sb.append(charStack.pop());
        return sb.reverse().toString();
    }
}
