import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String A=br.readLine();
        int M= Integer.parseInt(br.readLine());
        Stack<Character> leftstack=new Stack<>();
        Stack<Character> rightstack=new Stack<>();
        for(int i=0; i<A.length();i++){
            leftstack.add(A.charAt(i));
        }
        for(int i=0; i<M; i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            switch(st.nextToken().charAt(0)){
                case 'P':
                    leftstack.push(st.nextToken().charAt(0));
                    break;
                case 'L':
                    if(!leftstack.isEmpty()) rightstack.add(leftstack.pop());
                    break;
                case 'D':
                    if(!rightstack.isEmpty()) leftstack.add(rightstack.pop());
                    break;
                case 'B':
                    if(!leftstack.isEmpty()) leftstack.pop();
                    break;
            }
        }
        StringBuilder sb=new StringBuilder();
        while(!rightstack.isEmpty()) leftstack.add(rightstack.pop());
        while(!leftstack.isEmpty()) sb.append(leftstack.pop());
        System.out.print(sb.reverse().toString());
    }
}