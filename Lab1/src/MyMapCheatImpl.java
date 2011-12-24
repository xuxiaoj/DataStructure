package lab1;

import java.util.HashMap;
import java.util.Set;

public class MyMapCheatImpl implements MyMap {
	
	private HashMap<Integer, Object> map = new HashMap<Integer, Object>();

	@Override
	public void bind(int key, Object val) {
		map.put(key, val);		
	}

	@Override
	public boolean isEmpty() {
		return map.isEmpty();
	}

	@Override
	public MySet keySet() {
		MySet set = new MySetCheatImpl();
		for (int i : map.keySet()) {
			set.add(i);
		}
		
		return set;
	}

	@Override
	public Object lookup(int key) {
		return map.get(key);
	}

	@Override
	public Object remove(int key) {
		return map.remove(key);
	}

}
