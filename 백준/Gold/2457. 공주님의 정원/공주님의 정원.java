import java.util.*;

class Main{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        //일단 날짜를 숫자로 변환하는 작업을 거치자.
        int N=sc.nextInt();
        PriorityQueue<int[]> pq= new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1]!=o2[1]){
                    return o2[1]-o1[1];
                }else{
                    return o1[0]-o2[0];
                }
            }
        });
        for(int i=0; i<N; i++){
            int[] temp=new int[2];
            for(int j=0; j<2; j++) {
                int count = 0;
                switch (sc.nextInt()) {
                    case 12:
                        count += 30;
                    case 11:
                        count += 31;
                    case 10:
                        count += 30;
                    case 9:
                        count += 31;
                    case 8:
                        count += 31;
                    case 7:
                        count += 30;
                    case 6:
                        count += 31;
                    case 5:
                        count += 30;
                    case 4:
                        count += 31;
                    case 3:
                        count += 28;
                    case 2:
                        count += 31;
                    case 1:
                        count += sc.nextInt();
                        break;
                }
                temp[j]=count;
            }
            pq.add(temp);
        }
        int pointer=335;
        int answer=0;
        // 이제 구현
        while(pointer>60 && !pq.isEmpty()){
            int temp=pointer;
            while(!pq.isEmpty() && pq.peek()[1]>=pointer){
                int temp2[]=pq.poll();
                temp=Math.min(temp2[0],temp);
            }
            if(temp==pointer){
                System.out.println(0);
                System.exit(0);
            }
            answer++;
            pointer=temp;
        }
        if(pointer>60){
            System.out.println(0);
        }else System.out.println(answer);
    }
}
