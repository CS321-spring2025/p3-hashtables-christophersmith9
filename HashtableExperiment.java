import java.text.DecimalFormat;
import java.util.Random;
import java.util.Date;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Hashtable driver program
 * 
 * Usage: java HashtableExperiment <dataSource> <loadFactor> [<debugLevel>]
 *     <dataSource>: 1 ==> random numbers
 *                   2 ==> date value as a long
 *                   3 ==> word list
 *     <loadFactor>: The ratio of objects to table size, 
 *                     denoted by alpha = n/m
 *     <debugLevel>: 0 ==> print summary of experiment
 *                   1 ==> save the two hash tables to a file at the end
 *                   2 ==> print debugging output for each insert
 * 
 * @author Christopher Smith
 */
public class HashtableExperiment {


	public static void main(String[] args) {
		
		// Parse command line arguments
		if (args.length < 2 || args.length > 3) {
			printUsage();
			System.exit(1);
		}
		int dataSource = Integer.parseInt(args[0]);
		double loadFactor = Double.parseDouble(args[1]);
		int debugLevel = 0;
		if (args.length == 3) {
			debugLevel = Integer.parseInt(args[2]);
		}
		if (dataSource < 1 || dataSource > 3 || loadFactor <= 0 || loadFactor > 1 || debugLevel < 0 || debugLevel > 2) {
            printUsage();
            System.exit(1);
        }
		
		// Create hash tables
		int tableSize = TwinPrimeGenerator.generateTwinPrime(95500, 96000);
		
		Hashtable linearProbeTable = new LinearProbing(tableSize, loadFactor);
        Hashtable doubleHashingTable = new DoubleHashing(tableSize, loadFactor);
        DecimalFormat df = new DecimalFormat("0.00");
        
        switch (dataSource) {
        case 1:
        	System.out.println("HashtableExperiment: Input: Random-Numbers   Loadfactor: " + df.format(loadFactor));
        	insertRandomNumbers(linearProbeTable, doubleHashingTable, debugLevel);
        	break;
        case 2:
        	System.out.println("HashtableExperiment: Input: Data-Value-as-a-Long   Loadfactor: " + df.format(loadFactor));
        	insertDateValueAsALong(linearProbeTable, doubleHashingTable, debugLevel);
        	break;
        case 3:
        	System.out.println("HashtableExperiment: Input: Word-List   Loadfactor: " + df.format(loadFactor));
        	insertWordList(linearProbeTable, doubleHashingTable, debugLevel);
        	break;
        }
        
        String linearProbing = "Linear Probing";
        String doubleHashing = "Double Hashing";
        String linearDumpFile = "linear-dump.txt";
        String doubleDumpFile = "double-dump.txt";
        		
        switch (debugLevel) {
        	case 0:
        		printResults(linearProbeTable, linearProbing);
        		printResults(doubleHashingTable, doubleHashing);
        		break;
        	case 1:
        		printResults(linearProbeTable, linearProbing);
        		linearProbeTable.dumpToFile(linearDumpFile);
        		System.out.println("HashtableExperiment: Saved dump of hash table");
        		printResults(doubleHashingTable, doubleHashing);
        		doubleHashingTable.dumpToFile(doubleDumpFile);
        		System.out.println("HashtableExperiment: Saved dump of hash table");
        		break;
        	case 2:
        		printResults(linearProbeTable, linearProbing);
        		linearProbeTable.dumpToFile(linearDumpFile);
        		System.out.println("HashtableExperiment: Saved dump of hash table");
        		printResults(doubleHashingTable, doubleHashing);
        		doubleHashingTable.dumpToFile(doubleDumpFile);
        		System.out.println("HashtableExperiment: Saved dump of hash table");
        		break;
        }
	}

	private static void printResults(Hashtable t, String dataSource) {
		DecimalFormat df = new DecimalFormat("#.00");
		
		System.out.println("\n        Using " + dataSource);
		System.out.println("HashtableExperiment: size of hash table is " + t.getElementCount());
		System.out.println("        Inserted " + t.getInsertCount() + 
						   " elements, of which " + t.getDuplicateCount() + " were duplicates");
		System.out.println("        Avg. no. of probes = " + df.format(t.getAvgProbes()));
	}
	
	private static void printUsage() {
		System.err.println("Usage: java HashtableExperiment <dataSource> <loadFactor> [<debugLevel>]");
		System.err.println("<dataSource>: 1 ==> random numbers");
		System.err.println("2 ==> date value as a long");
		System.err.println("3 ==> word list");
		System.err.println("<loadFactor>: The ratio of objects to table size, denoted by alpha = n/m");
		System.err.println("<debugLevel>: 0 ==> print summary of experiment");
		System.err.println("1 ==> save the two hash tables to a file at the end");
		System.err.println("2 ==> print debugging output for each insert");
	}

	private static void insertRandomNumbers(Hashtable linearProbeTable, Hashtable doubleHashingTable, int debugLevel) {
		Random random = new Random();
		int rand = 0;
		while (linearProbeTable.getElementCount() < linearProbeTable.getMaxLoadFactor()) {
			 rand = random.nextInt();
			 linearProbeTable.insert(new HashObject(rand), debugLevel);
			 doubleHashingTable.insert(new HashObject(rand), debugLevel);
		}
	}
	
	private static void insertDateValueAsALong(Hashtable linearProbeTable, Hashtable doubleHashingTable, int debugLevel) {
		long current = new Date().getTime();
		while (linearProbeTable.getElementCount() < linearProbeTable.getMaxLoadFactor()) {
			current += 1000; //increase by 1 second (1000 ms)
			Date date = new Date(current);
			HashObject obj = new HashObject(date);
			linearProbeTable.insert(obj, debugLevel);
			doubleHashingTable.insert(obj, debugLevel);
		}
	}
	
	private static void insertWordList(Hashtable linearProbeTable, Hashtable doubleHashingTable, int debugLevel) {
		String filePath = "word-list.txt";
		
		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null 
            		&& linearProbeTable.getElementCount() < linearProbeTable.getMaxLoadFactor()) {
            	HashObject obj = new HashObject(line);
            	linearProbeTable.insert(obj, debugLevel);
    			doubleHashingTable.insert(obj, debugLevel);
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
	}

}
