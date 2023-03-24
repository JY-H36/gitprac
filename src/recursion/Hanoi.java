package recursion;

/**   
*    
* ��Ŀ���ƣ�Algorithm   
* �����ƣ�Hanoi   
* ���������ݹ���n�㺺ŵ������
* �����ˣ�����ɽ   
* ����ʱ�䣺2023��3��23�� ����8:44:05   
* @version        
*/
public class Hanoi {
	
	/*��n�����ӽ���temp�̴�start���ƶ���end��:���԰�n�����ӿ��������֣�����n-1�����������n�����ͽ������Ϊ��������Ϊ2ʱ��ô�ƶ�������
	 *����n����2ʱ���ƶ��������Ƚ������1�ƶ���������temp�ϣ��ٽ�2�Ƶ�Ŀ����end�ϣ����1�Ƶ�Ŀ����end�ϳ������
	 *���ڶ�Ӧ��n�����ӣ������1����������n-1�����ӣ���һ�εݹ����ʱ���յ��̱�Ϊtemp��end������Ϊ�˹����̣�����ô����ֻҪ���n-1�����ӵ��ƶ����⼴��
	 *������n-1�����ӣ��ֿ��Էֽ�������n-2�����Ӻ�������ĵ�n-1������
	 *����������һ���ݹ�Ĺ��̣�ֱ�����ֽ�Ϊ�ƶ�1�����ӵ����⣬����ͽ���ˣ�Ҳ���ǵݹ���ڣ�
	 *ֻ������������������start��������temp��Ŀ����end����Ӧ�ķ����ı���ѣ��������Ϳ��������������
	 */
	public void transAll(int n,String start,String temp,String end) {
		if(n>1) {
			transAll(n-1,start,end,temp);//������n-1�����Ӵ�A���ƶ���B��
			transOne(n,start,end);//��������һ�������ƶ���C��
			transAll(n-1,temp,start,end);//������n-1�����Ӵ�B���ƶ���C��
		}else {
			System.out.println(n+":��"+start+"�Ƶ�"+end);
		}
	}
	
	private void transOne(int n, String start, String end) {
		// TODO Auto-generated method stub
		System.out.println(n+":��"+start+"�Ƶ�"+end);
	}

	public static void main(String[] args) {
		Hanoi demo=new Hanoi();
		int n=3;
		demo.transAll(n, "A", "B", "C");
	}
}
