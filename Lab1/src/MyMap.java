package lab1;

public interface MyMap {
	/**
	 * Adds the specified key-value mapping to <this>.
	 * If the mapping with the same key already exists,
	 * overrides the existing value.
	 * 
	 * @param key
	 * @param val
	 */
	public void bind(int key, Object val);
	
	/**
	 * Searches for the mapping with the specified key.
	 * If found, returns the associated value; otherwise,
	 * returns null.
	 * 
	 * @param key
	 * @return
	 */
	public Object lookup(int key);
	
	/**
	 * Removes the mapping with the specified key, and
	 * returns the associated value. If no such mapping
	 * exists, returns null.
	 * 
	 * @param key
	 * @return
	 */
	public Object remove(int key);
	
	/**
	 * Returns true if there is no mapping in <this>;
	 * otherwise returns false.
	 */
	public boolean isEmpty();
	
	/**
	 * Returns the set of keys in <this>
	 * 
	 * @return
	 */
	public MySet keySet();
}
