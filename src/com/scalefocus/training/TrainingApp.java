package com.scalefocus.training;

import com.scalefocus.training.algorithm.sort.BubbleSort;
import com.scalefocus.training.algorithm.sort.InsertionSort;
import com.scalefocus.training.algorithm.sort.MergeSort;
import com.scalefocus.training.algorithm.sort.QuickSort;
import com.scalefocus.training.algorithm.sort.SelectionSort;
import com.scalefocus.training.collection.tree.BinarySearchTree;
import com.scalefocus.training.collection.tree.TreeNode;
import com.sun.scenario.effect.Merge;

public class TrainingApp {

    public static void main(String[] args) {
        int[] array = {21, 12, 99, 3, 83, 27, 19, 17 ,15};
        QuickSort quickSort = new QuickSort();
        quickSort.medianSort(array, 0, array.length - 1);
        for (int index: array) {
            System.out.print(index + " ");
        }
    }
}
