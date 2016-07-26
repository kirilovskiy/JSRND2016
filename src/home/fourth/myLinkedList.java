package home.fourth;

import java.util.ListIterator;
import java.util.NoSuchElementException;

public class myLinkedList<E> {
    //несериализуеые поля
    transient int size = 0;
    transient Node<E> first;
    transient Node<E> last;

    public myLinkedList() {
    }

    public int size(){ return size;}

    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        public Node() {
            this.next = null;
            this.prev = null;
        }

        public Node( Node<E> prev, E item, Node<E> next) {
            this.item = item;
            this.next = next;
            this.prev = prev;
        }
    }

    public E get(int index) {
        if (!((index>=0)&&(index<size)))
            throw new IndexOutOfBoundsException("Index: "+ index + "size: "+size);
        return node(index).item;
    }

    public E remove(int index){
        if (!((index>=0)&&(index<size)))
            throw new IndexOutOfBoundsException("Index: "+ index + "size: "+size);
        return unlink(node(index));
    }

    E unlink(Node<E> x) {
        final E element = x.item;
        final Node<E> next = x.next;
        final Node<E> prev = x.prev;

        if (prev == null){
            first = next;
        } else {
            prev.next = next;
            x.prev = null;
        }

        if (next == null){
            last = prev;
        } else {
            next.prev = prev;
            x.next = null;
        }

        x.item = null;
        size--;
        return element;
    }

    void linkBefore(E e, Node<E> succ){
        final Node<E> pred = succ.prev;
        final Node<E> newNode = new Node<>(pred, e, succ);
        succ.prev = newNode;
        if (pred == null)
            first = newNode;
        else
            pred.next = newNode;
        size++;
    }

    void linkLast(E e){
        final Node<E> l = last;
        final Node<E> newNode = new Node<>(l, e, null);
        last = newNode;
        if (l == null)
            first = newNode;
        else
            l.next = newNode;
        size++;
    }

    public boolean add(E e){
        linkLast(e);
        return true;
    }

    public void add(int index,E e) {
        if (!((index>=0)&&(index<=size)))
            throw new IndexOutOfBoundsException("Index: "+ index + "size: "+size);
        if (index == size)
            linkLast(e);
        else
            linkBefore(e, node(index));
    }

    public void clear() {
        for(Node<E> x = first; x!=null;){
            Node<E> next = x.next;
            x.item = null;
            x.next = null;
            x.prev = null;
            x = next;
        }
        first = last = null;
        size = 0;
    }

    Node<E> node(int index) {
        if (index < size >> 1){
            Node<E> x = first;
            for(int i = 0; i < index; i++)
                x = x.next;
            return x;
        } else {
            Node<E> x = last;
            for(int i = size - 1; i > index; i--)
                x = x.prev;
            return x;
        }
    }

    public ListIterator<E> listIterator(int index){
        if (!((index>=0)&&(index<size)))
            throw new IndexOutOfBoundsException("Index: "+ index + "size: "+size);
        return new ListIter(index);
    }

    private class ListIter implements ListIterator<E> {
        private myLinkedList.Node<E> lastReturned = null;
        private myLinkedList.Node<E> next;
        private int nextIndex;

        ListIter(int index){
            next = node(index);
            nextIndex = index;
        }

        public boolean hasNext(){
            return nextIndex < size;
        }

        public E next(){
            if (!hasNext())
                throw new NoSuchElementException();
            lastReturned = next;
            next = next.next;
            nextIndex++;
            return lastReturned.item;
        }

        public boolean hasPrevious() {
            return nextIndex > 0;
        }

        public E previous() {
            if (!hasPrevious())
                throw new NoSuchElementException();
            lastReturned = next = (next==null) ? last : next.prev;
            nextIndex--;
            return lastReturned.item;
        }

        public int nextIndex() {
            return nextIndex;
        }

        public int previousIndex() {
            return nextIndex-1;
        }

        public void remove() {
            if (lastReturned == null)
                throw new IllegalStateException();
            myLinkedList.Node<E> lastNext = lastReturned.next;
            unlink(lastReturned);
            if (next == lastReturned)
                next = lastNext;
            else
                nextIndex--;
            lastReturned = null;
        }

        public void set(E e){
            if (lastReturned == null)
                throw new IllegalStateException();
            lastReturned.item = e;
        }

        public void add(E e) {
            lastReturned = null;
            if (next == null)
                linkLast(e);
            else
                linkBefore(e, next);
            nextIndex++;
        }
    }

}
