package com.prepare.secondstructure.heaps;

import java.util.ArrayList;

public class CustomPQ{
    private final ArrayList<Integer> arrayList;
    private int size;

    public CustomPQ(){
        arrayList = new ArrayList<>();
        size = 0;
    }

    public void insert(int data){
        arrayList.add(data);
        if(size > 0){
            int child = size;
            bubbleUp(child);
        }
        size++;
    }

    private void bubbleUp(int child){
        int parent = (child -1)/2;
        if (arrayList.get(child) > arrayList.get(parent)){
            swap(child,parent);
        }else{
            return;
        }
        bubbleUp(parent);
    }
    public void poll(){
       swap(0, arrayList.size()-1);
       arrayList.remove(arrayList.size()-1);
        size--;
        System.out.println(size);
       bubbleDown(0);
    }

    private boolean bubbleDown(int parent){
        int left = 2*parent + 1;
        int right = 2*parent + 2;
        if(left >= size && right >= size){
            return true;
        }else if(left < size && right < size){
            if(arrayList.get(parent) > arrayList.get(left) && arrayList.get(parent) > arrayList.get(right)){
                return true;
            }else if(arrayList.get(parent) < arrayList.get(left)
                    && arrayList.get(left) >= arrayList.get(right)){
                swap(parent,left);
                bubbleDown(left);
            }else if(arrayList.get(parent) < arrayList.get(right) &&
                    arrayList.get(right) > arrayList.get(left)){
                swap(parent, right);
                bubbleDown(right);
            }

        }else if(left < size && right > size) {
            //threat parent and right
            if (arrayList.get(parent) > arrayList.get(left)) {
                return true;
            } else if (arrayList.get(parent) < arrayList.get(left)) {
                swap(parent, left);
                bubbleDown(left);
            }
        }
        return true;
    }
    public void remove(int data){

    }

    private void swap(int index1, int index2){
        int element1 = arrayList.get(index1);
        int element2 = arrayList.get(index2);

        arrayList.set(index1, element2);
        arrayList.set(index2, element1);
    }
    @Override
    public String toString() {
        return arrayList.toString();
    }
}
