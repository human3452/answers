import java.util.*;

class Main{
    static int R, C;
    static char board[][];
    static boolean test[][];
    static int[] dx={1, 0, 0, -1};
    static int[] dy={0, -1, 1, 0};
    static boolean f1;
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        R=sc.nextInt();
        C=sc.nextInt();
        board=new char[R][C];
        sc.nextLine();
        for(int i=0; i<R; i++){
            String a=sc.nextLine();
            for(int j=0; j<C; j++){
                board[i][j]=a.charAt(j);
            }
        }
        int N=sc.nextInt();
            for(int tc=0; tc<N; tc++){
                int height=R-sc.nextInt();
            if(tc%2==0){
                //왼쪽 출발
                for(int i=0; i<C; i++){
                    if(board[height][i]=='x'){
                        check(height, i);
                        break;
                    }
                }
            }else{
                for(int i=C-1; i>=0; i--){
                    if(board[height][i]=='x'){
                        check(height, i);
                        break;
                    }
                }
            }
        }
        //출력
        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                System.out.print(board[i][j]);
            }
            if(i==R-1) break;
            System.out.println();
        }
    }

    private static void check(int height, int loc) {
        board[height][loc]='.';
        test=new boolean[R][C];
        for(int i=0; i<4; i++){
            int nx=height+dx[i];
            int ny=loc+dy[i];
            if(nx>=0 && nx<R && ny>=0 && ny<C && board[nx][ny]=='x') {
                if(!bfs(nx, ny)){
                    return;
                }
            }
        }
    }

    private static boolean bfs(int x, int y) {
        if(test[x][y]==true) return true;
        boolean flag=false;
        ArrayList<int[]> list=new ArrayList<>();

        list.add(new int[] {x,y});
        test[x][y]=true;
        if(x==R-1) flag=true;
        int pointer=0;
        while(pointer<list.size()){
            int[] coor=list.get(pointer);
            if(coor[0]==R-1) flag=true;
            for(int i=0; i<4; i++){
                int nx=coor[0]+dx[i];
                int ny=coor[1]+dy[i];
                if(nx>=0 && nx<R && ny>=0 && ny<C && board[nx][ny]=='x' && !test[nx][ny]){
                    test[nx][ny]=true;
                    list.add(new int[] {nx,ny});
                }
            }
            pointer++;
        }
        if(!flag){
            boolean subtest[][] = new boolean[R][C];
            // 거리 측정
            int min=30000000;
            for(int i=0; i<list.size(); i++){
                subtest[list.get(i)[0]][list.get(i)[1]]=true;
            }
            for(int i=0; i<list.size(); i++){
                int coor[]=list.get(i);
                if(board[coor[0]+1][coor[1]]=='.'){
                    for(int j=coor[0]+1; j<R; j++){
                        if(board[j][coor[1]]=='x' && !subtest[j][coor[1]]){
                            min=Math.min(j-coor[0], min);
                            break;
                        }
                    }
                    min=Math.min(R-coor[0], min);
                }
            }
            // 이동
            min--;
            for(int i=0; i<list.size(); i++){
                board[list.get(i)[0]][list.get(i)[1]]='.';
            }
            for(int i=0; i<list.size(); i++){
                board[list.get(i)[0]+min][list.get(i)[1]]='x';
            }
        }
        return flag;
    }
}