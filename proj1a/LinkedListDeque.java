public class LinkedListDeque<T> {

    /* create a nested class IntList */

    public class IntList<T>{
        IntList front;
        T item;
        IntList next;

        public IntList(IntList f,T i,IntList n ) {
            front = f;
            item = i;
            next = n;
        }
    }

    IntList sentinel;
    int size;

    /*  constructor of LinkedListDeque*/
    public LinkedListDeque(){
        sentinel=new IntList(null,1,null);
        size=0;
    }

    public LinkedListDeque(T item){
        sentinel.next=new IntList(sentinel,item,sentinel);
        sentinel.front=sentinel.next;
        size=1;
    }

    public void addFirst(T item){
        sentinel.next=new IntList(sentinel,item,sentinel.next);
        sentinel.next.next.front=sentinel.next;
        size+=1;
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
        return p.item;
    }

    public T removeLast(){
        if (sentinel.front==null){
            return null;
        }
        T result=sentinel.front.item;
        sentinel.front=sentinel.front.front;
        sentinel.front.next=sentinel;
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
        return getRecursize(index-1);
    }
}
