import java.util.EmptyStackException;

interface Comparator<T> {
    int compare(T a, T b);
}

class DynamicComparator<T> {
    private Comparator<T> comp;

    DynamicComparator(Comparator<T> comp) {
        this.comp = comp;
    }

    public int compare(T a, T b) {
        return comp.compare(a, b);
    }
}

public class Main {
    public static void main(String[] args) {
        Comparator<Integer> intComparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return a - b; 
            }
        };

        MyArrayList<Integer> arr = new MyArrayList<>(intComparator);

        arr.add(5);
        arr.add(3);
        arr.add(8);
        arr.add(1);

        System.out.println("Before sorting:");
        for (int i = 0; i < arr.len(); i++) {
            System.out.print(arr.get(i) + " ");
        }
        System.out.println();

        arr.sort(0, arr.len() - 1);

        System.out.println("After sorting:");
        for (int i = 0; i < arr.len(); i++) {
            System.out.print(arr.get(i) + " ");
        }
        System.out.println();

        int searchVal = 3;
        int index = arr.search(searchVal);
        if (index != -1) {
            System.out.println("Element " + searchVal + " found at index: " + index);
        } else {
            System.out.println("Element " + searchVal + " not found.");
        }

        System.out.println("Popping back: " + arr.pop_back());
        System.out.println("Size after pop: " + arr.len());
    }


    static class MyArrayList<T> {

        private T[] data;
        private int size;
        private int capacity;
        private boolean isSorted = false;
        
        private Comparator<T> comparator;
        
        MyArrayList(Comparator<T> comp) {
            this.capacity = 10;
            this.data = newArray(capacity);
            this.size = 0;
            this.comparator = comp;
        }

        @SuppressWarnings("unchecked")
        private T[] newArray(int cap) {
            return (T[]) new Object[cap];
        }

        public void add(T val) {
            if (size == capacity)
                resize();
            data[size++] = val;
            isSorted = false;
        }

        public T get(int idx) {
            if (idx < 0 || idx >= size)
                throw new IndexOutOfBoundsException();
            return data[idx];
        }

        public int len() {
            return size;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public T pop_back() {
            if (isEmpty())
                throw new EmptyStackException();

            T val = data[--size];
            data[size] = null;
            return val;
        }

        public int search(T val) {
            if (isSorted) {
                int l = 0, r = size - 1;
                while (l <= r) {
                    int m = l + (r - l) / 2;
                    
                    int cmp = comparator.compare(data[m], val);

                    if (cmp == 0) return m;
                    if (cmp < 0) l = m + 1;
                    else r = m - 1;
                }
                return -1;
            }

            for (int i = 0; i < size; i++) {
                if (data[i].equals(val))
                    return i;
            }
            return -1;
        }

        public void sort(int l, int r) {
            if (l < r) {
                int m = l + (r - l) / 2;
                sort(l, m);
                sort(m + 1, r);
                merge(l, m, r);
                isSorted = true;
            }
        }

        private void merge(int l, int m, int r) {
            int n1 = m - l + 1;
            int n2 = r - m;

            T[] L = newArray(n1);
            T[] R = newArray(n2);

            for (int i = 0; i < n1; i++)
                L[i] = data[l + i];
            for (int j = 0; j < n2; j++)
                R[j] = data[m + 1 + j];

            int i = 0, j = 0, k = l;

            while (i < n1 && j < n2) {                
                if (comparator.compare(L[i], R[j]) <= 0)
                    data[k++] = L[i++];
                else
                    data[k++] = R[j++];
            }

            while (i < n1)
                data[k++] = L[i++];

            while (j < n2)
                data[k++] = R[j++];
        }

        private void resize() {
            capacity *= 2;
            T[] newData = newArray(capacity);
            for (int i = 0; i < size; i++)
                newData[i] = data[i];
            data = newData;
        }
    }
}