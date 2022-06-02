public interface List<E> {

//    java.util.ArrayList

    void add(E item);
    int size();
    E get(int index);
    boolean contains(E item);
    void checkSize (int index, int size);
    void remove(int index);
    void remove(E item);
    void clear();


}
