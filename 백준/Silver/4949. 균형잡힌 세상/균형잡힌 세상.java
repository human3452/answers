import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        outer:while(true){
            String test=br.readLine();
            if(test.equals(".")) break;
            Stack<Character> stack=new Stack<>();
            for(int i=0; i<test.length(); i++){
                switch (test.charAt(i)){
                    case '(':
                        stack.add('(');
                        break;
                    case ')':
                        if(!stack.isEmpty() && stack.peek()=='('){
                            stack.pop();
                        }else {
                            bw.write("no"+"\n");
                            continue outer;
                        }
                        break;
                    case '[':
                        stack.add('[');
                        break;
                    case ']':
                        if(!stack.isEmpty() && stack.peek()=='['){
                            stack.pop();
                        }else {
                            bw.write("no"+"\n");
                            continue outer;
                        }
                        break;
                }
            }
            if(stack.isEmpty()) bw.write("yes"+"\n");
            else bw.write("no"+"\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
