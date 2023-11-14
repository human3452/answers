import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Movement{
        int No;
        char direction;

        Movement(int a, char b){
            No=a;
            direction=b;
        }
        @Override
        public String toString() {
            return No+" "+direction;
        }
    }
    static class Tank{
        int no, x, y;

        Tank(int a, int b, int c){
            x=a;
            y=b;
            no=c;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int N= Integer.parseInt(st.nextToken());
        int board[][]=new int[N+1][N+1];
        Queue<Movement> queue=new LinkedList<>();
        PriorityQueue<Tank> yTanks=new PriorityQueue<>(new Comparator<Tank>() {
            @Override
            public int compare(Tank o1, Tank o2) {
                return o1.y-o2.y;
            }
        }) ;
        TreeMap<Integer, LinkedList<Tank>> ymap=new TreeMap<>();
        TreeMap<Integer, LinkedList<Tank>> xmap=new TreeMap<>();
        for(int i=1; i<=N; i++){
            st=new StringTokenizer(br.readLine());
            int x= Integer.parseInt(st.nextToken());
            int y= Integer.parseInt(st.nextToken());
            board[x][y]=i;
            board[x][0]++;
            board[0][y]++;
            if(!ymap.containsKey(y)) ymap.put(y, new LinkedList<>());
            if(!xmap.containsKey(x)) xmap.put(x, new LinkedList<>());
            ymap.get(y).add(new Tank(x,y, i));
            xmap.get(x).add(new Tank(x,y, i));
        }
        int ysum=0;
        //LEFT
        for(int i=1; i<=N; i++){
            if(board[0][i]==0) {
                if (ysum <= i-1) {
                    //땡겨오는건 오른쪽에서?
                    int tmp=ymap.ceilingKey(i);
                    Tank temp=ymap.get(tmp).poll();
                    if(ymap.get(tmp).size()==0) ymap.remove(tmp);
                    board[0][tmp]--;
                    board[0][i]++;
                    if(!ymap.containsKey(i)) ymap.put(i, new LinkedList<>());
                    ymap.get(i).add(temp);
                    for(int j=i; j<tmp; j++) queue.add(new Movement(temp.no,'L'));
                }
            }
            ysum+=board[0][i];
        }
        //RIGHT
        ysum=0;
        for(int i=N; i>=1; i--){
            if(board[0][i]==0) {
                    //땡겨오는건 왼쪽에서?
                    int tmp=ymap.floorKey(i);
                    Tank temp=ymap.get(tmp).poll();
                    if(ymap.get(tmp).size()==0) ymap.remove(tmp);

                    board[0][tmp]--;
                    board[0][i]++;
                    if(!ymap.containsKey(i)) ymap.put(i, new LinkedList<>());
                    ymap.get(i).add(temp);
                    for(int j=tmp; j<i; j++) {
                        queue.add(new Movement(temp.no,'R'));
                    }
            }
            ysum+=board[0][i];
        }
        //UP
        ysum=0;
        for(int i=1; i<=N; i++){
            if(board[i][0]==0) {
                if (ysum <= i-1) {
                    int tmp=xmap.ceilingKey(i);
                    Tank temp=xmap.get(tmp).poll();
                    if(xmap.get(tmp).size()==0) xmap.remove(tmp);
                    board[tmp][0]--;
                    board[i][0]++;
                    if(!xmap.containsKey(i)) xmap.put(i, new LinkedList<>());
                    xmap.get(i).add(temp);
                    for(int j=i; j<tmp; j++) {
                        queue.add(new Movement(temp.no,'U'));
                    }
                }
            }
            ysum+=board[i][0];
        }
        //DOWN
        ysum=0;
        for(int i=N; i>=1; i--){
            if(board[i][0]==0) {
                    int tmp=xmap.floorKey(i);
                    Tank temp=xmap.get(tmp).poll();
                    if(xmap.get(tmp).size()==0) xmap.remove(tmp);
                    board[tmp][0]--;
                    board[i][0]++;
                    if(!xmap.containsKey(i)) xmap.put(i, new LinkedList<>());
                    xmap.get(i).add(temp);
                    for(int j=tmp; j<i; j++) queue.add(new Movement(temp.no,'D'));
            }
            ysum+=board[i][0];
        }
        System.out.println(queue.size());
        while(!queue.isEmpty()){
            System.out.println(queue.poll().toString());
        }
    }
}
