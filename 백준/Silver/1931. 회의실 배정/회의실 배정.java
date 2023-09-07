import java.util.*;

class Main{
    public static void main(String[] args)
    {
        PriorityQueue<int[]> pq=new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1]!=o2[1])  return o1[1]-o2[1];
                else return o1[0]-o2[0];
            }
        });
        Scanner sc = new Scanner(System.in);
        int N=sc.nextInt();
        for(int i=0; i<N; i++){
            pq.add(new int[] {sc.nextInt(), sc.nextInt()});
        }
        int cnt=1;
        int pointer=pq.poll()[1];
        while(!pq.isEmpty()){
            int[] temp=pq.poll();
            if(temp[0]>=pointer){
                cnt++;
                pointer=temp[1];
            }
        }
        System.out.println(cnt);
    }
}