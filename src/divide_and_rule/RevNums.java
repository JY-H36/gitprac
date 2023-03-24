package divide_and_rule;
import java.util.Scanner;

/**   
*    
* ��Ŀ���ƣ�Algorithm   
* �����ƣ�RevNums   
* ������������һ�����е����������   
* �����ˣ�����ɽ   
* ����ʱ�䣺2023��3��23�� ����10:05:56   
* @version        
*/
public class RevNums {
	public static int[] arr=new int[] {3,1,4,5,2,1};
	public static int size;
	
	/*
	 * 1:����ϣ�������˼�룬��ѡȡһ��������������������������ֳɲ�ͬ���飬��������Ѱ������ԣ�ֱ������ĳԪ�ؼ��������󳬹����鳤�ȼ��������һ��Ԫ���Ѿ����Ƚ��ꡣ
	 * 2:�ظ��˹��̣�������ͬһ�����������������������
	 * 3:�������ݼ���ÿ�μ�ȥ1�����ظ�1 2
	 * 4:ֱ��������Ϊ1�������һ��1 2�����������������ܵ��������������
	 * ע��ϣ������������һ�ֲ��������������ϣ�������������������Ϊ�������������е���������������Ҳ��һ�ֽ���˼·
	*/
	public static int getRevNums() {
		System.out.println("�����:");
		int count=0;
		for(int d=arr.length-1;d>=1;d--) {
			for(int j=0;j<d;j++) {
				for(int i=j;i+d<=arr.length-1;i+=d) {
					if(arr[i]>arr[i+d]) {
						System.out.print("<"+arr[i]+","+arr[i+d]+">");
						count+=1;
					}
				}
			}	
		}
		return count;
	}
	
	/*
	 * ����˼·�������ݷֳ������֣�������������ߵ�����ԣ�����ϲ���������ݺ��ұ����ݹ��ɵ������
	 * �������������������������ǵݹ���õĹ��̣��ݹ���ڣ����ݳ���Ϊ2����1���������
	 */
	public static int getRevByBin(int low,int high) {
		if(low==high-1) {
			System.out.print("<"+arr[low]+","+arr[high]+">");
			return arr[low]>arr[high]?1:0;
		}else if(low==high){
			return 0;
		}else {
			return getRevByBin(low,(low+high)/2)+getRevByBin((low+high)/2+1,high)+getMerge(low,(low+high)/2,high);
		}
			
	}
	//ǰ�������ֽ��кϲ�
	private static int getMerge(int low, int mid, int high) {
		int count=0;
		for(int i=low;i<=mid;i++) {
			for(int j=mid+1;j<=high;j++) {
				if(arr[i]>arr[j]) {
					System.out.print("<"+arr[i]+","+arr[j]+">");
					count++;
				}
			}
		}
		return count;
	}

	public static void main(String[] args) {
		RevNums demo=new RevNums();
		//int count=demo.getRevNums();
		int count=demo.getRevByBin(0, arr.length-1);
		System.out.println("�������:"+count);
	}

	
}
