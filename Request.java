
public class Request {
	int pos;
	int i;
	static int k=0;
	Request next;
	public Request(int x) {
		this.pos = x;
		this.i = Request.k;
		k++;
		next = null;
	}
	public Request(int x,int y) {
		this.pos=x;
		this.i=y;
		next=null;
	}
	public void add(Request n) {
		if(next == null) {
			next = n;
		}
		else {
			next.add(n);
		}
	}
	public int seeklength(Disc d) {
		int st = d.hp - this.pos;
		if(st<0) {
			st = st*(-1);
		}
		return st;
	}

}
