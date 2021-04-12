import java.util.ArrayList;

import java.util.Arrays;
import java.util.Collections;

import java.util.List;

public class BoxProcessor {

    public void sort(Box[] array){ //selection sort algo.

        for (int i = 0; i < array.length; i++) {

            for (int j = i + 1; j < array.length; j++) {

                if (array[i].compareTo(array[j]) == 1) {

                    Box b = array[i];

                    array[i] = array[j];

                    array[j] = b;


                }
            }

        }


    }

    public void sort(List<Box> list) {


        for (int i = 0; i < list.size(); i++) {

            for (int j = i + 1; j < list.size(); j++) {

                if (list.get(i).compareTo(list.get(j)) == 1) {

                    Collections.swap(list, i, j); //calling default function for swap

                }

            }

        }


    }



    public int sequentialSearch(Box[] array, Box box){

        int searchIndex=-1; //set index by default to -1

        for(int i=0;i<array.length;i++){

            if(array[i].compareTo(box)==0){

                searchIndex = i;

            }

        }

        return searchIndex;

    }

    public int sequentialSearch(List<Box> list, Box box){
        ArrayList<Box> boxArrayList = new ArrayList<Box>(list);
        int searchIndex=-1;

        for(int i=0;i<boxArrayList.size();i++){

            if(boxArrayList.get(i).compareTo(box)==0){

                searchIndex = i;

            }

        }

        return searchIndex;

    }

    public int binarySearch(Box[] array, Box box){
        return binarySearchArrayHelper(array , box , 0, array.length);
    }

    private int binarySearchArrayHelper(Box[] array , Box box , int low, int high) {
        List<Box> arrayToList = Arrays.asList(array);
        int middle = (low + high) / 2;

        if (!arrayToList.contains(box)) {
            return -1;
        }

        if (array[middle].compareTo(box) == 0){
            return middle;
        } else if (array[middle].compareTo(box) == 1) {
            return binarySearchArrayHelper(array, box, low, middle - 1);
        } else {
            return binarySearchArrayHelper(array, box, middle + 1, high);
        }
    }

    public int binarySearch(List<Box> list , Box box ){
        return binarySearchListHelper(list , box , 0,list.size());
    }

    private int binarySearchListHelper(List<Box> list , Box box , int low, int high) {
        ArrayList<Box> boxArrayList = new ArrayList<Box>(list);
        int middle = (low + high) / 2;

        if (!list.contains(box)) {
            return -1;
        }

        if (boxArrayList.get(middle).compareTo(box) == 0) {
            return middle;
        } else if (boxArrayList.get(middle).compareTo(box) == 1) {
            return binarySearchListHelper(boxArrayList, box, low, middle - 1);
        } else {
            return binarySearchListHelper(boxArrayList, box, middle + 1, high);
        }
    }

}
