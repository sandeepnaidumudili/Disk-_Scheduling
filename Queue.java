
public class Queue {
	Request head;
	public Queue() {
		head = null;
	}
	public void add(Request n) {
		if(head == null) {
			head = n;
		}
		else {
			head.add(n);
		}
	}
	public void remove() {
		if(head != null)
		head = head.next;
	}
	public void remove(Request r) {
		if(head.pos == r.pos) {
			this.remove();
		}
		else {
			Request temp=head;
			Request prev=head;;
			while(temp.pos!=r.pos) {
				prev = temp;
				temp = temp.next;
			}
			prev.next = temp.next;
		}
		
	}
	public boolean isempty() {
		if(head == null) {
			return true;
		}
		else {
			return false;
		}
	}
	public Request search(int a) {
		Request temp = this.head;
		while(temp!=null&&temp.pos!=a) {
			temp = temp.next;
		}
		return temp;
	}
	public int max() {
		Request temp = this.head;
		int max = temp.pos;
		while(temp!=null) {
			if (max<temp.pos) {
				max=temp.pos;
			}
			temp=temp.next;
		}
		return max;
	}
	public int min() {
		Request temp = this.head;
		int min = temp.pos;
		while(temp!=null) {
			if (min>temp.pos) {
				min=temp.pos;
			}
			temp=temp.next;
		}
		return min;
	}
}
