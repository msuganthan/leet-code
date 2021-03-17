package queue;

public class MyCircularQueue {
    int[] arr;
    int front, len = 0, rear = -1;

    public MyCircularQueue(int k) {
        arr = new int[k];
    }

    public boolean enQueue(int val) {
        if (isFull()) return false;

        len++;
        rear = (rear + 1) % arr.length;
        arr[rear] = val;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) return false;

        front = (front + 1) % arr.length;
        len--;
        return true;
    }

    public int Front() {
        return isEmpty() ? -1 : arr[front];
    }

    public int Rear() {
        return isEmpty() ? -1 : arr[rear];
    }

    public boolean isEmpty() {
        return len == 0;
    }

    public boolean isFull() {
        return len == arr.length;
    }
}
