/**
 * 
 */
package violence;

/**
 * 
 * 项目名称：Algorithm 类名称：AssembleCoin 类描述：有1分，2分，5分三种硬币，求解n分钱有多少种兑法，并列出每种兑法 创建人：万重山
 * 创建时间：2023年3月26日 上午11:22:54
 * 
 * @version
 */
public class AssembleCoin {
	int n;
	int count = 0;

	// 获取所有的兑法：1分硬币最多n个（0-n），2分硬币最多n/2个（0-n/2），5分硬币最多n/5个（0-n/5），将他们之间所有情况组合起来，价值加起来为n即可
	public void getAllCoinSets(int n) {
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= n / 2; j++) {
				for (int k = 0; k <= n / 2; k++) {
					if (i + 2 * j + 5 * k == n) {
						count++;
						System.out.println("1分:" + i + "个 2分:" + j + "个 5分:" + k + "个");
					}
				}
			}
		}
		System.out.println("总共" + count + "种兑法:");
	}

	/* 递归实现
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
		System.out.println(n + "分钱的兑法:");
		demo.getAllCoinSets(n);
		/*demo.getCoinsRecur(n,1);
		demo.getCoinsRecur(n,2);
		demo.getCoinsRecur(n,5);*/
		//int count = demo.getCoinsRecur(n);
		//System.out.println("总共" + count + "种兑法:");
	}
}
