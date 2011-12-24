package lab1;

public interface MySet {
	public void add(int v);
	public boolean remove(int v);
	public void clear();
	public boolean isEmpty();
	public boolean contains(int v);
	public MyIter iterator();
}
