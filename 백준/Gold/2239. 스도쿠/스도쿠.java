import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] board=new int[9][9];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashSet<Integer>[] row=new HashSet[9];
        HashSet<Integer>[] column=new HashSet[9];
        HashSet<Integer>[] square=new HashSet[9];
        for(int i=0; i<9; i++){
            row[i]=new HashSet<>();
            column[i]=new HashSet<>();
            square[i]=new HashSet<>();
        }
        ArrayList<int[]> remains=new ArrayList<>();
        for(int i=0; i<9; i++){
            String temp=br.readLine();
            for(int j=0; j<9; j++){
                board[i][j]=temp.charAt(j)-'0';
                if(temp.charAt(j)=='0'){
                    remains.add(new int[]{i, j});
                }else{
                    //row
                    row[i].add(temp.charAt(j)-'0');
                    //column
                    column[j].add(temp.charAt(j)-'0');
                    //square
                    square[SquareCheck(i, j)].add(temp.charAt(j)-'0');
                }
            }
        }
        int pointer=0;
        outer:while(pointer<remains.size()){
            int[] temp=remains.get(pointer);
            int before=board[temp[0]][temp[1]];
            square[SquareCheck(temp[0], temp[1])].remove(before);
            row[temp[0]].remove(before);
            column[temp[1]].remove(before);
            for(int i=before+1; i<=9; i++){
                if(row[temp[0]].contains(i)) continue;
                if(column[temp[1]].contains(i)) continue;
                //square
                if(square[SquareCheck(temp[0], temp[1])].contains(i)) continue;
                square[SquareCheck(temp[0], temp[1])].add(i);
                row[temp[0]].add(i);
                column[temp[1]].add(i);
                board[temp[0]][temp[1]]=i;
                pointer++;
                continue outer;
            }
            board[temp[0]][temp[1]]=0;
            pointer--;
        }
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }
    static int SquareCheck(int x, int y){
        if(x<3){
            if(y<3){
                return 0;
            }else if(y<6){
                return 1;
            }else{
                return 2;
            }
        }else if(x<6){
            if(y<3){
                return 3;
            }else if(y<6){
                return 4;
            }else{
                return 5;
            }
        }else{
            if(y<3){
                return 6;
            }else if(y<6){
                return 7;
            }else{
                return 8;
            }
        }
    }
}