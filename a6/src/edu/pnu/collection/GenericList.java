package edu.pnu.collection;
public class GenericList<T> {
    private static final int DEFAULT_SIZE = 10;
    private Object[] data;
    private int size = 0;

    public GenericList(){
        data = new Object[10];
        size = 0;
    }

    public void add(T data){
        this.data[size++] = data;
    }

    public T get(int index){
        return (T) data[index];
    }

    public void clear(){
        data = new Object[0];
        size = 0;
    }

    public int size(){
        return size;
    }

}
