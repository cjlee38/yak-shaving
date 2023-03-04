package io.github.cjlee38.collections;

public interface List<E> {
    int size();
    boolean isEmpty();
    boolean contains(Object o);
    boolean add(E element);
    boolean add(int index, E element);

    int indexOf(Object o);
    E get(int index);

    E set(int index, E element);
    E remove(int index);

    boolean remove(Object o);
    void clear();
}
