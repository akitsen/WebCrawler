Note:

The method printFrequencies in the class Utilities pads the frequency count with 15 characters, 
so the item and its frequency appear to be in two seperate columns when printed. If this was formatted differently
than the format used for test cases (i.e. with a tab character "\t" instead of "%-15s%), 
some tests may or may not work. 

Changes to the original skeleton file:

The toString method in Pair.java has been changed to output TwoGrams as specified by the javadoc
for the method computeTwoGramFrequencies in the class TwoGramFrequencyCounter. The "<" and ">"
characters were removed and the two words have a " " added between them. This is to allow
automated text checking for Dr. Patterson (as per Piazza). 

All JUnit tests from the skeleton have been removed. 