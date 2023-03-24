package recursion;

import java.util.Scanner;

public class LuckyNumber {
	//获取十进制数各位上数之和
	public static int getSumOfD(int n) {
		int sum=0;
		if(n<10) {
			sum=n;
		}
		else {
			sum+=n%10+getSumOfD(n/10);
		}
		return sum;
	}
	
	//十进制转二进制
		public static int tranDtoB(int n) {
			int bin=0;
			if(n<2)
				return n;
			else {
				bin+=n%2+10*tranDtoB(n/2);
			}
			return bin;
		}
	
		
	//判断一个数是否是幸运数
		public static boolean isLucky(int n) {
			int sum1=getSumOfD(n);
			int m=tranDtoB(n);
			int sum2=getSumOfD(m);
			return sum1==sum2;
		}
	
	//获取小于等于n的幸运数个数
		public static int getLuckyNumber(int n) {
			int count=0;
			for(int i=1;i<=n;i++) {
				if(isLucky(i))
					count++;
			}
			return count;
		}
	public static void main(String[] args) {
		/*int num=123;
		int sum=getSumOfD(num);
		System.out.println(sum);
		int m=tranDtoB(num);
		System.out.println(m);*/
		Scanner sc=new Scanner(System.in);
		System.out.println("请输入一个正整数:");
		int n=sc.nextInt();
		int count=getLuckyNumber(n);
		System.out.println("小于等于n且为幸运数的数有:"+count+"个");
		
	}
}
