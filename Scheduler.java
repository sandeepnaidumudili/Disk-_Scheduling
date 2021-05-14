
public class Scheduler {
	Disc d;
	Queue q;
	int p;
	public Scheduler(Disc d, Queue q) {
		this.d =d;
		this.q =q;
		p=d.hp;
	}
	public void fcfs() {
		Request temp = q.head;
		int i=1;
		int st;
		int sum =0;
		while(temp != null) {
			st = temp.seeklength(this.d);
			System.out.println("request " +temp.i+ "is competed with seek length" +  st);
			sum = sum + st;
			d.hp = temp.pos;
			
			temp = temp.next;
			i++;
		}
		System.out.println("Total seek length of fcfs is " + sum);
		System.out.println("average seek length of fcfs is "+ (float)sum/(i-1));
		d.hp = p;
	}
	public void sstf() {
		int cnt =0;
		int sum=0;
		Queue l = new Queue();
		Request temp = q.head;
		while(temp !=null) {
			l.add(new Request(temp.pos,temp.i));
			temp = temp.next;
		}
		while(!l.isempty()) {
			Request x = l.head;
			Request a = x;
			while(x!=null) {
				if(a.seeklength(d)>x.seeklength(d)) {
					a=x;
				}
				x=x.next;
			}
			System.out.println("request" + a.i + "is completed with seek length " + a.seeklength(d));
			sum=sum+a.seeklength(d);
			cnt++;
			d.hp = a.pos;
			l.remove(a);
		}
		System.out.println("Total seek length of sstf is " + sum);
		System.out.println("average seek length of sstf is "+ (float)sum/cnt);
		d.hp = p;
		
	}
	public void scan() {
		int cnt =0;
		int sum=0;
		Queue l = new Queue();
		Request temp = q.head;
		while(temp !=null) {
			l.add(new Request(temp.pos,temp.i));
			temp = temp.next;
		}
		int i=d.hp;
		while(i<d.size) {
			Request a = l.search(i);
			if(a!=null) {
				System.out.println("request" + a.i + "is completed with seek length " + a.seeklength(d));
				l.remove(a);
				sum=sum+a.seeklength(d);
				cnt++;
				d.hp=i;
				
			}
			i++;
		}
		int sl = d.size-1-d.hp;
		d.hp=d.size-1;
		while(i>=0) {
			Request a = l.search(i);
			
			if(a!=null) {
				sl=sl+a.seeklength(d);
				System.out.println("request" + a.i + "is completed with seek length " + sl);
				l.remove(a);
				sum=sum+sl;
				sl=0;
				cnt++;
				d.hp =i;
				
			}
			i--;
		}
		d.hp=i;
		System.out.println("Total seek length of scan is " + sum);
		System.out.println("average seek length of scan is "+ (float)sum/cnt);
		d.hp = p;
		
	}
	public void cscan() {
		int cnt =0;
		int sum=0;
		Queue l = new Queue();
		Request temp = q.head;
		while(temp !=null) {
			l.add(new Request(temp.pos,temp.i));
			temp = temp.next;
		}
		int i=d.hp;
		while(i<d.size) {
			Request a = l.search(i);
			if(a!=null) {
				System.out.println("request" + a.i + "is completed with seek length " + a.seeklength(d));
				l.remove(a);
				sum=sum+a.seeklength(d);
				cnt++;
				d.hp=i;
				
			}
			i++;
		}
		int sl=d.size-1-d.hp+d.size-1;
		d.hp=0;
		i=0;
		while(i<p) {
			Request a = l.search(i);
			if(a!=null) {
				sl=sl+a.seeklength(d);
				System.out.println("request" + a.i + "is completed with seek length " + sl);
				l.remove(a);
				sum=sum+sl;
				sl=0;
				cnt++;
				d.hp =i;
				
			}
			i++ ;
		}
		d.hp=i;
		System.out.println("Total seek length of cscan is " + sum);
		System.out.println("average seek length of cscan is "+ (float)sum/cnt);
		d.hp = p;
	}
	public void look() {
		int cnt =0;
		int sum=0;
		Queue l = new Queue();
		Request temp = q.head;
		while(temp !=null) {
			l.add(new Request(temp.pos,temp.i));
			temp = temp.next;
		}
		int max = l.max();
		int min = l.min();
		int i=d.hp;
		while(i<=max) {
			Request a = l.search(i);
			if(a!=null) {
				System.out.println("request" + a.i + "is completed with seek length " + a.seeklength(d));
				l.remove(a);
				sum=sum+a.seeklength(d);
				cnt++;
				d.hp=i;
				
			}
			i++;
		}
		d.hp=max;
		i=max;
		while(i>=min) {
			Request a = l.search(i);
			if(a!=null) {
				System.out.println("request" + a.i + "is completed with seek length " + a.seeklength(d));
				l.remove(a);
				sum=sum+a.seeklength(d);
				cnt++;
				d.hp =i;
				
			}
			i--;
		}
		d.hp=min;
		System.out.println("Total seek length of look is " + sum);
		System.out.println("average seek length of look is "+ (float)sum/cnt);
		d.hp = p;
	}
	public void clook() {
		int cnt =0;
		int sum=0;
		Queue l = new Queue();
		Request temp = q.head;
		while(temp !=null) {
			l.add(new Request(temp.pos,temp.i));
			temp = temp.next;
		}
		int i=d.hp;
		while(i<d.size) {
			Request a = l.search(i);
			if(a!=null) {
				System.out.println("request" + a.i + "is completed with seek length " + a.seeklength(d));
				l.remove(a);
				sum=sum+a.seeklength(d);
				cnt++;
				d.hp=i;
				
			}
			i++;
		}
		i=0;
		while(i<p) {
			Request a = l.search(i);
			if(a!=null) {
				System.out.println("request" + a.i + "is completed with seek length " + a.seeklength(d));
				l.remove(a);
				sum=sum+a.seeklength(d);
				cnt++;
				d.hp =i;
				
			}
			i++ ;
		}
		d.hp=i;
		System.out.println("Total seek length of clook is " + sum);
		System.out.println("average seek length of clook is "+ (float)sum/cnt);
		d.hp = p;
	}
}
