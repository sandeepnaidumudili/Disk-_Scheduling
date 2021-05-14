import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Queue q = new Queue();
		System.out.println("Enter the Tracksize");
		int a = scan.nextInt();
		System.out.println("Enter the Headposition");
		int b= scan.nextInt();
		Disc d = new Disc(a,b);
		System.out.println("Enter the number of requests");
		int n=scan.nextInt();
		System.out.println("Enter the requests");
		for(int i=0;i<n;i++) {
			int p= scan.nextInt();
			q.add(new Request(p));
		}
		Scheduler s = new Scheduler(d,q);
		s.fcfs();
		s.sstf();
		s.scan();
		s.cscan();
		s.look();
		s.clook();
	}
}
