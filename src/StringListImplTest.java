import exceptions.ArrayIsFullException;
import exceptions.IncorrectIndexException;
import exceptions.NullItemException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringListImplTest {

    private final StringListImpl underTest = new StringListImpl();

    StringListImpl otherList = new StringListImpl();
    String string1 = "AAAAA";
    String string2 = "BBBBB";
    String string3 = "CCCCC";
    String string4 = "DDDDD";
    String string5 = "EEEEE";
    String string6 = "FFFFF";


    @Test
    void add_shouldAddStringToArrayAndReturnString() {
        underTest.add(string1);
        assertEquals(underTest.get(0), string1);
    }

    @Test
    void add_shouldThrowArrayIsFullExceptionWhenSizeIsFull() {
        underTest.add(string1);
        underTest.add(string2);
        underTest.add(string3);
        underTest.add(string4);
        underTest.add(string5);
        assertThrows(ArrayIsFullException.class, () -> underTest.add(string6));
    }


    @Test
    void AddWithIndex_shouldAddStringWithIndexAndReturnString() {
        String expectedString = "ZZZZZ";
        underTest.add(4, expectedString);
        assertEquals(expectedString, underTest.get(4));
    }

    @Test
    void AddWithIndex_shouldThrowArrayIsFullExceptionWhenSizeIsFull() {
        underTest.add(string1);
        underTest.add(string2);
        underTest.add(string3);
        underTest.add(string4);
        underTest.add(string5);
        assertThrows(ArrayIsFullException.class, () -> underTest.add(5, string6));
    }

    @Test
    void AddWithIndex_shouldThrowNullItemException() {
        assertThrows(NullItemException.class, () -> underTest.add(1, null));
    }

    @Test
    void set_shouldSetStringInArray() {
        underTest.add(string1);
        underTest.add(string2);
        underTest.add(string3);
        underTest.add(string4);
        underTest.add(string5);
        String expectedResult = "ZZZZZ";
        underTest.set(1, expectedResult);
        assertEquals(expectedResult, underTest.get(1));
    }

    @Test
    void set_shouldThrowIncorrectIndexExceptionWhenIndexIsBiggerThatSizeOfArray() {
        assertThrows(IncorrectIndexException.class, () -> underTest.set(6, "ZZZZZ"));
    }

    @Test
    void removeByItem_shouldReturnItemAfterRemove() {
        underTest.add(string1);
        String expectedResult = "AAAAA";
        assertEquals(expectedResult, underTest.remove(string1));
    }

    @Test
    void testRemoveByIndex_shouldReturnItemAfterRemove() {
        underTest.add(string1);
        String expectedResult = "AAAAA";
        assertEquals(expectedResult, underTest.remove(0));
    }


    @Test
    void contains_shouldReturnTrueWhenArrayContainsElement() {
        underTest.add(string1);
        assertTrue(underTest.contains("AAAAA"));
    }

    @Test
    void contains_shouldReturnFalseWhenArrayContainsElement() {
        underTest.add(string1);
        assertFalse(underTest.contains("BBBBB"));
    }


    @Test
    void indexOf_shouldReturnMinusOneWhenElementAreNotInArray() {
        int expectedResult = -1;
        assertEquals(expectedResult, underTest.indexOf("AAAAA"));
    }

    @Test
    void indexOf_shouldReturnIndexWhenElementAreInArray() {
        underTest.add(string1);
        int expectedResult = 0;
        assertEquals(expectedResult, underTest.indexOf("AAAAA"));
    }

    @Test
    void lastIndexOf_shouldReturnMinusOneWhenElementAreNotInArray() {
        int expectedResult = -1;
        assertEquals(expectedResult, underTest.lastIndexOf("AAAAA"));
    }

    @Test
    void lastIndexOf_shouldReturnIndexWhenElementAreInArray() {
        underTest.add(string1);
        int expectedResult = 0;
        assertEquals(expectedResult, underTest.indexOf("AAAAA"));
    }

    @Test
    void get_shouldThrowIncorrectIndexExceptoinWhenWrongIndexInjected() {
        assertThrows(IncorrectIndexException.class, () -> underTest.get(6));
    }

    @Test
    void get_shouldReturnElementWhenIndexIsCorrect() {
        underTest.add(string1);
        underTest.add(string2);
        String expectedResult = "AAAAA";
        assertEquals(expectedResult, underTest.get(0));
    }

    @Test
    void testEquals_shouldReturnTrueWhenOtherlistContainsUndertest() {
        underTest.add(string1);
        underTest.add(string2);
        otherList.add(string1);
        otherList.add(string2);

        boolean expectedResult = otherList.equals(underTest);
        assertEquals(expectedResult, true);
    }

    @Test
    void testEquals_shouldReturnFalseWhenOtherlistNotContainsUndertest() {
        underTest.add(string4);
        underTest.add(string3);
        otherList.add(string1);
        otherList.add(string2);

        boolean expectedResult = otherList.equals(underTest);
        assertEquals(expectedResult, false);
    }


    @Test
    void size_shouldReturnTwoWhenAreTwoElementInArray() {
        underTest.add(string1);
        underTest.add(string2);
        int expectedResult = 2;
        assertEquals(expectedResult, underTest.size());
    }

    @Test
    void isEmpty_returnTrueWhenArrayIsEmpty() {
        assertTrue(underTest.isEmpty());
    }

    @Test
    void isEmpty_returnFalseWhenArrayIsNotEmpty() {
        underTest.add(string1);
        assertFalse(underTest.isEmpty());
    }

    @Test
    void clear_shouldReturnNullWhenArrayAreCleared() {
        underTest.add(string1);
        underTest.add(string2);
        int expectedResult = 0;
        underTest.clear();
        assertEquals(expectedResult, underTest.size());
    }

    @Test
    void toArray_shouldReturnRightSizeOfArraysWithoutNull() {

        underTest.add(string1);
        underTest.add(string2);

        underTest.toArray();
        assertEquals(2, underTest.size());

    }
}