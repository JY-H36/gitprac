/**
 * 
 */
package violence;

/**   
*    
* ��Ŀ���ƣ�Algorithm   
* �����ƣ�StringMatch   
* ���������ֱ���BF,BM,KMPʵ���ַ�ƥ��   
* �����ˣ�����ɽ   
* ����ʱ�䣺2023��3��26�� ����11:46:04   
* @version        
*/
public class StringMatch {
	
	/*
	 * BF�㷨����������ָ��i��j�ֱ����������ģʽ����i����㿪ʼ��j��0��ʼ
	 * ƥ��ʱ����ָ��ͬʱ���ƣ���ƥ�䣬iָ����ݵ�����һλ��j����Ϊ0
	 * ֱ��j�Ѿ�������ģʽ��������λ��λ��Ϊi��return i
	 * ����i����������ָ�����ȣ�˵��û���ҵ�ģʽ��������-1
	 */
	public int BF(String main,String mode,int start) {
		if(main!=null&&mode!=null&&mode.length()>0&&main.length()>=mode.length()) {
			int i=start,j=0;
			while(i<main.length()&&j<mode.length()){
					if(main.charAt(i)==mode.charAt(j)) {
						i++;
						j++;
					}else {
						i=++start;
						j=0;
					}
			}
			if(j==mode.length()) {
				int index=i-mode.length();
				//System.out.println("BF:"+mode+"��"+main+"��һ�γ���λ��:"+index);
				return index;
			}
			return -1;
		}
		
		return -1;
	}
	
	/*
	 * KMP�㷨�Ĺؼ�������ģʽ��ÿ���ַ���next����
	 * �����������ģʽ����ƥ��Ļ���ģʽ��Ӧ�û��ݵ�ʲôλ��
	 * ����˼�룺next[n]ֵΪnǰ����ظ�ǰ��׺�Ӵ�����+1
	 * next[0]&next[1]��֪��ʹ������������nextֵ��Ϊ�˷��㣬��next[0]��Ϊ-1
	 * ��next[2]��ʼ�����str[1]==str[next[1]]��str[n-1]==str[next[n-1]]
	 * next[2]=next[1]+1��next[n]==next[n-1]+1
	 * ��k==0����˵���Ѿ�û���ظ���ǰ��׺�Ӵ�,next[n]=0
	 * ��k!=0��˵�������ظ���ǰ��׺�Ӵ�������Ѱ������ظ�ǰ��׺�Ӵ�
	 * 
	 * ����ؼ���һ��Ҫע�����:��k�û�Ϊnext[k]!!!
	 * 
	 * �����Ƚ�str[n-1]��str[k]
	 */
	public int[] getNext(String mode) {
		int[] next=new int[mode.length()];
		next[0]=-1;
		next[1]=0;
		int j=1;//str[1]
		int k=0;//str[next[1]]
		//����j��k����ָ������next[2]��next[mode.len]
		while(j<mode.length()-1) {
			if(mode.charAt(j)==mode.charAt(k)) {
				next[j+1]=next[j]+1;
				j++;
				k++;
			}else if(k==0) {//ƥ��ʧ��
				next[j+1]=0;
				j++;
			}else {
				k=next[k];
			}
		}
		return next;
	}
	
	/*
	 * ����i��j����ָ�����������ģʽ��������������ƥ��������
	 * iָ�벻����jָ��ֻ���ݵ�next[j]Ҳ����next[j]ǰ���Ѿ�ƥ�����
	 * �����˻��ݣ�ʱ�临�Ӷ�O(m+n)
	 */
	public int KMP(String main,String mode,int start) {
		if(main!=null&&mode!=null&&mode.length()>0&&main.length()>=mode.length()) {
			
			int[] next=getNext(mode);
			int i=start;
			int j=0;
			while(i<main.length()&&j<mode.length()){
				if(j==-1||main.charAt(i)==mode.charAt(j)) {
					i++;
					j++;
				}else {
					j=next[j];
				}
			}
			if(j==mode.length()) {
				int index=i-mode.length();
				//System.out.println("BF:"+mode+"��"+main+"��һ�γ���λ��:"+index);
				return index;
			}
			return -1;
		}
		
		return -1;
	}
	public static void main(String[] args) {
		StringMatch demo=new StringMatch();
		String main="abaabab";
		String mode="aab";
		//int index=demo.BF(main, mode, 0);
		int index=demo.KMP(main, mode, 0);
		System.out.println(mode+"��"+main+"��һ�γ���λ��:"+index);
	}
}
