import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayListCTest {

    ArrayListC<Object> arr = new ArrayListC<>();

    @BeforeEach
    @DisplayName("Initialize Objects to test")
    public void initItems(){

        arr = new ArrayListC<>();
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
    @DisplayName("Object ArrayList, throws exception, when you create an object with initialize capacity less than 0")
    void arrayList() {
        assertThrows(IllegalArgumentException.class, ()-> new ArrayListC<>(-1));
    }

    @Test
    @DisplayName("Remove item, throws exception ,when index is less than 0  ")
    void remove() {
        assertThrows(IndexOutOfBoundsException.class, () -> arr.remove( -1));
    }

    @Test
    @DisplayName("Remove item 2,Remove item from list ,when index are in the range of the size ")
    void remove2() {
        arr.remove(2);
    }

    @Test
    @DisplayName("Remove object item, throws exception, when you try to remove a single element that are null")
    void remove3() {
        assertThrows(NullPointerException.class, ()-> arr.remove(null));
    }

    @Test
    @DisplayName("Contain object in array, throws exception, when you try to look for a object that is null ")
    void contains() {
        assertThrows(NullPointerException.class, ()-> arr.contains(null));
    }

    @Test
    @DisplayName("Contain object 2 in array, return true, when the expected object are in the array ")
    void contains2() {
        String je= "pop";
        assertTrue(arr.contains(je));
    }

    @Test
    @DisplayName("Contain object 3 in array, return False, when the expected object are NOT in the array ")
    void contains3() {
        int x =10;
        assertFalse(arr.contains(x));
    }

    @Test
    @DisplayName("Check Size, throws exception, when you try to remove using index but the array size is lower ")
    void checkSize() {
        assertThrows(IndexOutOfBoundsException.class, ()-> arr.checkSize(20,arr.size()));
    }

    @Test
    @DisplayName("Get , throws exception, when you try to get index but it is less than 0 ")
    void get() {
        assertThrows(IllegalArgumentException.class, ()-> arr.get(-1));
    }

    @Test
    @DisplayName("Clear, Resize the array to 0, when you use the function clear")
    void clear() {
        arr.clear();
        assertEquals(0, arr.size());
    }

}
