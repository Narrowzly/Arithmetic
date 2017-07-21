import java.util.*;


public class TestListIterator {

	public static void main(String[] args) {
		List<String> a = new LinkedList<>();
		a.add("zzw");
		a.add("zly");
		a.add("ygl");
		List<String> b = new LinkedList<>();
		b.add("xw");
		b.add("wxt");
		b.add("tyx");
		ListIterator<String> aIter = a.listIterator();
		Iterator<String> bIter = b.iterator();
		while(aIter.hasNext()) {
			aIter.next();
			aIter.add(bIter.next());
		}
		System.out.println(a);
		
		while(aIter.hasPrevious()) {
			aIter.previous();
			aIter.previous();
			aIter.remove();
		}
		System.out.println(a);
		
		a.removeAll(b);
		System.out.println(a);
	}

}
