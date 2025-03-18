/**
 * Subclass that extends Hashtable.java and only contains differing hash 
 * table functionality specific to double hashing.   
 * The primary hash function is h1(k) = k mod m and 
 * the secondary hash function is h2(k) = 1 + (k mod (m − 2)) mod m.
 *
 * @author Christopher Smith
 */
public class DoubleHashing extends Hashtable {

	public DoubleHashing(int capacity, double loadFactor) {
		super(capacity, loadFactor);
	}
	
	protected int positiveMod(int dividend, int divisor) {
		int quotient = dividend % divisor;
		if (quotient < 0)
		quotient += divisor;
		return quotient;
	}
	
	public int h(Object key, int probe) {
		int primaryHash = positiveMod(key.hashCode(), capacity); //h1(k) = k mod m
		int secondaryHash = 1 + positiveMod(key.hashCode(), capacity - 2); //h2(k) = 1 + (k mod (m − 2)) mod m
		return positiveMod(primaryHash + (probe * secondaryHash), capacity);
	}
}
