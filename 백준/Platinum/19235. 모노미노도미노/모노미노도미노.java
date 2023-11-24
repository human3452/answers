import java.util.HashSet;
import java.util.Scanner;

public class Main {
    static final int[] dx= {-1, 0, 1, 0};
    static final int[] dy= {0, 1, 0, -1};
    static int[][] green, blue;
    static int ans=0;

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        green=new int[6][4];
        blue=new int[4][6];
        int N=sc.nextInt();
        for(int i=1; i<=N; i++) {
            move(sc.nextInt(), sc.nextInt(), sc.nextInt(), i);
        }
        int left=0;
        for(int i=0; i<4; i++) {
            for(int k=0; k<6; k++) {
                if(blue[i][k]!=0) left++;
                if(green[k][i]!=0) left++;
            }
        }
        System.out.println(ans);
        System.out.println(left);
    }

    private static void move(int t, int x, int y, int no) {
        boolean f1=true;
        boolean f2=true;
        switch(t) {
            case 1:
                for(int i=0; i<6; i++) {
                    if(f1 && (green[i][y]!=0)) {
                        green[i-1][y]=no;
                        f1=false;
                    }
                    if(f2 && blue[x][i]!=0) {
                        blue[x][i-1]=no;
                        f2=false;
                    }
                    if(!(f1 || f2)) break;
                }
                if(f1) {
                    green[5][y]=no;
                }
                if(f2) {
                    blue[x][5]=no;
                }
                break;
            case 2:
                for(int i=0; i<6; i++) {
                    if(f1 && (green[i][y]!=0 || green[i][y+1]!=0)) {
                        green[i-1][y]=no;
                        green[i-1][y+1]=no;
                        f1=false;
                    }
                    if(f2 && blue[x][i]!=0) {
                        blue[x][i-1]=no;
                        blue[x][i-2]=no;
                        f2=false;
                    }
                    if(!(f1 || f2)) break;
                }
                if(f1) {
                    green[5][y]=no;
                    green[5][y+1]=no;
                }
                if(f2) {
                    blue[x][5]=no;
                    blue[x][4]=no;
                }
                break;

            case 3:
                for(int i=0; i<6; i++) {
                    if(f1 && green[i][y]!=0) {
                        green[i-1][y]=no;
                        green[i-2][y]=no;
                        f1=false;
                    }
                    if(f2 && (blue[x+1][i]!=0 || blue[x][i]!=0)) {
                        blue[x+1][i-1]=no;
                        blue[x][i-1]=no;
                        f2=false;
                    }
                    if(!(f1 || f2)) break;
                }
                if(f1) {
                    green[5][y]=no;
                    green[4][y]=no;
                }
                if(f2) {
                    blue[x+1][5]=no;
                    blue[x][5]=no;
                }
                break;
        }
        check();
        clean();
    }

    private static void check() {
        int f3=-1;
        int f4=-1;
        for(int i=5; i>=2; i--) {
            boolean f1=true;
            boolean f2=true;
            for(int j=0; j<4; j++) {
                if(green[i][j]==0) f1=false;
                if(blue[j][i]==0) f2=false;
            }
            //그린 가로줄
            if(f1) {
                for(int j=0; j<4; j++) green[i][j]=0;
                ans++;
                f3=i;
            }
            if(f2) {
                for(int j=0; j<4; j++) blue[j][i]=0;
                ans++;
                f4=i;
            }
        }
        if(f3!=-1) move2(f3,0);
        if(f4!=-1) move2(f4,1);
        if(f3+f4>0) check();
    }
    private static void move2(int start, int status){
        HashSet<Integer> set=new HashSet<>();
        if(status==0){
            //그린
            for(int i=start-1; i>=0; i--){
                outer:for(int j=0; j<4; j++){
                    if(green[i][j]!=0 && !set.contains(green[i][j])){
                        set.add(green[i][j]);
                        int temp=green[i][j];
                        if(i!=0 && green[i-1][j]==green[i][j]){
                            for(int k=i; k<5; k++){
                                if(green[k+1][j]!=0){
                                    if(k==i) continue outer;
                                    green[i-1][j]=0;
                                    green[i][j]=0;
                                    green[k][j]=temp;
                                    green[k-1][j]=temp;

                                    continue outer;
                                }
                            }
                            green[i-1][j]=0;
                            green[i][j]=0;
                            green[5][j]=temp;
                            green[4][j]=temp;
                        }else if(j!=3 && green[i][j+1]==green[i][j]){
                            for(int k=i; k<5; k++){
                                if(green[k+1][j]!=0 || green[k+1][j+1]!=0){
                                    if(k==i) continue outer;
                                    green[i][j]=0;
                                    green[i][j+1]=0;
                                    green[k][j]=temp;
                                    green[k][j+1]=temp;
                                    j++;
                                    continue outer;
                                }
                            }
                            green[i][j]=0;
                            green[i][j+1]=0;
                            green[5][j]=temp;
                            green[5][j+1]=temp;
                            j++;
                        }else{
                            for(int k=i; k<5; k++){
                                if(green[k+1][j]!=0){
                                    if(k==i) continue outer;
                                    green[i][j]=0;
                                    green[k][j]=temp;

                                    continue outer;
                                }
                            }
                            green[i][j]=0;
                            green[5][j]=temp;

                        }
                    }
                }
            }
        }else{
            //블루
            for(int i=start-1; i>=0; i--){
                outer:for(int j=0; j<4; j++){
                    if(blue[j][i]!=0 && !set.contains(blue[j][i])){
                        set.add(blue[j][i]);
                        int temp=blue[j][i];
                        if(i!=0 && blue[j][i-1]==blue[j][i]){
                            for(int k=i; k<5; k++){
                                if(blue[j][k+1]!=0){
                                    if(k!=i) {
                                        blue[j][i - 1] = 0;
                                        blue[j][i] = 0;
                                        blue[j][k] = temp;
                                        blue[j][k - 1] = temp;
                                    }
                                    continue outer;
                                }

                            }
                            blue[j][i-1]=0;
                            blue[j][i]=0;
                            blue[j][5]=temp;
                            blue[j][4]=temp;
                        }else if(j!=3 && blue[j+1][i]==blue[j][i]){
                            for(int k=i; k<5; k++){
                                if(blue[j][k+1]!=0 || blue[j+1][k+1]!=0){

                                    if(k==i) continue outer;
                                    blue[j][i]=0;
                                    blue[j+1][i]=0;
                                    blue[j][k]=temp;
                                    blue[j+1][k]=temp;
                                    j++;
                                    continue outer;
                                }


                            }
                            blue[j][i]=0;
                            blue[j+1][i]=0;
                            blue[j][5]=temp;
                            blue[j+1][5]=temp;
                            j++;
                        }else{
                            for(int k=i; k<5; k++){
                                if(blue[j][k+1]!=0){
                                    if(k==i) continue outer;
                                    blue[j][i]=0;
                                    blue[j][k]=temp;

                                    continue outer;
                                }
                            }
                            blue[j][i]=0;
                            blue[j][5]=temp;
                        }
                    }
                }
            }
        }
    }
    private static void clean() {
        for(int i=0; i<=1; i++) {
            for(int j=0; j<4; j++) {
                if(green[i][j]!=0) {
                    move(5,0);
                }
                if(blue[j][i]!=0) {
                    move(5,1);
                }
            }
        }

    }
    private static void move(int loc, int status) {
        if(status==0) {
            //녹색
            for(int i=loc-1; i>=0; i--) {
                for(int j=0; j<4; j++) {
                    green[i+1][j]=green[i][j];
                }
            }
            for(int i=0; i<4; i++) {
                green[0][i]=0;
            }
        }else {
            //파란색
            for(int i=loc-1; i>=0; i--) {
                for(int j=0; j<4; j++) {
                    blue[j][i+1]=blue[j][i];
                }
            }
            for(int i=0; i<4; i++) {
                blue[i][0]=0;
            }
        }
    }
}
