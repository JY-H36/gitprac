package recursion;
import java.util.Scanner;
public class Chick_Rabbit {
	public static void getMax_Min(int n) {
		int max=0, min=0;
		if(n%2!=0) 
			;
		else if(n%4==0) {
			max=n/2;
			min=n/4;
		}else {
			max=n/2;
			min=(n+2)/4;
		}
		System.out.println("MAX:"+max+"  MIN:"+min);
	}
	public static void input(int n) {
		int i=1;
		int num;
		Scanner sc=new Scanner(System.in);
		while(i<=n) {
			num=sc.nextInt();
			getMax_Min(num);
		}
	}
	public static void main(String[] args) {
		input(2);
	}
}
