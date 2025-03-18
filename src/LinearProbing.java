/**
 * Subclass that extends Hashtable.java and only contains differing hash 
 * table functionality specific to linear probing. 
 * The primary hash function is h1(k) = k mod m.
 *
 * @author Christopher Smith
 */
public class LinearProbing extends Hashtable {

	public LinearProbing(int capacity, double loadFactor) {
		super(capacity, loadFactor);
	}
	
	protected int positiveMod (int dividend, int divisor) {
		int quotient = dividend % divisor;
		if (quotient < 0)
		quotient += divisor;
		return quotient;
	}

	@Override
	public int h(Object key, int probe) {
		return positiveMod(key.hashCode() + probe, capacity); //h1(k) = k mod m
	}
	
}
