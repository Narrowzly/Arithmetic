import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

import model.Employee;


public class TestTreeSet {
	public static void main(String[] args) {
		Set<Employee> s = new TreeSet<>();
		s.add(new Employee(41,"zly"));
		s.add(new Employee(35,"xw"));
		s.add(new Employee(40,"zzw"));
		System.out.println(s.toArray(new Employee[3])[2]);
		Set<Employee> s1 = new TreeSet<>(new Comparator<Employee>() {
			public int compare(Employee e1, Employee e2) {
				return e1.getId()-e2.getId();
			}
		});
		s.add(new Employee(41,"zly"));
		s.add(new Employee(35,"xw"));
		s.add(new Employee(40,"zzw"));
		System.out.println(s.toArray(new Employee[3])[2]);
	}
}