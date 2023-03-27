/**
 * 
 */
package violence;

/**   
*    
* 项目名称：Algorithm   
* 类名称：LowSqrt   
* 类描述：求根号n的下界   
* 创建人：万重山   
* 创建时间：2023年3月26日 下午4:35:43   
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
				System.out.println("根号"+n+"的下界:"+i);
				return ;
			}
		}
	}
}
