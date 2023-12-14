package Day07;

import java.io.*;
import java.util.*;

class MergeSort {
    // Merges two subarrays of arr[].
    // First subarray is arr[l..m]
    // Second subarray is arr[m+1..r]

    void merge(ArrayList<Hand> arr, int l, int m, int r)
    {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;
        // Create temp arrays
        Hand[] L = new Hand[n1];
        Hand[] R = new Hand[n2];
        // Copy data to temp arrays
        for (int i = 0; i < n1; ++i)
            L[i] = arr.get(l + i);
        for (int j = 0; j < n2; ++j)
            R[j] = arr.get(m + 1 + j);
        // Merge the temp arrays
        // Initial indices of first and second subarrays
        int i = 0, j = 0;
        // Initial index of merged subarray array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i].getTier() <= R[j].getTier()) {
                arr.set(k, L[i]);
                i++;
            }
            else {
                arr.set(k, R[j]);
                j++;
            }
            k++;
        }
 
        // Copy remaining elements of L[] if any
        while (i < n1) {
            arr.set(k, L[i]);
            i++;
            k++;
        }
 
        // Copy remaining elements of R[] if any
        while (j < n2) {
            arr.set(k, R[j]);
            j++;
            k++;
        }
    }
 
    // Main function that sorts arr[l..r] using
    // merge()
    void sort(ArrayList<Hand> arr, int l, int r)
    {
        if (l < r) {
            // Find the middle point
            int m = l + (r - l) / 2;
            // Sort first and second halves
            sort(arr, l, m);
            sort(arr, m + 1, r);
            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }
    void merge2(ArrayList<Hand> arr, int l, int m, int r)
    {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;
        // Create temp arrays
        Hand[] L = new Hand[n1];
        Hand[] R = new Hand[n2];
        // Copy data to temp arrays
        for (int i = 0; i < n1; ++i)
            L[i] = arr.get(l + i);
        for (int j = 0; j < n2; ++j)
            R[j] = arr.get(m + 1 + j);
        // Merge the temp arrays
        // Initial indices of first and second subarrays
        int i = 0, j = 0;
        // Initial index of merged subarray array
        int k = l;
        int c = 0;
        while (i < n1 && j < n2) {
            //System.out.println("c: " + c + " i: " + i + " j: " + j);
            //System.out.println(L.length + " "+ arr.get(0).getHandArr().length );
            for (c=0; c<L[i].getHandArr().length-1; c++){
                if (L[i].getHandArr()[c] == R[j].getHandArr()[c]) {
                    //System.out.println(c);
                    //System.out.println(L[i].getHandArr()[c] +" "+ R[j].getHandArr()[c]);
                    //System.out.println("Index matched");
                }else{
                    break;
                }
            }
            if (L[i].getHandArr()[c] < R[j].getHandArr()[c]) {
                arr.set(k, L[i]);
                i++;
            }
            else {
                arr.set(k, R[j]);
                j++;
            }
            k++;
        }
        // Copy remaining elements of L[] if any
        while (i < n1) {
            arr.set(k, L[i]);
            i++;
            k++;
        }
        // Copy remaining elements of R[] if any
        while (j < n2) {
            arr.set(k, R[j]);
            j++;
            k++;
        }
    }
 
    // Main function that sorts arr[l..r] using
    // merge()
    void sort2(ArrayList<Hand> arr, int l, int r)
    {
        if (l < r) {
            // Find the middle point
            int m = l + (r - l) / 2;
            // Sort first and second halves
            sort2(arr, l, m);
            sort2(arr, m + 1, r);
            // Merge the sorted halves
            merge2(arr, l, m, r);
        }
    }
}