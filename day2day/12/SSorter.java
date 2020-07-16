/**
**/

import java.io.*;
import java.util.*;

public class SSorter
{


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
        return mergeSort(al, 0, al.size() - 1);
    }

    // helper for mergeSort()
    private static ArrayList<Integer> mergeSort(ArrayList<Integer> al, int lo, int hi) {
        if (al.size() < 2)
            return al;

        int mid = (lo+hi)/2;

        // dividing phase: sort each half
        mergeSort(al, lo, mid);
        mergeSort(al, mid+1, hi);

        // conquering phase: merge in order
        int i1 = lo, i2 = mid+1;  // indices to each sub-list
        int ele1, ele2;  // to hold actual values
        ArrayList<Integer> sorted = new ArrayList<Integer>();

        while (i1<=mid && i2<=hi;) {
            ele1 = (int)al.get(i1);
            ele2 = (int)al.get(i2);

            if (ele1 < ele2) {
                sorted.add(ele1);
                i1++;
            } else {
                sorted.add(ele2);
                i2++;
            }

        }  // end while--at least one of the sub-lists will be "empty"

        while (i1 <= mid) {
            ele1 = (int)al.get(i1);
            sorted.add(ele1);
            i1++;
        }

        while (i2 <= hi) {
            sorted.add((int)al.get(i2++));
        }

        return sorted;

    }//selectionSort



    //##################################################
    //##################################################

    public static void main( String[] args )
    {
        ArrayList<Integer> randos = prestoArrayListo(100000, 0, 100);

        // System.out.println(randos);

        long start = System.currentTimeMillis();

        selectionSort(randos);

        long elapsed = System.currentTimeMillis() - start;

        // System.out.println(randos);
        System.out.println("Elapsed time: " + elapsed);

    }//end main

}//end class
