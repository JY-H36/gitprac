/**
 * 
 */
package violence;

/**
 * 
 * ��Ŀ���ƣ�Algorithm �����ƣ�AssembleCoin ����������1�֣�2�֣�5������Ӳ�ң����n��Ǯ�ж����ֶҷ������г�ÿ�ֶҷ� �����ˣ�����ɽ
 * ����ʱ�䣺2023��3��26�� ����11:22:54
 * 
 * @version
 */
public class AssembleCoin {
	int n;
	int count = 0;

	// ��ȡ���еĶҷ���1��Ӳ�����n����0-n����2��Ӳ�����n/2����0-n/2����5��Ӳ�����n/5����0-n/5����������֮��������������������ֵ������Ϊn����
	public void getAllCoinSets(int n) {
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= n / 2; j++) {
				for (int k = 0; k <= n / 2; k++) {
					if (i + 2 * j + 5 * k == n) {
						count++;
						System.out.println("1��:" + i + "�� 2��:" + j + "�� 5��:" + k + "��");
					}
				}
			}
		}
		System.out.println("�ܹ�" + count + "�ֶҷ�:");
	}

	/* �ݹ�ʵ��
	public static void getCoinsRecur(int n, int coin) {
		if(coin<=n) {
			System.out.println(coin);
			if (n == 1&& coin == 1) {
				return ;
			}else if (n == 2 && coin == 2) {
				return ;
			} else if (n == 5 && coin == 5) {
				return ;
			}else if (n >= 2 && n <5) {
				getCoinsRecur(n-coin, 1);
				getCoinsRecur(n-coin, 2);
			}else {
				getCoinsRecur(n-coin, 1);
				getCoinsRecur(n-coin, 2);
				getCoinsRecur(n-coin, 5);
			}
		}
	}*/

	public static void main(String[] args) {
		AssembleCoin demo = new AssembleCoin();
		demo.n = 10;
		int n = demo.n;
		System.out.println(n + "��Ǯ�Ķҷ�:");
		demo.getAllCoinSets(n);
		/*demo.getCoinsRecur(n,1);
		demo.getCoinsRecur(n,2);
		demo.getCoinsRecur(n,5);*/
		//int count = demo.getCoinsRecur(n);
		//System.out.println("�ܹ�" + count + "�ֶҷ�:");
	}
}
