/**
**/

import java.io.*;
import java.util.*;

public class SSorter
{

    //##################################################
    //##################################################

    // run with command line argument specifying length of array list
    public static void main( String[] args )
    {
        int len = 5;
        if (args.length>0)
            len = Integer.parseInt(args[0]);

        ArrayList<Integer> randos = prestoArrayListo(len, 0, 100);

        System.out.println("unsorted : " + randos);

        // long start = System.currentTimeMillis();
        ArrayList<Integer> sorted = mergeSort(randos);
        System.out.println("merge    : " + sorted);

        // randos = prestoArrayListo(10, 0, 100);
        selectionSort(randos);
        System.out.println("selection: " + randos);

        // long elapsed = System.currentTimeMillis() - start;
        // System.out.println("Elapsed time: " + elapsed);


    }  // end main()


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
    public static int findSmallest(ArrayList<Integer> al, int lo, int hi){
        int maxIndexSoFar = lo;
        for (int i = lo; i <=hi; i++) {
            if (al.get(i) < al.get(maxIndexSoFar)){
                maxIndexSoFar = i;
            }
        }
        return maxIndexSoFar;
    }

    public static void selectionSort(ArrayList<Integer> al) {

        int lo = 0;
        int temp;

        for (int i=0; i < al.size() - 1; i++) {
            lo = findSmallest(al, i, al.size()-1);
            swap(al, i, lo);
        }

    }//selectionSort

    /* Swaps elements at the two given indices
    */
    private static void swap(ArrayList<Integer> al, int i1, int i2) {
        Integer temp = al.get(i1);
        al.set(i1, al.get(i2));
        al.set(i2, temp);
    }

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
