/**
 * 
 */
package violence;

/**   
*    
* ��Ŀ���ƣ�Algorithm   
* �����ƣ�LowSqrt   
* �������������n���½�   
* �����ˣ�����ɽ   
* ����ʱ�䣺2023��3��26�� ����4:35:43   
* @version        
*/
public class LowSqrt {
	
	public static void main(String[] args) {
		//int[] arr=new int[20];
		for(int i=1;i<=20;i++) {
			getSqrtLow(i);
		}
			
	}

	private static void getSqrtLow(int n) {
		// TODO Auto-generated method stub
		for(int i=1;i<=n;i++) {
			if(i*i<=n&&(i+1)*(i+1)>n) {
				System.out.println("����"+n+"���½�:"+i);
				return ;
			}
		}
	}
}
