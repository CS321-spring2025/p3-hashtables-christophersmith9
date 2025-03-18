import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * 
 */
public abstract class Hashtable {

		protected int capacity;
		protected double loadFactor;
		protected int duplicateCount;
		protected int totalProbes;
		protected int elementCount;
		protected int insertCount;
		protected int maxLoadFactor;
		protected HashObject[] hashTable;

		
		public Hashtable(int capacity, double loadFactor) {
			this.capacity = capacity;
			this.loadFactor = loadFactor;
			this.duplicateCount = 0;
			this.totalProbes = 0;
			this.elementCount = 0;
			this.insertCount = 0;
			this.hashTable = new HashObject[capacity];
			this.maxLoadFactor = (int) Math.ceil(capacity * loadFactor);
		}
		
		public abstract int h(Object key, int probe); //Abstract method overridden in LinearProbing and DoubleHashing
		
		
		public void insert(HashObject obj, int debugLevel) {
			int probe = 0;
			insertCount++;
			
			while (true) {
	            probe = h(obj.getKey(), obj.getProbeCount());
	            obj.incrementProbeCount();
	            
	            totalProbes++;
	            if (hashTable[probe] == null) {
	            	hashTable[probe] = obj;
	            	elementCount++;
	            	if (debugLevel == 2) {
	                    System.out.println("Inserted: " + obj.toString() + " at index " + probe);
	                }
	            	break;
	            } else if (hashTable[probe].equals(obj)) { // If object in table
	            	hashTable[probe].incrementFrequencyCount();
	            	duplicateCount++;
	            	if (debugLevel == 2) {
	                    System.out.println("Duplicate: " + obj.toString() + " at index " + probe);
	                }
	            	break;
				}
			}
		}
		
		public HashObject search(HashObject obj) {
			int i = h(obj.getKey(), 0);
				
			while (i < this.capacity) {
				if (hashTable[i].equals(obj)) {
	                return hashTable[i];
	            }
				i++;
				i = h(obj.getKey(), i);
			}
			
			return null; // If key not found in table
		}
		
		public int getElementCount() {
			return elementCount;
		}
		
		public int getDuplicateCount() {
	        return duplicateCount;
	    }
		
		public int getInsertCount() {
	        return insertCount;
	    }
		
		public double getAvgProbes() {
			return (double) totalProbes / insertCount; 
		}
		
		public int getMaxLoadFactor() {
			return maxLoadFactor;
		}
		
		public void dumpToFile(String fileName) {
		     PrintWriter out = null;
			try {
				out = new PrintWriter(fileName);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		     // loop through the hash table, and print non-null entries
		     // using toString() method in the HashObject class
		     for (int i = 0; i < this.capacity; i++) {
		    	 if (hashTable[i] != null) {
		    		 out.println("table[" + i + "]: " + hashTable[i].toString());
		    	 }
		     }
		     
		     out.close();
		}
}
