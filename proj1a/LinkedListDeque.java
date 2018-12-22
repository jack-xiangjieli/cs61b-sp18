public class LinkedListDeque<T> {

    /* create a nested class IntList */

    private class IntList{
        public IntList front;
        public T item;
        public IntList next;

        public IntList(IntList f,T i,IntList n ) {
            front = f;
            item = i;
            next = n;
        }
    }

    public IntList sentinel;
    public int size;

    /*  constructor of LinkedListDeque*/
    public LinkedListDeque(){
        sentinel=new IntList(null,null,null);
        size=0;
    }

    public LinkedListDeque(T item){
        sentinel.next=new IntList(sentinel,item,sentinel);
        sentinel.front=sentinel.next;
        size=1;
    }

    public void addFirst(T item){
        if (size==0){
            sentinel.next=new IntList(sentinel,item,sentinel);
            sentinel.front=sentinel.next;
            size+=1;
        } else {
            sentinel.next=new IntList(sentinel,item,sentinel.next);
            sentinel.next.next.front=sentinel.next;
            size+=1;
        }

    }

    public void addLast(T item){
        sentinel.front=new IntList(sentinel.front,item,sentinel);
        sentinel.front.front.next=sentinel.front;
        size+=1;
    }

    public boolean isEmpty(){
        return this.size()==0;
    }

    public int size(){
        return size;
    }

    public void printDeque(){
        IntList p=sentinel.next;
        for(int i=0;i<this.size();i++){
            System.out.print(p.item+" ");
            p=p.next;
        }
    }

    public T removeFirst(){
        if (sentinel.next==null){
            return null;
        }
        IntList p=sentinel.next;
        sentinel.next=sentinel.next.next;
        sentinel.next.front=sentinel;
        size-=1;
        return p.item;

    }

    public T removeLast(){
        if (sentinel.front==null){
            return null;
        }
        T result=sentinel.front.item;
        sentinel.front=sentinel.front.front;
        sentinel.front.next=sentinel;
        size-=1;
        return result;
    }

    public T get(int index){
        if (index>=size){
            return null;
        }
        IntList p=sentinel.next;
        for (int i=0;i<index;i++){
            p=p.next;
        }
        return p.item;
    }

    public T getRecursive(int index){
        if(index==0){
            return sentinel.next.item;
        }
        return getRecursive(index-1);
    }
}
