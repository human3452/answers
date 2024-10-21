import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N= Integer.parseInt(br.readLine());
        Stack<Integer> stack=new Stack<>();
        for(int i=0; i<N; i++){
            stack.add(Integer.parseInt(br.readLine()));
        }
        int answer=0;
        int first=stack.pop();
        while(!stack.isEmpty()){
            answer+=Math.max(0, stack.peek()-first+1);
            first=Math.min(stack.pop(), first-1);
        }
        System.out.print(answer);
    }
}