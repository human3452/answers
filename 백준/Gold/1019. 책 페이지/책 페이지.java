
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String A=sc.nextLine();
        int number=Integer.parseInt(A);
        int[] answer=new int[10];
        for(int i=0; i<=A.length()-1; i++){
            int digit=A.charAt(A.length()-(i+1))-'0';
            int temp[]=new int[10];
            int num2= (int) (number/Math.pow(10, i+1));
            for(int j=0; j<10; j++){
                temp[j]+=num2;
            }
            temp[0]--;
            for(int j=0; j<digit; j++){
                temp[j]++;
            }
            for(int j=0; j<10; j++){
                temp[j]*=(Math.pow(10,i));
            }
            temp[digit]+=number%Math.pow(10,i);
            temp[digit]++;
            for(int j=0; j<10; j++){
                answer[j]+=temp[j];
            }
        }

        //출력
        for(int i=0; i<10; i++){
            System.out.print(answer[i]+" ");
        }
    }

}
