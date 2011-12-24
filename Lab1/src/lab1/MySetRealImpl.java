package lab1;

public class MySetRealImpl implements MySet {
	private int[] values;
    private int index;

    public MySetRealImpl() {
        values = new int[100];
        index = 0;
    }

	public void add(int v) {
        for (int i=0; i<index; i++)
            if (values[i] == v) return; 
        values[index] = v;
        index++;
	}

	public void clear() {
        index = 0;
	}

	public boolean contains(int v) {
        for (int i=0; i<index; i++)
            if (values[i] == v) return true;
		return false;
	}

	public boolean isEmpty() {
		return index==0;      // old version: if (index == 0) return true;
                              //else return false;
	}

	public MyIter iterator() {
        return new MyIterImpl(values,index);
	}

	public boolean remove(int v) {
        for (int i=0; i<index; i++)
            if (values[i] == v) {
                for (int j=i; j<index-1; j++) {
                    values[j] = values[j+1];
                }
                index--;
                return true;
            }
		return false;
	}

}
