package queue;

public class MyCircularDeque {
    int[] arr;
    int front, rear, len, k;
    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        this.arr = new int[k];
        this.k = k;
        this.front = k - 1;
        this.rear = 0;
        this.len = 0;
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if (isFull()) return false;

        arr[front] = value;
        front = (front - 1 + k) % k;
        ++len;
        return true;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if (isFull()) return false;

        arr[rear] = value;
        rear = (rear + 1) % k;
        ++len;
        return true;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if (isEmpty()) return false;
        front = (front + 1) % k;
        --len;
        return true;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if (isEmpty()) return false;

        rear = (rear - 1 + k) % k;
        --len;
        return true;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        return isEmpty() ? -1 : arr[(front + 1) % k];
    }

    /** Get the last item from the deque. */
    public int getRear() {
        return isEmpty() ? -1 : arr[(rear - 1 + k) % k];
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return len == 0;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return len == arr.length;
    }

    public static void main(String[] args) {
        
        MyCircularDeque obj = new MyCircularDeque(3);
        boolean param_1 = obj.insertLast(1);
        boolean param_2 = obj.insertLast(2);
        boolean param_3 = obj.insertFront(3);
        boolean param_4 = obj.insertFront(4);
        int param_5 = obj.getRear();
        boolean param_6 = obj.isFull();
        boolean param_7 = obj.deleteLast();
        boolean param_8 = obj.insertFront(4);
        int param_9 = obj.getFront();
    }
}
