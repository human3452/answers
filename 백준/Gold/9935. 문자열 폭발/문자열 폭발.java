import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String target=br.readLine();
        String bomb=br.readLine();
        Stack<Character> stack=new Stack<>();
        Stack<Character> buffer=new Stack<>();
        outer:for(int i=0; i<target.length(); i++){
            char temp=target.charAt(i);
            stack.add(temp);
            if(temp==bomb.charAt(bomb.length()-1)){
                buffer.add(stack.pop());
                for(int j=bomb.length()-2; j>=0; j--){
                    if(!stack.isEmpty() && stack.peek()==bomb.charAt(j)){
                        buffer.add(stack.pop());
                    }else{
                        while(!buffer.isEmpty()) stack.add(buffer.pop());
                        continue outer;
                    }
                }
                buffer.clear();
            }
        }
        if(stack.isEmpty()) System.out.print("FRULA");
        else {
            StringBuilder sb = new StringBuilder();
            while (!stack.isEmpty()) sb.append(stack.pop());
            System.out.print(sb.reverse());
        }
    }
}