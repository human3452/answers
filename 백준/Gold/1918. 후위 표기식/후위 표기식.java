import java.io.*;
import java.util.*;
public class Main {
    static final HashMap<Character, Integer> map=new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        map.put('+', 1);
        map.put('-', 1);
        map.put('*', 2);
        map.put('/', 2);
        map.put('(', 3);
        map.put(')', 0);
        String math=br.readLine();
        Queue<Character> queue=new LinkedList<>();
        Stack<Character> stack=new Stack<>();
        for(int i=0; i<math.length(); i++){
            if(math.charAt(i)-'A'<26 && math.charAt(i)-'A'>=0){
                queue.add(math.charAt(i));
            }else{
                if(!stack.isEmpty()){
                    switch(map.get(math.charAt(i))){
                        case 1:
                            if(map.get(stack.peek())==1 || map.get(stack.peek())==2){
                                while(!queue.isEmpty()) bw.write(queue.poll()+"");
                                while(!stack.isEmpty() && (map.get(stack.peek())==1 || map.get(stack.peek())==2)){
                                    bw.write(stack.pop()+"");
                                }
                                stack.add(math.charAt(i));
                            }else{
                                stack.add(math.charAt(i));
                            }
                            break;
                        case 2:
                            if(map.get(stack.peek())==2){
                                while(!queue.isEmpty()) bw.write(queue.poll()+"");
                                while(!stack.isEmpty() && map.get(stack.peek())==2){
                                    bw.write(stack.pop()+"");
                                }
                                stack.add(math.charAt(i));
                            }else{
                                stack.add(math.charAt(i));
                            }
                            break;
                        case 3:
                            stack.add('(');
                            break;
                        case 0:
                            while(!queue.isEmpty()) bw.write(queue.poll()+"");
                            while(stack.peek()!='('){
                                bw.write(stack.pop()+"");
                            }
                            stack.pop();
                            break;
                    }
                }else{
                    stack.add(math.charAt(i));
                }
            }
        }
        while(!queue.isEmpty()) bw.write(queue.poll()+"");
        while(!stack.isEmpty()) bw.write(stack.pop()+"");
        bw.flush();
        bw.close();
        br.close();
    }
}