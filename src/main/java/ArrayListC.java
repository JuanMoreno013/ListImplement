import java.util.Arrays;

public class ArrayListC<E> implements List<E>{

    private static final int initial_capacity = 10;
    private static final Object[] emptyElements = {};
    private int size;
    private Object[] elements;
    private static final int factorIncrease = 2;

    public ArrayListC (){
        this.elements = new Object[initial_capacity];
    }

    public ArrayListC(int initialCapacity){
        if (initialCapacity > 0) {
            this.elements = new Object[initialCapacity];
        } else if (initialCapacity < 0) {
            throw new IllegalArgumentException();
        } else {
            this.elements = emptyElements;
        }
    }
    @Override
    public void add(E ele) {
        if (ele == null)
            return;
        checkCapacity();
        elements[size++] = ele;
    }

    private void checkCapacity() {
        if (elements.length == size) {
            increase(size + 1);
        }
    }
    private void increase(int minCapacity) {

        int oldCapacity = elements.length;
        int newCapacity = oldCapacity * factorIncrease;

        if (newCapacity - minCapacity >= 0) {
            elements = Arrays.copyOf(elements,newCapacity);
        }
        if (minCapacity < 0)
            throw new OutOfMemoryError();
    }
    @Override
    public int size() {
        return size;
    }


    @Override
    public E get(int index) {

        if (index < 0) {
            throw new IllegalArgumentException();
        }
        checkSize(index,size);
        return (E) elements[index];
    }

    @Override
    public boolean contains(E item) {
        boolean cont=false;

        if (item!=null)
        {
            for(Object o: elements)
            {
                if(item.equals(o))
                {
                    cont= true;
                    break;
                }
            }
        }

//
        if ( item== null )
            throw new NullPointerException(" The item are null ");

        return cont;
    }

    @Override
    public void checkSize(int index, int size) {
        if (index >= size){
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public void remove(int index) {
        checkSize(index, size);
        Object[] elements2 = Arrays.copyOfRange(elements,index+1, elements.length);
        System.arraycopy(elements2,0, elements, index, elements2.length);
        size--;

    }

    @Override
    public void remove(E item) {

        int i= 0;
        if ( item== null )
            throw new NullPointerException(" The item are null ");

        for (; i < size; i++)
                if (item.equals(elements[i]))
                    break;

        remove(i);
    }

    @Override
    public void clear() {

        for (int i = 0; i<size; i++){
            elements[i]= null;
        }
        size = 0;
    }

}
