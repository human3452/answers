class Solution {
    static final int[] dx={-1, 0, 1, 0};
    static final int[] dy={0, 1, 0, -1};
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        for(int i=0; i<4; i++){
            int nx=h+dx[i];
            int ny=w+dy[i];
            if(nx>=0 && nx<board.length && ny>=0 && ny<board.length && board[nx][ny].equals(board[h][w])){
                answer++;
            }
        }
        return answer;
    }
}