package recursion;

public class ReverseSingleLs {
    static class ListNode {
        public int value;
        public ListNode next;
        public ListNode(int value) {
            this.value = value;
        }
    }
 
    //�򵥵Ĵ���������
    public  void createList() {
        ListNode listNode1 = new ListNode(21);
        ListNode listNode2 = new ListNode(22);
        ListNode listNode3 = new ListNode(23);
 
        listNode1.next = listNode2;
        listNode2.next = listNode3;
 
        this.head = listNode1;
    }
    //�����׽�㣨��һ����㣬��ͷ������ֿ���
    public ListNode head;
    public ListNode getLastNode() {
    	ListNode p=head;
    	while(p.next!=null) {
    		p=p.next;
    	}
    	return p;
    }
    public void display(){
    	ListNode p=head;
    	while(p.next!=null) {
    		System.out.print(p.value+" ");
    		p=p.next;
    	}
    	System.out.println(p.value+" ");
    }
    //ԭ������--�ǵݹ鷽ʽ
    public void reverse(){
    	ListNode p=head,q=head,newHead=head;
    	while(p.next.next!=head) {
    		while(p.next!=null&&p.next.next!=p) {
        		q=p;p=p.next;
        	}
        	if(p.next==null) newHead=p;
    		p.next=q;
        	p=head;
    	}
    	p.next=null;
    	head=newHead;
    }
  //ԭ������--�ݹ鷽ʽ
    public void reverseByRe(){
    	ListNode p=head,q=head;
    	if(p.next.next==head)
    		p.next=null;
    	else {
    		while(p.next!=null&&p.next.next!=p) {
        		q=p;p=p.next;
        	}
    		p.next=q;
    		reverseByRe();
    	}
    }
    public static void main(String[] args) {
    	ReverseSingleLs ls=new ReverseSingleLs();
    	ls.createList();
    	ls.display();
    	//ls.reverse();
    	ListNode last=ls.getLastNode();
    	ls.reverseByRe();
    	ls.head=last;
    	ls.display();
    }
}