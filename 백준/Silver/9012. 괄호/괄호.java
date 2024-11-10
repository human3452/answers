import java.io.*;
import java.util.*;

public class Main {
    static int[] p;
    static int[] candy;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N= Integer.parseInt(br.readLine());
        outer:for(int i=0; i<N; i++){
            Stack<Character> stack=new Stack<>();
            String temp=br.readLine();
            for(int j=0; j<temp.length(); j++){
                char tm=temp.charAt(j);
                if(tm=='('){
                    stack.add(tm);
                }else{
                    if(!stack.isEmpty()) stack.pop();
                    else{
                        bw.write("NO"+"\n");
                        continue outer;
                    }
                }
            }
            if(stack.isEmpty()) bw.write("YES"+"\n");
            else bw.write("NO"+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
