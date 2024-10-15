import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int[] dx={-1, 0, 1, 0};
    static int[] dy={0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int T= Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int N= Integer.parseInt(br.readLine());
            int[] operation;
            for(int j=0; j<Math.pow(3,N-1); j++){
                operation=new int[N-1];
                int temp=j;
                int counter=N-2;
                while(temp>=9){
                    operation[counter]=temp%3;
                    temp/=3;
                    counter--;
                }
                operation[counter-1]=temp/3;
                operation[counter]=temp%3;
                //operation Start
                boolean flag2=true;
                int answer=0;
                int temp2=0;
                for(int k=1; k<N; k++){
                    temp2+=k;
                    switch (operation[k-1]){
                        case 1:
                            if(flag2){
                                answer+=temp2;
                                temp2=0;
                            }else{
                                answer-=temp2;
                                temp2=0;
                            }
                            flag2=true;
                            break;
                        case 2:
                            if(flag2){
                                answer+=temp2;
                                temp2=0;
                            }else{
                                answer-=temp2;
                                temp2=0;
                            }
                            flag2=false;
                            break;
                        case 0:
                            temp2=temp2*10;
                            break;
                    }
                }
                temp2+=N;
                if(flag2){
                    answer+=temp2;
                }else{
                    answer-=temp2;
                }
                if(answer==0){
                    for(int k=1; k<N; k++){
                        switch(operation[k-1]){
                            case 0:
                                System.out.print(k+" ");
                                break;
                            case 1:
                                System.out.print(k+"+");
                                break;
                            case 2:
                                System.out.print(k+"-");
                                break;
                        }
                    }
                    System.out.println(N);
                }
            }
            System.out.println();
        }
    }
}