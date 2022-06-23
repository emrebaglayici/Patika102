package GenericsHomework;

import java.util.Arrays;

public class MyList<T> {
    private T[] array;
    int start;
    int end;
    private Integer capacity;

    public MyList() {
        this.capacity=giveCapacity();
        this.array = (T[]) new Object[10];
    }

    public MyList(Integer capacity) {
        this.start=0;
        this.end=-1;
        this.capacity=capacity;
        this.array=(T[])new Object[capacity];
    }


    public Integer getCapacity() {
        return array.length;
    }



    public Integer giveCapacity(){
        return capacity;
    }

    //Dolu eleman sayısını verir.
    public Integer size(){
        Integer count = 0;
        for (T i:this.array){
            if(i==null)
                return count;
            count++;
        }
        return count;
    }
    public T get(int i){
        if(i<getCapacity()){
            if(i<0 || array[i]==null)
                return null;

        }else{
            return null;
        }
        return array[i];

    }

    public T remove(int indis){
        if(indis<size()){
            for (int i = indis; i < size();i++) {
                if(i==size()-1){
                    this.array[i]=null;
                }else{
                    array[i]=array[i+1];
                }
            }
        }else{
            return null;
        }

        return get(indis);
    }

    public T set(int indis,T data){
        if(indis<getCapacity()){
            if(indis<0 || array[indis]==null)
                return null;
        }else if(indis>getCapacity()){
           return null;
        }else {
            for (int i = indis; i <size() ; i++) {
                if(array[i]==array[indis]){
                    this.array[i]=data;
                }
            }
        }
        return get(indis);
    }


    public int indexOf(T data){
        for (int i = 0; i < array.length; i++) {
            if(array[i]==data){
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(T data){
        int top=-1;
        for (int i = size(); i >= 0; i--) {
            if(array[i]==data){
                return i;
            }
        }
        return -1;
    }

    public boolean isEmpty(){
        for (T i:this.array){
            if(i!=null)
                return false;
        }
        return true;
    }

    public MyList<T> sublist(int start,int finish){
        MyList<T> newList=new MyList<>();
        for (int i = start; i <=finish ; i++) {
            if(array[i]!=null)
                newList.add(array[i]);
        }
        return newList;
    }

    public T[] toArray(){
        T[] newArray;
        return newArray=Arrays.copyOf(array,size());
    }

    public void clear(){
        this.array=(T[]) new Object[10];
    }

    public String toString(){
        for (int i = 0; i < array.length; i++) {
            if(this.array[i]!=null){
                return Arrays.toString(this.array);
            }
        }
        return "";

    }
    public boolean contains(T data){
        for (int i = 0; i < array.length; i++) {
            if(array[i]==data)
                return true;
        }
        return false;
    }
    private boolean isFull(int i) {
        return array[i] != null;
    }
    public void add(T data){
        for (start=0; start < array.length; start++) {
            if(!isFull(start)){
                array[start]=data;
                break;
            }else{
                if(start==getCapacity()-1)
                    this.array=Arrays.copyOf(this.array,size()*2);
            }
        }

    }
}
