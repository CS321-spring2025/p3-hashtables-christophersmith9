# Project 3: Experiments with Hashing

* Author: Christopher Smith
* Class: CS321 Section #002
* Semester: Sp25

## Overview

This project is to implement a Hashtable class with open addressing and study how the load factor affects the average number of probes required for linear probing versus double hashing for various types of inputs. It inserts n HashObject objects into a specific hash table of size m until we get a load factor α defined as n/m.

## Reflection

Write a two paragraph reflection describing your experience with this 
project.  Talk about what worked well and what was challenging.  
Did you run into an issue that took some time to figure out?  
Tell us about it. What did you enjoy, what was less desirable? Feel
free to add other items (within the two paragraph limit).

## Compiling and Using

This section should tell the user how to compile your code.  It is
also appropriate to instruct the user how to use your code. Does your
program require user input? If so, what does your user need to know
about it to use it as quickly as possible?

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

* This README.md template is using Markdown. Here is some help on using Markdown: 
[markdown cheatsheet](https://github.com/adam-p/markdown-here/wiki/Markdown-Cheatsheet)


* Markdown can be edited and viewed natively in most IDEs such as Eclipse and VS Code. Just toggle
between the Markdown source and preview tabs.

* To preview your README.md output online, you can copy your file contents to a Markdown editor/previewer
such as [https://stackedit.io/editor](https://stackedit.io/editor).
