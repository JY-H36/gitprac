package divide_and_rule;
import java.util.Scanner;
public class DifConfNums {

	public static int[] arr = new int[100];
	public static int size;
	public static int dif;
	
	/*
	 * 1:����ϣ�������˼�룬��ѡȡһ��������������������������ֳɲ�ͬ���飬��������Ѱ������ԣ�?
	 * ֱ������ĳԪ�ؼ��������󳬹����鳤�ȼ��������һ��Ԫ���Ѿ����Ƚ���? 2:�ظ��˹��̣�������ͬһ�����������������������?
	 * 3:�������ݼ���ÿ�μ�ȥ1�����ظ�1 2 4:ֱ��������Ϊ1�������һ��?1 2�����������������ܵ��������������?
	 */
	public static int getDifNums() {

		int count = 0;
		for (int d = size - 1; d >= 1; d--) {
			for (int j = 0; j < d; j++) {
				for (int i = j; i + d <= size - 1; i += d) {
					if (Math.abs(arr[i] - arr[i + d])==dif) {
						count += 1;
						System.out.print("<"+arr[i]+","+arr[i+d]+">");
						if(dif==0) {
							count+=1;
						}
					}
				}
			}
		}
		return count;
	}

	// ���ö��ַ����?
	// �������ݵݹ��壬�����˷ֽ��Լ���ǰ�������ֺϲ�
	public int getDifByBin(int low, int high) {
		if (low == high - 1) {
			if(Math.abs(arr[low] - arr[high])==dif) {
				System.out.print("<"+arr[low]+","+arr[high]+">");
				if(dif==0) {
					return 2;
				}
				return 1;
			}
			return 0;
		} else if (low == high) {
			return 0;
		} else {
			return getDifByBin(low, (low + high) / 2) + getDifByBin((low + high) / 2 + 1, high)
					+ getMerge(low, (low + high) / 2, high);
		}

	}

	// ǰ�������ֽ��кϲ�
	private static int getMerge(int low, int mid, int high) {
		int count = 0;
		for (int i = low; i <= mid; i++) {
			for (int j = mid + 1; j <= high; j++) {
				if(Math.abs(arr[i] - arr[j])==dif) {
					System.out.print("<"+arr[i]+","+arr[j]+">");
					if(dif==0) {
						count+=1;
					}
					count++;
				}
			}
		}
		return count;
	}

	public static void main(String[] args) {
		DifConfNums demo = new DifConfNums();
		Scanner sc=new Scanner(System.in);
		DifConfNums.size=sc.nextInt();
		//System.out.println("���ݳ���:" + size);
		DifConfNums.dif=sc.nextInt();
		//System.out.println("Ŀ����?:" + dif);
		for(int i=0;i<size;i++) {
			arr[i]=sc.nextInt();
		}
		//int count=demo.getDifNums();
		final int count = demo.getDifByBin(0, size - 1);
		System.out.println("���������Ķ���:" + count);
	}
}
