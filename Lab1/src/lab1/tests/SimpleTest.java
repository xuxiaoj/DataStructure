package lab1.tests;

import java.util.HashSet;
import java.util.Set;

import lab1.Employee;
import lab1.MyIter;
import lab1.MyMap;
import lab1.MyMapCheatImpl;
import lab1.MyMapRealImpl;
import lab1.MySet;

public class SimpleTest {
	public static void main(String[] args) {
		String exp = doIt(true);
		String act = null;
		try {
			act = doIt(false);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		if (verifyT1(exp, act)) {
			System.err.println("PASS");
		} else {
			System.err.println("FAIL");
			
			System.out.println("~~~ Expected ~~~");
			System.out.println(exp);
			System.out.println("~~~ Actual ~~~");
			System.out.println(act);
		}
	}
	
//	private static boolean verifyT1(String exp, String act) {
//		return exp.equals(act);
//	}
  	private static boolean verifyT1(String exp, String act) {
  		String[] exps = exp.split("\\n");
  		String[] acts = act.split("\\n");
  		Set<String> s1 = new HashSet<String>();
  		Set<String> s2 = new HashSet<String>();
  		for (String s : exps) {
 // 			System.out.println("[exp] " + s);
  			s1.add(s);
  		}
  		for (String s : acts) {
//  			System.out.println("[act] " + s);
  			s2.add(s);
  		}
  		
  		return s1.containsAll(s2);
  	}

	public static String doIt(boolean isDemo) {
		Employee.reset();
		Employee[] emps = {
			Employee.newInstance("Jack", 21),
			Employee.newInstance("Mary", 19),
			Employee.newInstance("Lucy", 22),
			Employee.newInstance("Tommy", 17),
			Employee.newInstance("Maria", 19),
			Employee.newInstance("Liz", 20),
		};
		
		MyMap m1 = (isDemo ? new MyMapCheatImpl() : new MyMapRealImpl());
		for (Employee e : emps) {
			m1.bind(e.getId(), e);
		}
		
		MySet keySet = m1.keySet();
		MyIter iter = keySet.iterator();
		StringBuffer sb = new StringBuffer();
		while (iter.hasNext()) {
			int id = iter.next();			
			Employee e = (Employee) m1.lookup(id);
			sb.append(e.toString() + "\n");
		}
		
		return sb.toString();
	}
}
