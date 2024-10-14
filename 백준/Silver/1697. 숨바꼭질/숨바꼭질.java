import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1=new StringTokenizer(br.readLine());
        int N= Integer.parseInt(st1.nextToken());
        int K= Integer.parseInt(st1.nextToken());
        if(N==K){
            System.out.println(0);
            System.exit(0);
        }
        boolean[] visited=new boolean[200002];
        Queue<int[]> queue=new LinkedList<>();
        queue.add(new int[]{N,0});
        while(!queue.isEmpty()){
            int[] current=queue.poll();
            int minus=current[0]-1;
            int plus=current[0]+1;
            int multiply=current[0]*2;
            if(minus==K || plus==K || multiply==K){
                System.out.println(current[1]+1);
                break;
            }
            if(minus>=0 && !visited[minus]){
                visited[minus]=true;
                queue.add(new int[]{minus, current[1]+1});
            }
            if(plus<=100000 && !visited[plus]){
                visited[plus]=true;
                queue.add(new int[]{plus, current[1]+1});
            }
            if(multiply<=200000 && !visited[multiply]){
                visited[multiply]=true;
                queue.add(new int[]{multiply, current[1]+1});
            }
        }
    }
}