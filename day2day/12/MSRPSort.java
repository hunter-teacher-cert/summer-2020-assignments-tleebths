/** Sorting algorithms, incl.
 *  Merge sort, Selection sort, Recursive selection sort,
 *  double selection sort, Pivot (quick) sort
 *  by Tsee Lee, July 2020
**/

import java.io.*;
import java.util.*;

public class MSRPSort
{

    //##################################################
    //##################################################

    // run with command line argument specifying length of array list
    public static void main( String[] args )
    {
        int len = 1;
        if (args.length>0)
            len = Integer.parseInt(args[0]);

        ArrayList<Integer> randos = prestoArrayListo(len, 0, 100);

        System.out.println("unsorted : " + randos);

        // long start = System.currentTimeMillis();
        ArrayList<Integer> sorted = quickSort(randos);
        System.out.println("merge    : " + sorted);

        // long start = System.currentTimeMillis();
        sorted = mergeSort(randos);
        System.out.println("merge    : " + sorted);

        // randos = prestoArrayListo(10, 0, 100);
        // selectionSort(randos);
        // System.out.println("selection: " + randos);

        // long elapsed = System.currentTimeMillis() - start;
        // System.out.println("Elapsed time: " + elapsed);


    }  // end main()

    // aka. pivot sort
    public static ArrayList<Integer> quickSort(ArrayList<Integer> al) {
        if (al==null || al.size()==0) {
            return al;
        }

        return quickSort(al, 0, al.size());
    }

    // Helper method, sorts from index lo up to but not incl. hi
    // Assuming >= 1 item in list
    private static ArrayList<Integer> quickSort(ArrayList<Integer> al, int lo, int hi) {
        ArrayList<Integer> sorted = new ArrayList<Integer>();

        // Base case: if 1 item or less in list, it's sorted
        if (lo == hi) {
            return sorted;
        } else if (lo == hi - 1) {
            sorted.add(al.get(lo));
        }

        /* Recursive case: Picks a pivot, then creates 3 new lists
         * List 1: all elements smaller than pivot
         * List 2: all elements equal to pivot
         * List 3: all elements greater than pivot
         * Sort all 3 lists, then concatenates them
         */


        return null;
    }  // end quickSort helper


    //return ArrayList of random ints on range [lo,lo+hi)
    public static ArrayList<Integer> prestoArrayListo(int numItems, int lo, int hi)
    {
        ArrayList<Integer> retArr = new ArrayList<Integer>();

        for(int i=0; i<numItems; i++) {
            //System.out.println(i);  //diagnostic under-the-hood view
            //retArr.add( Math.random() ); // [0,1)
            //retArr.add( (int)Math.random() ); // 0
            //retArr.add( (int)(hi * Math.random()) ); // [0,hi)
            retArr.add( lo + (int)(hi * Math.random()) ); // [lo,lo+hi)
        }
        return retArr;
    }//end prestoArrayListo()


    //##################################################
    //##################################################

    // find and return the index of the smallest value in the
    // ArrayList al from index lo to index hi inclusive
    public static int findSmallest(ArrayList<Integer> al, int lo, int hi) {
        // inefficient to check so much -- solutions?
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
            if (item.compareTo(minValue) < 0) {
                minValue = item;
                minIndex = i;
            }

        }  // end for loop

