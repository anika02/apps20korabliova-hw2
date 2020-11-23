package ua.edu.ucu.collections.immutable;

import org.junit.Test;
import static org.junit.Assert.*;

public class ImmutableArrayListTest {

//--------------------------------------------------------------------------
    @Test
    public void testImmutableArrayListEmpty() {
        ImmutableArrayList arrayList = new ImmutableArrayList();
        int expResult = 0;
        int actualResult = arrayList.size();
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testImmutableArrayListFromArray() {
        Integer[] elements = {3, -5, 1};
        ImmutableArrayList arrayList = new ImmutableArrayList(elements);
        Object[] actualResult = arrayList.toArray();
        assertEquals(elements[0], actualResult[0]);
        assertEquals(elements[1], actualResult[1]);
        assertEquals(elements[2], actualResult[2]);
        int expSize = 3;
        int actualSize = arrayList.size();
        assertEquals(expSize, actualSize, 0.00001);
    }

//----------------------------------------------------------------------
    @Test
    public void testAdd() {
        Integer[] elements = {3, -5};
        ImmutableArrayList arrayList = new ImmutableArrayList(elements);
        Integer[] expResult = {3, -5, 1};
        arrayList = arrayList.add(1);
        Object[] actualResult = arrayList.toArray();
        assertEquals(expResult[0], actualResult[0]);
        assertEquals(expResult[1], actualResult[1]);
        assertEquals(expResult[2], actualResult[2]);
    }

    @Test
    public void testAddWithIndex() {
        Integer[] elements = {3, -5};
        ImmutableArrayList arrayList = new ImmutableArrayList(elements);
        Integer[] expResult = {3, 4, -5};
        arrayList = arrayList.add(1);
        arrayList = arrayList.add(1, 4);
        Object[] actualResult = arrayList.toArray();
        assertEquals(expResult[0], actualResult[0]);
        assertEquals(expResult[1], actualResult[1]);
        assertEquals(expResult[2], actualResult[2]);
    }

    @Test
    public void testAddAll() {
        Integer[] elements = {3};
        Integer[] newElements = {7, 9};
        ImmutableArrayList arrayList = new ImmutableArrayList(elements);
        Integer[] expResult = {3, 7, 9};
        arrayList = arrayList.addAll(newElements);
        Object[] actualResult = arrayList.toArray();
        assertEquals(expResult[0], actualResult[0]);
        assertEquals(expResult[1], actualResult[1]);
        assertEquals(expResult[2], actualResult[2]);
    }

    @Test
    public void testAddAllIndex() {
        Integer[] elements = {3, 4};
        Integer[] newElements = {7, 9};
        ImmutableArrayList arrayList = new ImmutableArrayList(elements);
        Integer[] expResult = {3, 7, 9, 4};
        arrayList = arrayList.addAll(1, newElements);
        Object[] actualResult = arrayList.toArray();
        assertEquals(expResult[0], actualResult[0]);
        assertEquals(expResult[1], actualResult[1]);
        assertEquals(expResult[2], actualResult[2]);
        assertEquals(expResult[3], actualResult[3]);
    }

//---------------------------------------------------------------------------------
    @Test
    public void testRemoveGet() {
        Integer[] elements = {3, 7, 9, 4};
        ImmutableArrayList arrayList = new ImmutableArrayList(elements);
        Integer[] expResult = {3, 7, 4};
        arrayList = arrayList.remove(2);
        assertEquals(expResult[0], arrayList.get(0));
        assertEquals(expResult[1], arrayList.get(1));
        assertEquals(expResult[2], arrayList.get(2));
    }

    @Test
    public void testSet() {
        Integer[] elements = {3, 7, 4};
        ImmutableArrayList arrayList = new ImmutableArrayList(elements);
        Integer[] expResult = {1, 2, 3};
        arrayList = arrayList.set(0, 1);
        arrayList = arrayList.set(1, 2);
        arrayList = arrayList.set(2, 3);
        assertEquals(expResult[0], arrayList.get(0));
        assertEquals(expResult[1], arrayList.get(1));
        assertEquals(expResult[2], arrayList.get(2));
    }

    @Test
    public void testIndexOf() {
        Integer[] elements = {3, 4};
        ImmutableArrayList arrayList = new ImmutableArrayList(elements);
        assertEquals(0, arrayList.indexOf(3));
        assertEquals(1, arrayList.indexOf(4));
        assertEquals(-1, arrayList.indexOf(0));
    }

//---------------------------------------------------------------------------------
    @Test
    public void testClear() {
        Integer[] elements = {3, 7, 9, 4};
        ImmutableArrayList arrayList = new ImmutableArrayList(elements);
        arrayList = arrayList.clear();
        Object[] array = arrayList.toArray();
        assertEquals(0, array.length);
        assertEquals(0, arrayList.size());
    }

    @Test
    public void testIsEmpty() {
        Integer[] elements = {3, 7, 9, 4};
        ImmutableArrayList emptyArrayList = new ImmutableArrayList();
        ImmutableArrayList arrayList = new ImmutableArrayList(elements);
        assertTrue(emptyArrayList.isEmpty());
        assertFalse(arrayList.isEmpty());
    }

    @Test
    public void testToString() {
        Integer[] elements = {3, 7, 9, 4};
        ImmutableArrayList arrayList = new ImmutableArrayList(elements);
        String expResult = "[3, 7, 9, 4]";
        String actualResult = arrayList.toString();
        assertEquals(expResult, actualResult);
    }

//---------------------------------------------------------------------------
    @Test(expected = IndexOutOfBoundsException.class)
    public void testIndexErrorAddLess() {
        Integer[] elements = {3, 7, 9, 4};
        ImmutableArrayList arrayList = new ImmutableArrayList(elements);
        arrayList.add(-1, 4);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testIndexErrorAddMore() {
        Integer[] elements = {3, 7, 9, 4};
        ImmutableArrayList arrayList = new ImmutableArrayList(elements);
        arrayList.add(arrayList.size() + 1, 5);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testIndexErrorRemoveLess() {
        Integer[] elements = {3, 7, 9, 4};
        ImmutableArrayList arrayList = new ImmutableArrayList(elements);
        arrayList.remove(-1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testIndexErrorRemoveMore() {
        Integer[] elements = {3, 7, 9, 4};
        ImmutableArrayList arrayList = new ImmutableArrayList(elements);
        arrayList.remove(arrayList.size());
    }

//---------------------------------------------------------------------------
    @Test
    public void testImmutable() {
        Integer[] elements = {3, 7, 9};
        ImmutableArrayList arrayList = new ImmutableArrayList(elements);
        arrayList.remove(2);
        arrayList.addAll(0, elements);
        arrayList.set(1, 5);

        assertEquals(elements[0], arrayList.get(0));
        assertEquals(elements[1], arrayList.get(1));
        assertEquals(elements[2], arrayList.get(2));
    }
}
