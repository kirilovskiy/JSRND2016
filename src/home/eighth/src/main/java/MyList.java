import java.util.Iterator;

public class MyList<E> implements Iterable<E> {
    public static final int DEFAULT_CAPACITY = 16;
    private int size = 0;
    private E[] mas = (E[]) new Object[DEFAULT_CAPACITY];

    public void add(E e){
        ensureCapacity();
        mas[size] = e;
        size++;
    }
//переделать удаление
    public E remove(int index) {
        if (index > size() || index <0)
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds");
        E tmp = mas[index];
        System.arraycopy(mas, index + 1, mas, index, mas.length - index - 1);
        mas[size()-1] = null;
        size--;
        return tmp;
    }

    public int size(){return size;}

    public E get(int index){
        if (index > size() || index <0)
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds");
        return mas[index];
    }

    public E set(int index, E element) {
        E tmp = mas[index];
        mas[index] = element;
        return tmp;
    }

    public void ensureCapacity(){
        if (size == mas.length) {
            E[] newMas = (E[])(new Object[size*3/2+1]);
            System.arraycopy(mas, 0, newMas, 0, size);
            mas = newMas;
        }
    }

    public MyList() {
    }

    public MyList(E[] objects) {
        for(int i = 0; i < objects.length; i++)
            add(objects[i]);
    }

    @Override
    public Iterator<E> iterator() {
        return new ListIter();
    }

    private class ListIter implements Iterator<E>{
        private int position = 0;
        @Override
        public boolean hasNext() {
            return (position<size);
        }

        @Override
        public E next() {
            return mas[position++];
        }

        @Override
        public void remove() {
            if (hasNext() && size() != 0){
                E tmp = mas[position];
                System.arraycopy(mas, position + 1, mas, position, mas.length - position -- -1);
                mas[size()] = null;
            }
        }
    }
}
