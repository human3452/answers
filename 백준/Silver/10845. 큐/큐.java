import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        int N= Integer.parseInt(br.readLine());
        Deque<Integer> queue=new LinkedList<>();
        for(int i=0; i<N; i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            switch (st.nextToken()){
                case "push":
                    queue.add(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    if(!queue.isEmpty()) bw.write(queue.poll()+"\n");
                    else bw.write(-1+"\n");
                    break;
                case "size":
                    bw.write(queue.size()+"\n");
                    break;
                case "empty":
                    if(!queue.isEmpty()) bw.write(0+"\n");
                    else bw.write(1+"\n");
                    break;
                case "front":
                    if(!queue.isEmpty()) bw.write(queue.peekFirst()+"\n");
                    else bw.write(-1+"\n");
                    break;
                case "back":
                    if(!queue.isEmpty()) bw.write(queue.peekLast()+"\n");
                    else bw.write(-1+"\n");
                    break;
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
