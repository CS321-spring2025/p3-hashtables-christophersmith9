/**
 * 
 */

/**
 * 
 */
public class LinearProbing extends Hashtable {

	public LinearProbing(int capacity, double loadFactor) {
		super(capacity, loadFactor);
	}

	public int h(Object key, int probe) {
		key = k % m;
		
		return key;
	}
}
