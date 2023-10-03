import exceptions.IncorrectIndexException;

import java.util.Arrays;

public class StringListImpl implements StringList {
    private final String[] array = new String[5];
    private int pointer = 0;

    public StringListImpl() {

    }

    public String add(String item) {
        String[] result = Arrays.copyOf(array, array.length + 1);
        array[pointer++] = item;
        return array[pointer];
    }

    public String add(int index, String item) {
        if (index > pointer) {
            throw new IncorrectIndexException("Нет элемента с таким индексом!!!");
        }
        String[] result = new String[array.length + 1];
        for (int i = 0; i < index; i++) {
                result[i] = array[i];
            }
                result[index] = item;

        for (int i = index + 1; i <= array.length; i++) {
                result[i] = array[i - 1];
            }
        pointer++;
        return array[index];
    }

    public void set(int index, String item) {
        if (index > pointer) {
            throw new IncorrectIndexException("Нет элемента с таким индексом!!!");
        }
        array[index] = item;
    }

    public String remove(String item) {
        String[] result = new String[array.length];
        for (int i = 0, j = 0; i < array.length; j++, i++) {
            if ((array[i].equals(item))) {
                return array[i];
                i++;
               // result[j] = array[i];
            } else {
                throw new IncorrectIndexException("Подобный элемент отсутствует в списке!!!");
            }
            result[j] = array[i];
        }
        pointer--;
        return null;
    }

    public String remove(int index) {
        if (index > pointer) {
            throw new IncorrectIndexException("Нет элемента с таким индексом!!!");
        }
        String[] result = new String[array.length];
        if (index >= 0) System.arraycopy(array, 0, result, 0, index);
        if (array.length + 1 - index >= 0) System.arraycopy(array, index - 1,
                result, index, array.length + 1 - index);
        pointer--;
        return result[index];

    }

    public boolean contains(String item) {
        boolean result = false;
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(item)) {
                result = true;
                break;
            }
        }
        return result;
    }

    public int indexOf(String item) {
        int result = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(item)) {
                result = i;
            } else {
                result = -1;
            }
        }
        return result;
    }

    public int lastIndexOf(String item) {
        int result = 0;
        for (int i = array.length; i > 0; i--) {
            if (array[i].equals(item)) {
                result = i;
            } else {
                result = -1;
            }
        }
        return result;
    }

    public String get(int index) {
        if (index > pointer) {
            throw new IncorrectIndexException("Нет элемента с таким индексом!!!");
        }
        return array[index];
    }

    public boolean equals(StringListImpl otherList) {
        if (otherList.isEmpty()) {
            throw new IncorrectIndexException("Кого-то пытаются надуть!!!");
        }
        return Arrays.equals(otherList.toArray(), array);
    }

    public int size() {
        return pointer;
    }


    public boolean isEmpty() {
        if (pointer == 0) {
            return true;
        } else {
            return false;
        }
    }

    public void clear() {
        for (int i = 0; i < array.length; i++) {
            array[i] = null;
            pointer--;
        }
    }

    public String[] toArray() {
        return array;
    }
}



