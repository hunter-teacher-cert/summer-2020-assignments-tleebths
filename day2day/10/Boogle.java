/**
classwork -- Day 10 | 0b1010 | 0x0a

class: Boogle

A tester class for code analysis and search exploration.

USAGE:
Read through at least once.
Compile, run.
Comment/uncomment lines, recompile, run to explore functionality.
"Lather, rinse, repeat" until comprehension achieved.
Rename methods to indicate purpose.
Insert comment preceding each method to summarize functionality.

T. Mykolyk, F. Dragon
June 2020
**/

import java.io.*;
import java.util.*;

public class Boogle
{

    //return index of first occurence of target, or -1 if not found
    public static int linSearch( ArrayList al, int target )
    {
        for( int pos=0; pos<al.size(); pos++) {
            if (al.get(pos).equals(target))
            return pos;
        }
        return -1;
    }//end linSearch()

    // Returns index of target, or -1 if not found
    // Assumes al is sorted. Uses iterative algo
    public static int binSearch( ArrayList al, int target )
    {
        // Start searching from beginning to end of list
        // Find middle index. When low > high, item not found.
        // Search by comparing middle element to target.
        // If too small, look in upper half of search range.
        // If too big, look in lower half.
        // Readjust search parameters accordingly.

        int low = 0, high = al.size()-1;
        int mid = (low+high)/2;
        int ele;  // value at index mid

        while (low <= high) {
            ele = (int)al.get(mid);

            if (ele < target) {
                low = mid + 1;
            } else if (ele > target) {
                high = mid - 1;
            } else {
                return mid;
            }

            mid = (low+high)/2;
        }

        return -1; //placeholder to get past compiler
    }  //end binSearch()

    // Returns index of target, or -1 if not found
    // Uses recursive algo by calling helper method on whole range of list
    public static int binSearchRec( ArrayList al, int target )
    {
        return binSearchRecHelper(al, target, 0, al.size()-1);
    }

    // Returns index of target, or -1 if not found
    // Searches only within indices low and high, inclusive
    public static int binSearchRecHelper( ArrayList al, int target, int low, int high )
    {
        // System.out.print("\n["+low+", "+high+"]");
        if (low > high)
            return -1;

        int mid = (low+high) / 2;
        int ele = (int)al.get(mid);

        if (ele < target) {
            return binSearchRecHelper(al, target, mid+1, high);
        } else if (ele > target) {
            return binSearchRecHelper(al, target, low, mid-1);
        } else {
            return mid;
        }
    }  //end binSearchRecHelper()



    // subgoal: recognize target found (and take what action?)
    // subgoal: recognize search space exhausted (and take what action?)
    // subgoal: recognize target in lower portion of range (and do what?)
    // subgoal: recognize target in upper portion of range (and do what?)

    //nota bene: A helper method could be very useful.
    // Q: Why?
    // Q: What would the parameters be for such a method?



    //return ArrayList of random ints on range [lo,lo+hi)
    public static ArrayList prestoArrayListo(int numItems, int lo, int hi)
    {
        ArrayList retArr = new ArrayList();

        for(int i=0; i<numItems; i++) {
            //System.out.println(i);  //diagnostic under-the-hood view
            //retArr.add( Math.random() ); // [0,1)
            //retArr.add( (int)Math.random() ); // 0
            //retArr.add( (int)(hi * Math.random()) ); // [0,hi)
            retArr.add( lo + (int)(hi * Math.random()) ); // [lo,lo+hi)
        }
        return retArr;
    }//end prestoArrayListo()


    //return ArrayList of random ints, sorted in ascending order
    public static ArrayList prestoSortedArrayListo(int numItems,
    int lo, int hi)
    {
        ArrayList retArr = new ArrayList();

        //if requested, return empty ArrayList
        if ( numItems<1 )
        return retArr;

        //populate index 0
        retArr.add( (int)(lo * Math.random()) );

        //populate rest of indices, each one greater than last
        for(int i=1; i<numItems; i++) {
            //System.out.println(i);  //diagnostic under-the-hood view
            //retArr.add( Math.random() ); // [0,1)
            //retArr.add( (int)Math.random() ); // 0
            //retArr.add( (int)(hi * Math.random()) ); // [0,hi)
            //retArr.add( lo + (int)(hi * Math.random()) ); // [lo,lo+hi)
            //System.out.println(retArr.get(i-1));
            retArr.add( (int)retArr.get(i-1)
            + lo + (int)(hi * Math.random()) ); // ["left neighbour",hi)
        }

        return retArr;
    }//end prestoSortedArrayListo()


