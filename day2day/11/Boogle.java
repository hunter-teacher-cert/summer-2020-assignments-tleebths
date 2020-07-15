/**
classwork -- Day 11 | 0b1011 | 0x0b

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

    //##################################################
    //##################################################

    // find and return the index of the smallest value in the
    // ArrayList al from index lo to index hi inclusive
    public static int findSmallest(ArrayList<Integer> al, int lo, int hi) {
        if (al==null || lo<0 || lo>hi || hi>=al.size())
            return -1;

        // assume the first item is the smallest - call it our smallest so far
        int minIndex = lo;
        Integer minValue = al.get(lo);
        Integer item;

        // loop over all the items
        for (int i = lo+1; i <= hi; i++) {
            item = al.get(i);

            //   if the current item is smaller than the smalleest so far,
            //      then the current item becomes the new smallest so far
            if (item < minValue) {
                minValue = item;
                minIndex = i;
            }

        }  // end for loop

        // change this to return the correct answer
        return minIndex;
    }

    /* Swaps values at the two given indices
     */
    private static void swap(ArrayList<Integer> al, int i1, int i2) {
        Integer temp = al.get(i1);
        al.set(i1, al.get(i2));
        al.set(i2, temp);
    }

    /* Returns the ArrayList in sorted form using selection sort
     * Strategy: Calls helper function on whole list
     */
    public static void selectionSort(ArrayList al) {
        if (al==null)
            return;

        selectionSortHelper(al, 0, al.size()-1);
    }  // end selectionSort()

    /* Recursively performs selection sort on given range of given list
     * Strategy: Find index of minValue to the end of the list
     * Swap values at current and minValue indices
     * Sort the rest of the list
     */
     public static void selectionSortHelper(ArrayList al, int lo, int hi) {
        if (al==null || al.size() < 2 || lo<0 || lo>hi || hi>=al.size())
            return;

        int i = lo;  // index of "first" element
        int j = findSmallest(al, lo, hi);  // index of min.

        if (i != j) {
            swap(al, i, j);
        }

        selectionSortHelper(al, lo+1, hi);

     }  // end selectionSortHelper()

     /* Recursively performs selection sort on given range of given list
      * Strategy:
      *
      */
      public static void selectionSortIter(ArrayList al) {
         if (al==null || al.size() < 2)
             return;

        int hi = al.size() - 1;

         // Iterate through all indices from 0 to hi-1
         // Find index of minValue to the end of the list
         // Swap values at current and minValue indices
         for(int i=0; i<=hi; i++) {
             int j = findSmallest(al, i, hi);  // index of min.

             if (i != j)
                 swap(al, i, j);
         }  // end for loop

      }  // end selectionSortHelper()

    //##################################################
    //##################################################


    public static void main( String[] args )
    {
        int smallIndex;
        System.out.println("Testing findSmallest");
        ArrayList<Integer>  slist = prestoArrayListo(20,0,200);
        int len = slist.size() - 1;
        smallIndex = findSmallest(slist, 0, len);
        System.out.println(slist);
        System.out.printf("Smallest is at slist[%d] and is %d\n",smallIndex,slist.get(smallIndex));
        // swap(slist, 2, 3);
        // System.out.println(slist);
        selectionSort(slist);
        System.out.println(slist);
        slist = prestoArrayListo(20,0,200);
        selectionSortIter(slist);
        System.out.println(slist);

        // smallIndex = findSmallest(slist, len, len);
        // System.out.printf("Smallest is at slist[%d] and is %d\n",smallIndex,slist.get(smallIndex));

        /*~~~~v~~~~~~move~me~down~~~1~block~at~a~time~~~~~~~~~~v~~~~

        ~~~~^~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~^~~~~*/

    }//end main

}//end class
