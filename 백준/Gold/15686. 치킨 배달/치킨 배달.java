import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static int[][] board;
	static ArrayList<Integer[]> stores=new ArrayList<>();
	static ArrayList<Integer[]> homes=new ArrayList<>();
	static ArrayList<Integer> temp=new ArrayList<>();
	static int home, store, M;
	static int[][] distance;
	static int ans=Integer.MAX_VALUE;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		M=sc.nextInt();
		home=0;
		store=0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				int a=sc.nextInt();
				switch(a) {
				case 1:
					Integer[] temp= {i,j};
					homes.add(temp);
					home++;
					break;
				case 2:
					Integer[] temp2= {i,j};
					stores.add(temp2);
					store++;
					break;
				}
			}
		}
		distance=new int[home][store];
		for(int i=0; i<home; i++) {
			for(int j=0; j<store; j++) {
				int a=Math.abs((int)homes.get(i)[0]-(int)stores.get(j)[0]);
				int b=Math.abs((int)homes.get(i)[1]-(int)stores.get(j)[1]);
				distance[i][j]=a+b;
			}
		}
		
		dup(0, -1);
		System.out.println(ans);
	}
	static void dup(int a, int b) {
		if(a==M-1) {
			for(int k=b+1; k<store; k++) {
				temp.add(k);
				ans=Math.min(calc(), ans);
				temp.remove(temp.size()-1);
			}
		}else {
			for(int j=b+1; j<store; j++) {
				int j2=j;
				temp.add(j);
				dup(a+1, j2);
				temp.remove(temp.size()-1);
			}
		}
	}
	static int calc() {
		int sum=0;
		for(int i=0; i<home; i++) {
			int min=Integer.MAX_VALUE;
			for(int j=0; j<temp.size(); j++) {
				min=Math.min(min, distance[i][temp.get(j)]);
			}
			sum+=min;
		}
		return sum;
	}
}