        // change this to return the correct answer
        return minIndex;
    }

    // Returns [x,y] such that x is the index of the min of al from lo to hi
    // and y is the index of the local max
    private static int[] findLocalMinMax(ArrayList<Integer> al, int lo, int hi) {

        // assume the first item is the smallest - call it our smallest so far
        int minIndex = lo, maxIndex = lo;
        Integer minValue = al.get(lo), maxValue = minValue;

        Integer item;

        // loop over all the items
        for (int i = lo+1; i <= hi; i++) {
            item = al.get(i);

            //   if the current item is smaller than the smalleest so far,
            //      then the current item becomes the new smallest so far
            if (item.compareTo(minValue) < 0) {
                minValue = item;
                minIndex = i;
            } else if (item.compareTo(maxValue) > 0) {
                maxValue = item;
                maxIndex = i;
            }

        }  // end for loop

        // change this to return the correct answer
        return new int[]{minIndex, maxIndex};
    }

    /* Swaps elements at the two given indices
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

        selectionSort(al, 0, al.size()-1);
    }

    /* Recursively performs selection sort on given range of given list
    * Strategy: Find index of minValue to the end of the list
    * Swap values at current and minValue indices if different
    * Sort the rest of the list
    */
    public static void selectionSort(ArrayList al, int lo, int hi) {
        // required even if this method's turned private
        if (al==null || al.size() < 2 || lo<0 || lo>hi || hi>=al.size())
            return;

        int i = lo;  // index of "first" element
        int j = findSmallest(al, lo, hi);  // index of min.

        if (i != j) {
            swap(al, i, j);
        }

        selectionSort(al, lo+1, hi);

    }  // end selectionSort helper

    /* Recursively performs selection sort on given range of given list
    * Strategy: Iterate through all indices from 0 to hi-1
    * Find index of minValue to the end of the list
    * Swap values at current and minValue indices
    */
    public static void selectionSortIter(ArrayList al) {
        if (al==null || al.size() < 2)
        return;

        int hi = al.size() - 1;

        for(int i=0; i<=hi; i++) {
            int min = findSmallest(al, i, hi);

            if (i != min)
            swap(al, i, min);
        }  // end for loop

    }  // end selectionSortHelper()

    /* Returns al in sorted order by selection sorting in both directions
     * On each pass, find index of both min & max in unsorted range
     * swap them to left & right ends, respectively
     */
    public static void dblSelectionSort(ArrayList al) {
        if (al==null || al.size() < 2)
            return;

        int hi = al.size() - 1;

        for(int lo=0; lo<=hi; lo++, hi--) {
            int[] minMax = findLocalMinMax(al, lo, hi);
            // System.out.println(al + " " + minMax[0] + " " + minMax[1]);

            if (lo != minMax[0])
                swap(al, lo, minMax[0]);  // what if max was at lo?

            if (hi != minMax[1]) {
                if (lo != minMax[1]) {
                    swap(al, hi, minMax[1]);
                } else {
                    swap(al, hi, minMax[0]);  // would've been moved
                }
            }  // end nested if
        }  // end for loop

    }  // end selectionSortHelper()

    public static ArrayList<Integer> mergeSort(ArrayList<Integer> al) {
        return mergeSort(al, 0, al.size());
    }

    // helper for mergeSort()
    // from index lo up to but not incl. hi
    private static ArrayList<Integer> mergeSort(ArrayList<Integer> al, int lo, int hi) {
        ArrayList<Integer> sorted = new ArrayList<Integer>();

        // base cases
        if (lo>hi)
            return sorted;

        if (lo == hi-1) {
            sorted.add(al.get(lo));
            return sorted;
        }

        // System.out.printf("ms: lo=%d, hi=%d\n", lo, hi);

        // dividing phase: sort each half
        int mid = (lo+hi)/2;
        ArrayList<Integer> al1 = mergeSort(al, lo, mid);
        ArrayList<Integer> al2 = mergeSort(al, mid, hi);
        int sz1 = al1.size(), sz2 = al2.size();

        // conquering phase: merge in order
        int i1 = 0, i2 = 0;  // indices to each sub-list
        int ele1, ele2;  // to hold actual values

        while (i1<sz1 && i2<sz2) {
            ele1 = (int)al1.get(i1);
            ele2 = (int)al2.get(i2);

            if (ele1 < ele2) {
                sorted.add(ele1);
                i1++;
            } else {
                sorted.add(ele2);
                i2++;
            }

        }  // end while--at least one of the sub-lists will be "empty"

        // copy non-empty list into the return array
        while (i1<sz1) {
            ele1 = (int)al1.get(i1);
            sorted.add(ele1);
            i1++;
        }

        while (i2<sz2) {
            sorted.add((int)al2.get(i2++));
        }

        return sorted;

    }  // mergeSort helper


}//end class
