public class ArrayDeque<T> {
    private int size;
    private int nextfirst;
    private int nextlast;
    private T[] a;

    public ArrayDeque(){
        a=(T[])new Object[8];
        size=0;
        nextfirst=0;
        nextlast=1;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size==0;
    }

    private void resize( ){
        T[] b=(T[])new Object[a.length+1];
        System.arraycopy(a,0,b,0,nextlast);
        if(nextlast<=size-1) {
            System.arraycopy(a, nextlast + 2, 0, nextlast + 3, size - nextlast);
        }
        a=b;
    }
    public void addFirst(T item){
        if(size>=a.length-2){
            resize();
            if (nextfirst!=0) {
                nextfirst += 1;
            }
        }
        a[nextfirst]=item;
        if (nextfirst==0) {
            nextfirst = a.length - 1;
        } else {nextfirst=nextfirst-1;}

        size+=1;
    }

    public void addLast(T item){
        if(size>=a.length-2) {
            resize();
            if (nextlast != size + 1) {
                nextfirst += 1;
            }
        }
        a[nextlast]=item;
        if (nextlast==a.length-1){
            nextlast=0;
        }else {nextlast+=1;}

        size+=1;
    }

    public T removeFirst(){
        if(size==0){
            return null;
        }
        T output;
        if (nextfirst==a.length-1){
            output=a[0];
            a[0]=null;
            nextfirst=0;
        } else {
            output = a[nextfirst + 1];
            a[nextfirst + 1] = null;
            nextfirst += 1;
        }
        size-=1;
        return output;
    }

    public T removeLast(){
        if(size==0){
            return null;
        }
        T output;
        if (nextlast==0){
            output=a[a.length-1];
            a[a.length-1]=null;
            nextlast=a.length-1;
        } else {
            output = a[nextlast - 1];
            a[nextlast - 1] = null;
            nextfirst -= 1;
        }
        size-=1;
        return output;
    }

    public void printDeque(){
        int index=nextfirst+1;
        for (int i=0; i<size;i++){
            if (index==a.length){
                index=0;
            }
            System.out.print(a[index]+" ");
            index+=1;
        }
    }

    public T get(int index){
        if(index>size-1){
            return null;
        }
        else if (index<=a.length-nextfirst-2){
            return a[index+nextfirst+1];
        }
        else{
            return a[index+nextfirst+1-a.length];
        }
    }

}
