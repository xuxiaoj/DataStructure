package lab1;

import java.util.HashSet;
import java.util.Iterator;

public class MySetCheatImpl implements MySet {
	
	private HashSet<Integer> set = new HashSet<Integer>();

	@Override
	public void add(int v) {
		set.add(v);
	}

	@Override
	public void clear() {
		set.clear();
	}

	@Override
	public boolean contains(int v) {
		return set.contains(v);
	}

	@Override
	public boolean isEmpty() {
		return set.isEmpty();
	}

	class MyIterInternal implements MyIter {
		private Iterator<Integer> iter;
		public MyIterInternal(Iterator<Integer> iter) {
			this.iter = iter;
		}

		@Override
		public boolean hasNext() {
			return iter.hasNext();
		}

		@Override
		public int next() {
			return iter.next();
		}
		
	}
	
	@Override
	public MyIter iterator() {
		return new MyIterInternal(set.iterator());
	}

	@Override
	public boolean remove(int v) {
		return set.remove(v);
	}

}
