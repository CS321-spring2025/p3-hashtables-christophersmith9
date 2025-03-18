/**
 * Contains a generic key object (declared as Object key), 
 * frequency count (to count duplicates), and probe count.  
 * Overrides both the equals and the toString methods 
 * Also have a getKey method that returns an Object type.
 * Equals method compares the key values using the equals method on the keys.
 * 
 * @author Christopher Smith
 */
public class HashObject {
	
	private Object key;
	private int probeCount;
	private int frequencyCount;

	public HashObject(Object key) {
		this.key = key;
		this.probeCount = 0;
		this.frequencyCount = 1;
	}
	
	@Override
	public boolean equals(Object key) {
		if (key instanceof HashObject) {
            HashObject obj = (HashObject) key;
            return obj.getKey().equals(this.key);
		} else {
			return false;
		}
	}
	
	@Override
	public String toString() {
		return getKey() + " " + frequencyCount + " " + probeCount;
	}
	
	public Object getKey() {
		return key;
	}
	
	public int getProbeCount() {
		return probeCount;
	}
	
	public void incrementProbeCount() {
		probeCount++;
	}
	
	public int getFrequencyCount() {
		return frequencyCount;
	}
	
	public void incrementFrequencyCount() {
		frequencyCount++;
	}
}
