import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int N= Integer.parseInt(br.readLine());
        StringTokenizer st=new StringTokenizer(br.readLine());
        Deque<Integer> deque=new LinkedList<>();
        for(int i=0; i<N; i++){
            deque.add(Integer.parseInt(st.nextToken()));
        }
        int low=Integer.MIN_VALUE;
        int high=Integer.MAX_VALUE;
        int min=Integer.MAX_VALUE;
        while(deque.size()>1){
            if(Math.abs(deque.getFirst()+deque.getLast())<Math.abs(min)){
                low= deque.getFirst();
                high=deque.getLast();
                min= deque.getFirst()+ deque.getLast();
            }
            if(Math.abs(deque.getFirst())<Math.abs(deque.getLast())){
                deque.pollLast();
            }else deque.pollFirst();
        }
        System.out.print(low+" "+high);
    }
}