    public static void main( String[] args )
    {
        /*~~~~v~~~~~~move~me~down~~~1~block~at~a~time~~~~~~~~~~v~~~~
        System.out.println("\n"+"al000"+":");
        ArrayList al000 = prestoArrayListo(0,0,0);
        System.out.println(al000);
        System.out.println(linSearch(al000,3));

        System.out.println("\n"+"al01"+":");
        ArrayList al01 = prestoArrayListo(5,0,100);
        System.out.println(al01);
        System.out.println(linSearch(al01,3));

        System.out.println("\n"+"al02"+":");
        ArrayList al02 = prestoArrayListo(5,3,10);
        System.out.println(al02);
        System.out.println(linSearch(al02,3));

        System.out.println("\n"+"al05"+":");
        ArrayList al05 = prestoArrayListo(20,1,5);
        System.out.println(al05);
        System.out.println(linSearch(al05,3));
        ~~~~^~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~^~~~~*/


        // test battery using sorted ArrayLists as search space
        System.out.println("\n"+"sal000"+":");
        ArrayList sal000 = prestoSortedArrayListo(0,0,0);
        System.out.println(sal000);
        System.out.println(linSearch(sal000,3));
        System.out.println(binSearch(sal000,3));
        System.out.println(binSearchRec(sal000,3));

        System.out.println("\n"+"sal00"+":");
        ArrayList sal00 = prestoSortedArrayListo(5,0,100);
        System.out.println(sal00);
        System.out.println(linSearch(sal00,3));
        System.out.println(binSearch(sal00,3));
        System.out.println(binSearchRec(sal00,3));

        System.out.println("\n"+"sal01"+":");
        ArrayList sal01 = prestoSortedArrayListo(5,0,100);
        System.out.println(sal01);
        System.out.println(linSearch(sal01,3));
        System.out.println(binSearch(sal01,3));
        System.out.println(binSearchRec(sal01,3));

        System.out.println("\n"+"sal02"+":");
        ArrayList sal02 = prestoSortedArrayListo(5,3,100);
        System.out.println(sal02);
        System.out.println(linSearch(sal02,3));
        System.out.println(binSearch(sal02,3));
        System.out.println(binSearchRec(sal02,3));

        System.out.println("\n"+"sal03"+":");
        ArrayList sal03 = prestoSortedArrayListo(5,0,100);
        System.out.println(sal03);
        System.out.println(linSearch(sal03,3));
        System.out.println(binSearch(sal03,3));
        System.out.println(binSearchRec(sal03,3));

        System.out.println("\n"+"sal04"+":");
        ArrayList sal04 = prestoSortedArrayListo(20,0,3);
        System.out.println(sal04);
        System.out.println(linSearch(sal04,3));
        System.out.println(binSearch(sal04,3));
        System.out.println(binSearchRec(sal04,3));

        System.out.println("\n"+"sal05"+":");
        ArrayList sal05 = prestoSortedArrayListo(20,1,5);
        System.out.println(sal05);
        System.out.println(linSearch(sal05,3));
        System.out.println(binSearch(sal05,3));
        System.out.println(binSearchRec(sal05,3));

        /*~~~~v~~~~~~move~me~down~~~1~block~at~a~time~~~~~~~~~~v~~~~
        ~~~~^~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~^~~~~*/

        //batch of commands for easier test case generation:
        /*
        System.out.println("\n"+"al"+":");
        ArrayList al = prestoArrayListo(,,);
        System.out.println(al);
        System.out.println(linSearch(al, ));
        System.out.println(binSearch(al, ));
        */
    }//end main

}//end class
