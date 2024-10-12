import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1;
        st1=new StringTokenizer(br.readLine(), " ");
        int N=Integer.parseInt(st1.nextToken());
        int K=Integer.parseInt(st1.nextToken());
        st1=new StringTokenizer(br.readLine(), " ");
        String table=st1.nextToken();
        int answer=0;
        Queue<Integer> burger=new LinkedList<>();
        Queue<Integer> people=new LinkedList<>();
        for(int i=0; i<N; i++){
            if(table.charAt(i)=='H'){
                burger.add(i);
            }else{
                people.add(i);
            }
        }
        while(!burger.isEmpty() && !people.isEmpty()){
            if(burger.peek()< people.peek()){
                if(people.peek()-burger.peek()>K){
                    burger.poll();
                }else{
                    people.poll();
                    burger.poll();
                    answer++;
                }
            }else{
                if(burger.peek()- people.peek()>K){
                    people.poll();
                }else{
                    people.poll();
                    burger.poll();
                    answer++;
                }
            }
        }
        System.out.print(answer);
    }
}