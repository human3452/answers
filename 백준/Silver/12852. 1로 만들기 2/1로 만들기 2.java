import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int N= Integer.parseInt(st.nextToken());
        int num[]=new int[N+1];
        Queue<Integer> queue=new LinkedList<>();
        queue.add(1);
        while(!queue.isEmpty()){
            int temp=queue.poll();
            if(temp*3<=N && num[temp*3]==0){
                num[temp*3]=3;
                if(temp*3==N) break;
                queue.add(temp*3);
            }
            if(temp*2<=N && num[temp*2]==0){
                num[temp*2]=2;
                if(temp*2==N) break;
                queue.add(temp*2);
            }
            if(temp<N && num[temp+1]==0){
                num[temp+1]=1;
                if(temp+1==N) break;
                queue.add(temp+1);
            }
        }
        int pointer=N;
        int count=0;
        queue.clear();
        while(pointer>1){
            queue.add(pointer);
            switch(num[pointer]){
                case 3:
                    pointer/=3;
                    break;
                case 2:
                    pointer/=2;
                    break;
                case 1:
                    pointer--;
                    break;
            }
            count++;
        }
        System.out.println(count);
        while(!queue.isEmpty()){
            System.out.print(queue.poll()+" ");
        }
        System.out.print(1);
    }
}
