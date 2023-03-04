package io.github.cjlee38.collections.list;


import io.github.cjlee38.collections.List;
import java.util.Objects;

public class LinkedList<E> implements List<E> {

    private Node<E> head;
    private Node<E> tail;
    private int size;

    public LinkedList() {
        size = 0;
    }

    static class Node<E> {
        private E value;
        private Node<E> prev;
        private Node<E> next;

        public Node(E value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Node<?> node = (Node<?>) o;
            return Objects.equals(value, node.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(value);
        }
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
    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }

    @Override
    public boolean add(E element) {
        return add(size, element);
    }

    @Override
    public boolean add(int index, E element) {
        validateIndex(index);
        Node<E> newNode = new Node<>(element);

        if (size == 0) {
            head = tail = newNode;
            size++;
            return true;
        }
        if (index == size) {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        } else {
            Node<E> cur = find(index);
            if (index == 0) {
                head = newNode;
            } else {
                cur.prev.next = newNode;
            }
            cur.prev = newNode;
            newNode.next = cur;
        }
        size++;
        return true;
    }

    @Override
    public int indexOf(Object o) {
        int index = 0;
        Node<E> cur = head;
        if (o == null) {
            while (cur != null) {
                if (cur.value == null) {
                    return index;
                }
                index++;
                cur = cur.next;
            }
        } else {
            while (cur != null) {
                if (cur.value.equals(o)) {
                    return index;
                }
                index++;
                cur = cur.next;
            }
        }
        return -1;
    }

    @Override
    public E get(int index) {
        return find(index).value;
    }

    @Override
    public E set(int index, E element) {
        find(index).value = element;
        return element;
    }

    @Override
    public E remove(int index) {
        validateIndex(index);
        Node<E> cur = find(index);
        unlink(cur);
        return cur.value;
    }

    private void unlink(Node<E> cur) {
        cur.value = null;
        size--;
        if (cur == head && cur == tail) {
            head = null;
            tail = null;
        } else if (cur == head) {
            head = cur.next;
            cur.next.prev = null;
            cur.next = null;
        } else if (cur == tail) {
            tail = cur.prev;
            cur.prev.next = null;
            cur.prev = null;
        } else {
            cur.prev.next = cur.next;
            cur.next.prev = cur.prev;
        }
    }

    @Override
    public boolean remove(Object o) {
        Node<E> cur = head;
        if (o == null) {
            while (cur != null) {
                if (cur.value == null) {
                    unlink(cur);
                    return true;
                }
                cur = cur.next;
            }
        } else {
            while (cur != null) {
                if (cur.value.equals(o)) {
                    unlink(cur);
                    return true;
                }
                cur = cur.next;
            }
        }
        return false;
    }

    @Override
    public void clear() {
        Node<E> cur = head;
        while (cur != null) {
            Node<E> tmp = cur.next;
            unlink(cur);
            cur = tmp;
        }
    }

    private Node<E> find(int index) {
        validateIndex(index);

        Node<E> cur;
        cur = head;
        while (index-- > 0) {
            cur = cur.next;
        }
//        if (index <= size / 2) {
//            cur = head;
//            while (index-- > 0) {
//                cur = cur.next;
//            }
//        } else {
//            cur = tail;
//            int iter = size - index;
//            while (iter-- > 0) {
//                cur = cur.prev;
//            }
//        }
        return cur;
    }

    private void validateIndex(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Index out of range : " + index);
        }
    }
}
