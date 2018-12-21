public class ArrayDeque<T> {
    int size;
    int[] a;
    public ArrayDeque(){
        a=new int[8];
        size=0;
    }

    public int[] resize(int[] a,int factor){
        int[] b=new int[a.length+factor];
        System.arraycopy(a,0,b,0,a.length);
        return b;
    }
    public void addFirst(T item){
        int[] b=

    }
}
