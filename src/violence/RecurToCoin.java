/**
 * 
 */
package violence;

/**   
*    
* ��Ŀ���ƣ�Algorithm   
* �����ƣ�RecurToCoin   
* ��������   
* �����ˣ�����ɽ   
* ����ʱ�䣺2023��3��27�� ����3:56:14   
* @version        
*/
public class RecurToCoin {
	public static int makeChange(int n,int denom){
		int next_denom=0;
		switch(denom){
		case 10:
		next_denom=5;
		break;
		case 5:
		next_denom=1;
		break;
		case 1:
		return 1;
		}
		int ways=0;
		for(int i=0;i*denom<=n;i++){
		ways+=makeChange(n-i*denom,next_denom);
		}
		return ways;
		}
		
	
}
