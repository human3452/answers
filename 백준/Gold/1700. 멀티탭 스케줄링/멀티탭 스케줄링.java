import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int N= Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        int answer=0;
        Queue<Integer>[] queue=new LinkedList[M+1];
        for(int i=1; i<=M; i++){
            queue[i]=new LinkedList<>();
        }
        HashSet<Integer> multitab=new HashSet<>();
        st=new StringTokenizer(br.readLine());
        Queue<Integer> procedure=new LinkedList<>();
        for(int i=0; i<M; i++){
            int temp= Integer.parseInt(st.nextToken());
            procedure.add(temp);
            queue[temp].add(i);
        }

        while(!procedure.isEmpty()){
            int temp=procedure.poll();
            queue[temp].poll();
            if(multitab.contains(temp)) continue;
            if(multitab.size()<N){
                multitab.add(temp);
            }else{
                int out=-1;
                int far=-1;
                for(int a:multitab){
                    if(queue[a].isEmpty()){
                        out=a;
                        break;
                    }
                    if(queue[a].peek()>far){
                        out=a;
                        far=queue[a].peek();
                    }
                }
                multitab.remove(out);
                answer++;
                multitab.add(temp);
            }
        }
        System.out.print(answer);
    }
}