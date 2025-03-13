/**
 * 
 */

/**
 * 
 */
public class DoubleHashing extends Hashtable {

	public DoubleHashing(int capacity, double loadFactor) {
		super(capacity, loadFactor);
	}
	
	public int h(Object key, int probe) {
		//TODO double probing hash function
		return 0; 
	}
}
