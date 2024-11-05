import java.io.*;
import java.util.*;


public class Main {
    static final int[] dx={-1, 0, 1, 0};
    static final int[] dy={0, -1, 0, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        int T= Integer.parseInt(br.readLine());
        for(int tc=0; tc<T; tc++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            int max=0;
            int H= Integer.parseInt(st.nextToken());
            int W= Integer.parseInt(st.nextToken());
            char[][] board=new char[H][W];
            Queue<int[]> StartingPoint=new LinkedList<>();
            HashMap<Integer, ArrayList<int[]>> map=new HashMap<>();
            LinkedList<int[]> queue2=new LinkedList<>();
            boolean[] keys=new boolean[26];
            for(int i=0; i<H; i++){
                String temp= br.readLine();
                for(int j=0; j<W; j++){
                    char p=temp.charAt(j);
                    board[i][j]=p;
                    if((p=='.' || p=='$' || (p-'a'>=0 && p-'a'<26)) && (i==0 || i==H-1 || j==0 || j==W-1)){
                        StartingPoint.add(new int[]{i,j});
                        if(p=='$'){
                            board[i][j]='.';
                            max++;
                        }
                        if(p-'a'>=0 && p-'a'<26){
                            board[i][j]='.';
                            keys[p-'a']=true;
                        }
                    }
                    if(p-'A'>=0 && p-'A'<26){
                        if(!map.containsKey(p-'A')) map.put(p-'A', new ArrayList<>());
                        map.get(p-'A').add(new int[]{i,j});
                        if(i==0 || i==H-1 || j==0 || j==W-1) queue2.add(new int[]{i,j});
                    }
                }
            }

            String tsg=br.readLine();
            if(!tsg.equals("0")) {
                for (int i = 0; i < tsg.length(); i++) {
                    keys[tsg.charAt(i) - 'a'] = true;
                }
            }
            for(int i=0; i<26; i++){
                if(keys[i] && map.containsKey(i)){
                    for(int[] a: map.get(i)){
                        board[a[0]][a[1]]='.';
                    }
                }
            }
            for(int i=0; i<queue2.size(); i++){
                int[] temp=queue2.get(i);
                if(board[temp[0]][temp[1]]=='.'){
                    StartingPoint.add(new int[]{temp[0], temp[1]});
                    queue2.remove(i);
                    i--;
                }
            }
            //BFS

            boolean[][] visited=new boolean[H][W];

            while(!StartingPoint.isEmpty()) {
                while (!StartingPoint.isEmpty()) {
                    int[] temp = StartingPoint.poll();
                    visited[temp[0]][temp[1]]=true;
                    for (int i = 0; i < 4; i++) {
                        int nx = temp[0] + dx[i];
                        int ny = temp[1] + dy[i];
                        if (nx >= 0 && nx < H && ny >= 0 && ny < W && !visited[nx][ny] && board[nx][ny] != '*') {
                            //열쇠라면?
                            if (board[nx][ny] - 'a' >= 0 && board[nx][ny] - 'a' < 26) {
                                if (!keys[board[nx][ny] - 'a']) {
                                    keys[board[nx][ny] - 'a'] = true;
                                    if (map.containsKey(board[nx][ny] - 'a')) {
                                        for (int[] a : map.get(board[nx][ny] - 'a')) board[a[0]][a[1]] = '.';
                                    }
                                }
                                visited[nx][ny] = true;
                                StartingPoint.add(new int[]{nx, ny});
                                continue;
                            }
                            //문이라면?
                            if (board[nx][ny] - 'A' >= 0 && board[nx][ny] - 'A' < 26) {
                                queue2.add(new int[]{nx, ny});
                                continue;
                            }
                            //문서라면?
                            if (board[nx][ny] == '$') {
                                max++;
                                StartingPoint.add(new int[]{nx, ny});
                                visited[nx][ny] = true;
                                continue;
                            }
                            visited[nx][ny] = true;
                            StartingPoint.add(new int[]{nx, ny});
                        }
                    }
                }
                for(int i=0; i<queue2.size(); i++){
                    int[] temp=queue2.get(i);
                    if(board[temp[0]][temp[1]]=='.'){
                        StartingPoint.add(new int[]{temp[0], temp[1]});
                        queue2.remove(i);
                        i--;
                    }
                }
            }
            bw.write(max+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}