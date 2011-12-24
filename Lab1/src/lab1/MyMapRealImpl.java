package lab1;

/**
 * See @link{MyMap} for specs.
 * 
 *
 */
public class MyMapRealImpl implements MyMap {
	private int[] keys;
	private Object[] values;
    private int index = 0;

    public MyMapRealImpl() {
        keys = new int[100];
        values = new Object[100];
    }

	public void bind(int key, Object val) {
        keys[index] = key;
        values[index] = val;
        index++;
	}

	public boolean isEmpty() {
        if (index == 0) return true;
		return false;
	}

	public MySet keySet() {
        MySet set = new MySetRealImpl();
        for (int i=0; i<index; i++) {
            set.add(keys[i]);
        }
		return set;
	}

	public Object lookup(int key) {
        for (int i=0; i<index; i++)
            if (keys[i] == key) {
                return values[i];
            }
		return null;
	}

	public Object remove(int key) {
        Object tmp = values[key];
        for (int i=0; i<index; i++) {
            if (keys[i] == key) {
                for (int j=i; j<index-1; j++){
                    keys[j] = keys[j+1];
                    values[j] = values[j+1];
                }
                index--;
                return tmp;
            }
        }
		return null;
	}
}
