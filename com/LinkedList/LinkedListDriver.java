package com.LinkedList;
class Node{
	int ele;
	Node next;
	Node(int ele){
		this.ele=ele;
		this.next=null;
	}
	public Node() {
		
	}
	int count =0;
	Node head;
	public void addfirst(int ele) {
	    Node n = new Node(ele);
	    if (head == null) {
	        head = n;
	    } else {
	        n.next = head;
	        head = n;
	    }
	    count++;
	}
	public void display()
	{
		Node temp=head;
		while(temp!=null)
		{
			System.out.print(temp.ele+" -> ");
			temp=temp.next;
		}
		
		System.out.println("Null");
		
	}
	public void addlast(int ele) {
		Node n=new Node(ele);
		if(head==null) {
			head=n;
		}
		else {
			Node temp=head;
			while(temp.next!=null)
			{
				temp=temp.next;
			}
			temp.next=n;
			
		}
		count++;
	}
	public void removefirst()
	{
	if(head==null)
		return;
	else {
		head=head.next;
	}
	count--;
}
	public void removelast()
	{
		if(head==null)
			return;
		else {
			Node temp=head;
			while(temp.next.next!=null)
			{
				temp=temp.next;
			}
			temp.next=null;
			
		}
		count--;
	}
	public int size()
	{
		return count;
	}
		public void addatindex(int ele, int index) {
	    if (index < 0 || index > count) {
	        throw new IndexOutOfBoundsException();
	    }
	    Node n = new Node(ele);   
	    if (index == 0) {
	        n.next = head;
	        head = n;
	    } else {
	        Node temp = head;
	        for (int i = 0; i < index - 1; i++) {
	            temp = temp.next;
	        }
	        n.next = temp.next;
	        temp.next = n;
	    }
	    count++; 
	}
		public void removeindex(int index)
		{
			if (index < 0 || index >=count) {
		        throw new IndexOutOfBoundsException();
		    }
			if(index==0)
			{
				head=head.next;
			}
			else {
				Node temp=head;
				for(int i=0;i<index-1;i++)
				{
					temp=temp.next;
				}
				temp.next=temp.next.next;
			}
			count--;
		}
		public Object getindexvalue(int index)
		{
			if(index<0 || index>=count) throw new IndexOutOfBoundsException();
			else {
				Node temp=head;
				for(int i=0;i<index;i++)
				{
					temp=temp.next;
				}
				return temp.ele;
			}
		}
		public void reverse()
		{
			Node current=head;
			Node previous=null;
			Node next=null;
			while(current!=null)
			{
				next=current.next;
				current.next=previous;
				previous=current;
				current=next;
			}
			head=previous;
	
				
		}
		public void reversebetween(int m,int n)
		{
			if(m<0|| n>=count || m>n) throw new IndexOutOfBoundsException();
			Node dummy=new Node(0);
			dummy.next=head;
			Node prev=dummy;
			dummy.next=head;
			for(int i=0;i<m;i++)
			{
				prev=prev.next;		
			}
			Node next=null;
			Node current=prev.next;
			Node tail=current;
			Node previous=null;
			for(int i=m;i<=n;i++)
			{
				next=current.next;
				current.next=previous;
				previous=current;
				current=next;
			}
			prev.next=previous;
			tail.next=current;
			if(m==0)
			{
				head=previous;
			}
		}
}


public class LinkedListDriver {

	public static void main(String[] args) {
		Node l=new Node();
	    l.addlast(10);
	    l.addlast(20);
	    l.addlast(30);
	    l.addlast(40);
	    l.addlast(50);
	    l.addlast(60);
	    l.addlast(70);
		l.display();
		l.reversebetween(0,l.size()-1);
		l.reversebetween(0,0);
		l.reversebetween(1,l.size()-1);
		l.display();
		//System.out.println(l.size());
		

	}

}