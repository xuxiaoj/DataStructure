package lab1;

public class MyIterImpl implements MyIter {
    
    private int size;
    private int[] values;
    private int i;
    
    MyIterImpl(int[] values, int size) {
        this.values = values;
        this.size = size;
    }

    public int next() {
        return values[i++];
    }

    public boolean hasNext() {
        if (size == 0) 
            return false;
        else 
            return i < size || i == 0;
    }
}
