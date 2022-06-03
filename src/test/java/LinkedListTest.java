import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {


    LinkedList<Object> arr = new LinkedList<>();

    @BeforeEach
    @DisplayName("Initialize Objects to test")
    public void initItems(){
//        System.out.println("Before");

        arr = new LinkedList<>();
        String b2 = new String("pop");

        String le1 = "pop";
        arr.add("1");
        arr.add("2");
        arr.add("3");
        arr.add("4");
        arr.add("5");
        arr.add("6");
        arr.add("7");
        arr.add("8");
        arr.add("9");
        arr.add("10");
        arr.add("11");
        arr.add("12");
        arr.add(b2);
        arr.add(le1);
    }


    @Test
    @DisplayName("Object Linked list, throws exception, when you create an object that's null ")
    void ArrayList() {
        assertThrows(NullPointerException.class, ()-> new LinkedList<>(null));
    }

    @Test
    @DisplayName("Add, throws exception, when you try to add an object that is null")
    void add() {
        assertThrows(NullPointerException.class, ()-> arr.add(null));
    }

    @Test
    @DisplayName("Add 2, Adds elements, when the linked list has elements")
    void add2() {
        LinkedList<Object> arr2 = new LinkedList<>();
        int x =90, y=1;
        String l = "hello";
        arr2.add(y);
        arr2.add(x);
        arr2.add(l);

        assertEquals(3, arr2.size());
    }
    @Test
    @DisplayName("Size, return the size of the elements, when are called")
    void size() {
        assertEquals(14, arr.size());
    }

    @Test
    @DisplayName("Get , throws exception, when you try to get index but it is less than 0 or greater than the current size")
    void get() {
        assertThrows(IllegalArgumentException.class, ()-> arr.get(-1));
        assertThrows(IllegalArgumentException.class, ()-> arr.get(90));
    }

    @Test
    @DisplayName("Get , get the item in the list, when you get the item by a correct index ")
    void get2() {
        assertThrows(IllegalArgumentException.class, ()-> arr.get(-1));
    }

    @Test
    @DisplayName("Contain object in list, throws exception, when you try to look for a object that is null ")
    void contains() {
        assertThrows(NullPointerException.class, ()-> arr.contains(null));
    }

    @Test
    @DisplayName("Contain object 2 in list, return true, when the expected object are in the list ")
    void contains2() {
        String je= "pop";
        assertTrue(arr.contains(je));
    }

    @Test
    @DisplayName("Contain object 3 in list, return False, when the expected object are NOT in the list ")
    void contains3() {
        int x =102982339 ;
        assertFalse(arr.contains(x));
    }

    @Test
    @DisplayName("Check Size, throws exception, when you try to remove using index but the array size is lower ")
    void checkSize() {
        assertThrows(IndexOutOfBoundsException.class, ()-> arr.checkSize(20,arr.size()));
    }

    @Test
    @DisplayName("Remove item, throws exception ,when index is less than 0  ")
    void remove() {
        assertThrows(IndexOutOfBoundsException.class, () -> arr.remove( -1));
    }

    @Test
    @DisplayName("Remove item 2, throws exception, when you try to remove a single element that are null")
    void remove2() {
        assertThrows(NullPointerException.class, ()-> arr.remove(null));
    }

    @Test
    @DisplayName("Remove item 3,Remove item from list ,when index are in the range of the size ")
    void remove3() {
        int old_v = arr.size()-1;
        arr.remove(2);
        assertEquals(old_v, arr.size());
    }

    @Test
    @DisplayName("Clear, Resize the list to 0, when you use the function clear")
    void clear() {
        arr.clear();
        assertEquals(0, arr.size());
    }
}