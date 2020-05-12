package org.practice;

import java.util.ArrayList;

//minHeap
public class BinaryHeap {

    ArrayList<Integer> heap;

    public BinaryHeap() {
        heap = new ArrayList<>();
    }

    public void insert(int x) {
        if (heap.isEmpty()) {
            heap.add(x);
            return;
        }
        heap.add(x);
        traverseUp(heap.size()-1);
    }

    public int extractMin() {
        int len = heap.size();
        int min = heap.get(0);
        swap(0, len-1);
        heap.remove(len-1);
        heapify(0);
        return min;
    }

    public void heapify(int index) {
        int len = heap.size();
        int left = index*2 + 1;
        int right = index*2 + 2;
        if(left < len && right < len && (heap.get(index) > heap.get(left) || heap.get(index) > heap.get(right))) {
            if(heap.get(left) < heap.get(right)) {
                swap(left, index);
                heapify(left);
            }
            else {
                swap(right, index);
                heapify(right);
            }
        }
        else if(left < len) {
            if(heap.get(left) < heap.get(index)) {
                swap(left, index);
            }
        }
    }

    public void traverseUp(int index) {
        if(index == 0) return;
        int pIndex = (index-1)/2;
        if(heap.get(pIndex) > heap.get(index)) {
            swap(pIndex, index);
            traverseUp(pIndex);
        }
    }

    public void swap(int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    public void decreaseKey(int index, int val) {
        heap.set(index, val);
        traverseUp(index);
    }

    public static void main(String[] args) {
        BinaryHeap bHeap = new BinaryHeap();
        for(int i=0; i<8; i++) {
            bHeap.insert((int) (Math.random()*20));
        }
        System.out.println(bHeap.heap.toString());
    }

    //parent: (i-1)/2
    //left child: 2i+1
    //right child: 2i+2
}