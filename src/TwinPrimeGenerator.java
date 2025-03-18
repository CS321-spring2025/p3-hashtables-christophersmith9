/**  
 * Provides a public static method generateTwinPrime(int min, int max) that generates a value 
 * for the HashTable table size m in the range of [min:max]. A good table size is a 
 * twin prime m that is 2 away from another prime (such that m and m − 2 are primes).  
 * Two primes that differ by two are called “twin primes.”  The method to generate twin primes 
 * should find the smallest set of twin primes both in the given range and then return the 
 * larger of the two. 
 * The HashtableExperiment class will call generateTwinPrime(95500, 96000) to get an appropriate 
 * twin prime for the experiment. (95991, 95993) This allows us to all use the same table size and be able to 
 * compare some of the results.
 * 
 * @author Christopher Smith
 * */

public class TwinPrimeGenerator {

	//Walk through min:max until first twin primes are found and return larger of the two
	public static int generateTwinPrime(int min, int max) {
		int first, second;
		
		for (int i = min; i <= max; i++) {
			first = i;
			second = i + 2;
			if(checkForPrime(first) && checkForPrime(second))
	        {
				System.out.println("HashtableExperiment: Found a twin prime table capacity: " + second); 
	            return second;
	        }
		}
		System.out.println("No prime in range");
		return 0;
	}
	
	// Helper method to check if something is prime
	static boolean checkForPrime(int inputNumber)
	    {
	        boolean isItPrime = true;
	         
	        if(inputNumber <= 1) 
	        {
	            isItPrime = false;
	             
	            return isItPrime;
	        }
	        else
	        {
	            for (int i = 2; i <= inputNumber/2; i++) 
	            {
	                if ((inputNumber % i) == 0)
	                {
	                    isItPrime = false;
	                     
	                    break;
	                }
	            }
	             
	            return isItPrime;
	        }
	    }
	

}
	
