package Modul10CollectionSortingAndSearching;
//B. SEARCHING
// Java Program to Demonstrate Working of binarySearch()
// method of Collections class
// Importing required classes
// import java.util.ArrayList;
// import java.util.Collections;
// import java.util.List;
// // Main class
// public class MapExample{
// // Main driver method
// public static void main(String[] args){
// // Creating an empty ArrayList of integer type
// List<Integer> al = new ArrayList<Integer>();
// // Populating the Arraylist
// al.add(1);
// al.add(2);
// al.add(3);
// al.add(10);
// al.add(20);
// // 10 is present at index 3
// int key = 10;
// int res = Collections.binarySearch(al, key);
// if (res >= 0)
// System.out.println(key + " found at index = " + res);
// else
// System.out.println(key + " Not found");
// key = 15;
// res = Collections.binarySearch(al, key);
// if (res >= 0)
// System.out.println(
// key + " found at index = " + res);

// else
// System.out.println(key + " Not found");
// }
// }
// Program BinarySearchTest.java
// Collections method binarySearch.
import java.util.List;
import java.util.Arrays;
import java.util.Collections;
import java.util.ArrayList;
public class BinarySearchTest{
public static void main( String[] args )
{
// create an ArrayList< String > from the contents of colors array
String[] colors = { "red", "white", "blue", "black", "yellow",
"purple", "tan", "pink" };
List< String > list =
new ArrayList< String >( Arrays.asList( colors ) );
Collections.sort( list ); // sort the ArrayList
System.out.printf( "Sorted ArrayList: %s\n", list );
// search list for various values
printSearchResults( list, colors[ 3 ] ); // first item
printSearchResults( list, colors[ 0 ] ); // middle item
printSearchResults( list, colors[ 7 ] ); // last item
printSearchResults( list, "aqua" ); // below lowest
printSearchResults( list, "gray" ); // does not exist
printSearchResults( list, "teal" ); // does not exist
} // end main
// perform search and display result
private static void printSearchResults(
List< String > list, String key )
{
int result = 0;
System.out.printf( "\nSearching for: %s\n", key );
result = Collections.binarySearch( list, key );
if(result>=0)
System.out.printf( "Found at index %d\n", result );
else
System.out.printf( "Not Found (%d)\n",result );

} // end method printSearchResults
} // end class BinarySearchTest