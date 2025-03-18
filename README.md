# Project 3: Experiments with Hashing

* Author: Christopher Smith
* Class: CS321 Section #002
* Semester: Sp25

## Overview

This project is to implement a Hashtable class with open addressing and study how the load factor 
affects the average number of probes required for linear probing versus double hashing for various 
types of inputs. It inserts n HashObject objects into a specific hash table of size m until we get a 
load factor α defined as n/m.

## Reflection

I liked this project overall. Since we didn't have any templates or pre-made interfaces, figuring out 
all the little stuff and what methods I would need based on pseudo code from the book and lectures was challenging but fun. 
I'm still quite new to Java and Eclipse.  I had to thoroughly read through the project instructions multiple times and look a lot of stuff up, 
but I feel like I now have an understanding of hash tables that I'll never lose.

As for the result of the project itself, I feel that I could've done better.  Figuring out how to do insert
was probably what I spent the most time on, and I still didn't get it to perfectly match the results, but it did give me 
expected average number of probe results for Random-Numbers and Word-List where double hashing does better on the curve as the loadfactor
increases.

## Compiling and Using

Run this program by compiling all of the .java files and then running HashtableExperiment. 

Usage: java HashtableExperiment <dataSource> <loadFactor> [<debugLevel>]
      <dataSource>: 1 ==> random numbers
      
                    2 ==> date value as a long
                    
                    3 ==> word list
                    
      <loadFactor>: The ratio of objects to table size, 
      
                      denoted by alpha = n/m
                      
      <debugLevel>: 0 ==> print summary of experiment
      
                    1 ==> save the two hash tables to a file at the end
                    
                    2 ==> print debugging output for each insert

## Results 

It is as expected that Double hashing performs less probes on average for higher load factors.
Here are the results for each of the three types of data all at load factor 0.95.

Random Numbers:
```
HashtableExperiment: Found a twin prime table capacity: 95791
HashtableExperiment: Input: Random-Numbers   Loadfactor: 0.95

        Using Linear Probing
HashtableExperiment: size of hash table is 91002
        Inserted 91002 elements, of which 0 were duplicates
        Avg. no. of probes = 9.85

        Using Double Hashing
HashtableExperiment: size of hash table is 91002
        Inserted 91002 elements, of which 0 were duplicates
        Avg. no. of probes = 3.16
```

Data Value as a Long:
```
HashtableExperiment: Found a twin prime table capacity: 95791
HashtableExperiment: Input: Date-Value-as-a-Long   Loadfactor: 0.95

        Using Linear Probing
HashtableExperiment: size of hash table is 91002
        Inserted 91002 elements, of which 0 were duplicates
        Avg. no. of probes = 2.70

        Using Double Hashing
HashtableExperiment: size of hash table is 91002
        Inserted 91002 elements, of which 0 were duplicates
        Avg. no. of probes = 3.44
```

Word List:
```
HashtableExperiment: Found a twin prime table capacity: 95791
HashtableExperiment: Input: Word-List   Loadfactor: 0.95

        Using Linear Probing
HashtableExperiment: size of hash table is 91002
        Inserted 3013622 elements, of which 2922620 were duplicates
        Avg. no. of probes = 5.28

        Using Double Hashing
HashtableExperiment: size of hash table is 91002
        Inserted 3013622 elements, of which 2922620 were duplicates
        Avg. no. of probes = 1.19
```

## Sources used

www.w3schools.com

www.geeksforgeeks.org

www.stackoverflow.com

www.coderanch.com

Google AI Overview

----------

## Notes

Latedays used: 1

