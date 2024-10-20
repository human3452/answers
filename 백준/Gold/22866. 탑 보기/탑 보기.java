import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int[] p;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N= Integer.parseInt(br.readLine());
        PriorityQueue<int[]> pq=new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1]==o2[1]){
                    return o1[0]-o2[0];
                }else{
                    return o2[1]-o1[1];
                }
            }
        });
        Stack<Integer> counter=new Stack<>();
        int[] answer=new int[N];
        int[] answer2=new int[N];
        int[] numbers=new int[N];
        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            int temp=Integer.parseInt(st.nextToken());
            pq.add(new int[]{i, temp});
            numbers[i]=temp;
        }
        for(int i=0; i<N; i++){
            while(!counter.isEmpty() && counter.peek()<=numbers[i]) counter.pop();
            answer2[i]+=counter.size();
            counter.add(numbers[i]);
        }
        counter.clear();

        for(int i=N-1; i>=0; i--){
            while(!counter.isEmpty() && counter.peek()<=numbers[i]) counter.pop();
            answer2[i]+=counter.size();
            counter.add(numbers[i]);
        }
        TreeMap<Integer, Boolean> exist=new TreeMap<>();
        Stack<Integer> buffer=new Stack<>();

        int before=-1;
        while(!pq.isEmpty()){
            int[] temp=pq.poll();
            if(temp[1]!=before){
                while(!buffer.isEmpty()) exist.put(buffer.pop(), true);
                before=temp[1];
            }
            int ceiling=Integer.MAX_VALUE;
            int floor=Integer.MIN_VALUE;
            if(exist.ceilingKey(temp[0])!=null){
                ceiling=exist.ceilingKey(temp[0]);
            }
            if(exist.floorKey(temp[0])!=null){
                floor=exist.floorKey(temp[0]);
            }
            if(ceiling==Integer.MAX_VALUE){
                if(floor==Integer.MIN_VALUE) answer[temp[0]]=0;
                else answer[temp[0]]=floor+1;
            }else{
                if(floor==Integer.MIN_VALUE) answer[temp[0]]=ceiling+1;
                else if(ceiling-temp[0]<temp[0]-floor){
                    answer[temp[0]]=ceiling+1;
                }else answer[temp[0]]=floor+1;
            }
            buffer.add(temp[0]);
        }

        for(int i=0; i<N; i++){
            if(answer[i]==0) System.out.println(0);
            else System.out.println(answer2[i]+" "+answer[i]);
        }
    }
}