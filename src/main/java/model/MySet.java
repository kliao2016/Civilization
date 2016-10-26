package model;
import java.util.Random;

class MySet<E> implements SimpleSet<E> {

    private E[] setArray;
    private static Random rand = new Random();

    public MySet() {
        setArray = (E[]) new Object[0];
    }

    public int findElement(E e) {
        int eIndex = 0;
        for (int i = 0; i < setArray.length; i++) {
            if (setArray[i].equals(e)) {
                eIndex = i;
            }
            if (setArray[i] == null && setArray[i] == e) {
                eIndex = i;
            }
        }
        return eIndex;
    }

    @Override
    public boolean add(E e) {
        if (contains(e)) {
            return false;
        }
        E[] result = (E[]) new Object[setArray.length + 1];
        if (setArray.length == 0) {
            result[0] = e;
            setArray = result;
            return true;
        } else {
            for (int i = 0; i < setArray.length; i++) {
                result[i] = setArray[i];
            }
            result[setArray.length] = e;
            setArray = result;
        }
        return true;
    }

    @Override
    public E remove(E e) throws ElementDoesNotExistException {
        E[] result = (E[]) new Object[setArray.length - 1];
        if (contains(e)) {
            if (setArray[0] != null && setArray[0].equals(e)) {
                for (int i = 1; i < setArray.length; i++) {
                    result[i - 1] = setArray[i];
                }
                setArray = result;
            }
            else if (setArray[setArray.length - 1] != null
                     && setArray[setArray.length - 1].equals(e)) {
                for (int i = 0; i < setArray.length - 1; i++) {
                    result[i] = setArray[i];
                    setArray = result;
                }
                setArray = result;
            } else if (setArray[0] == null && e == null) {
                for (int i = 1; i < setArray.length; i++) {
                    result[i - 1] = setArray[i];
                }
                setArray = result;
            } else if (setArray[setArray.length - 1] == null && e == null) {
                for (int i = 0; i < setArray.length - 1; i++) {
                    result[i] = setArray[i];
                    setArray = result;
                }
                setArray = result;
            } else {
                E temp = setArray[setArray.length - 1];
                setArray[setArray.length - 1] = e;
                setArray[findElement(e)] = temp;
                for (int i = 0; i < setArray.length - 1; i++) {
                    result[i] = setArray[i];
                    setArray = result;
                }
                setArray = result;
            }
            return e;
        } else {
            throw new ElementDoesNotExistException("Cannot be removed.");
        }
    }

    @Override
    public boolean contains(E e) {
        for (int i = 0; i < setArray.length; i++) {
            if (setArray[i] != null && setArray[i].equals(e)) {
                return true;
            }
            if (setArray[i] == null && e == null) {
                return true;
            }
        }
        return false;
    }

    @Override
    public E[] removeAll(E[] e) throws ElementDoesNotExistException {
        for (E element: e) {
            if (!contains(element)) {
                throw new ElementDoesNotExistException("Cannot be removed.");
            } else {
                remove(element);
            }
        }
        return e;
    }

    @Override
    public void clear() {
        E[] result = (E[]) new Object[0];
        setArray = result;
    }

    @Override
    public int size() {
        return setArray.length;
    }

    @Override
    public boolean isEmpty() {
        if (setArray.length > 0) {
            return false;
        }
        return true;
    }

    @Override
    public E getRandomElement() throws ElementDoesNotExistException {
        if (setArray.length == 0) {
            throw new ElementDoesNotExistException("No elements in the set.");
        }
        return setArray[rand.nextInt(setArray.length)];
    }

    @Override
    public E[] toArray() {
        return setArray;
    }

    @Override
    public String toString() {
        String result = "[ ";
        if (setArray.length == 0) {
            result = "[]";
        }
        for (int i = 0; i < setArray.length; i++) {
            if (setArray[i] == null && i != setArray.length - 1) {
                result += "null, ";
            } else if (setArray[i] == null && i == setArray.length - 1) {
                result += "null ]";
            } else if (i == setArray.length - 1 && setArray[i] != null) {
                result += setArray[i].toString() + " ]";
            } else if (i != setArray.length - 1 && setArray[i] != null) {
                result += setArray[i].toString() + ", ";
            }
        }
        return result;
    }
}