import exceptions.ArrayIsFullException;
import exceptions.ElementNotFoundException;
import exceptions.IncorrectIndexException;
import exceptions.NullItemException;

import java.util.Arrays;

import static java.lang.System.*;

public class StringListImpl implements StringList {
    public final String[] array;
    private int size = 0;

    public StringListImpl() {
        array = new String[5];
    }

    public StringListImpl(int desiredSize) {
        array = new String[desiredSize];
    }

    @Override
    public String add(String item) {
        validateSize();
        validateItem(item);
        array[size++] = item;
        return item;
    }

    @Override
    public String add(int index, String item) {
        validateSize();
        validateItem(item);
        validateIndex(index);
        if (index == size) {
            array[size++] = item;
            return item;
        }
        arraycopy(array, index, array, index + 1, size - index);
        array[index] = item;
        size++;
        return item;
    }

    @Override
    public String set(int index, String item) {
        validateIndex(index);
        validateItem(item);
        array[index] = item;
        return item;
    }

    @Override
    public String remove(String item) {
        validateItem(item);
        int index = indexOf(item);
        return remove(index);
    }

    @Override
    public String remove(int index) {
        validateIndex(index);
        String item = array[index];
        if (index != size) {
            System.arraycopy(array, index + 1, array, index, size - index);
            size--;
        }
        return item;
    }

    @Override
    public boolean contains(String item) {
        return indexOf(item) != -1;
    }

    @Override
    public int indexOf(String item) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        for (int i = size - 1; i >= 0; i--) {
            if (array[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String get(int index) {
        validateIndex(index);
        return array[index];
    }

    @Override
    public boolean equals(StringList otherList) {
        return Arrays.equals(this.toArray(), otherList.toArray());
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        size = 0;
    }

    @Override
    public String[] toArray() {
        return Arrays.copyOf(array, size);
    }

    private void validateItem(String item) {
        if (item == null) {
            throw new NullItemException("!!!");
        }
    }

    private void validateSize() {
        if (size == array.length) {
            throw new ArrayIsFullException("Нет больше места!!!");
        }
    }

    private void validateIndex(int index) {
        if (index < 0 || index > array.length) throw new IncorrectIndexException("Нет элемента с таким индексом!!!");
    }
}




