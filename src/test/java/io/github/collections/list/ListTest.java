package io.github.collections.list;


import static org.assertj.core.api.Assertions.assertThat;

import io.github.cjlee38.collections.List;
import io.github.cjlee38.collections.list.LinkedList;
//import java.util.LinkedList;
//import java.util.List;
import org.junit.jupiter.api.Test;

class ListTest {

    @Test
    void add() {
        // given
        List<String> list = new LinkedList<>();
        // when
        list.add("hello world");
        // then
        assertThat(list.size()).isEqualTo(1);
    }

    @Test
    void add2() {
        // given
        List<Integer> list = new LinkedList<>();
        // when
        list.add(0);
        list.add(1);
        list.add(2);
        // then
        assertThat(list.size()).isEqualTo(3);
    }

    @Test
    void add3() {
        // given
        List<Integer> list = new LinkedList<>();
        list.add(0);
        list.add(1);
        list.add(2);
        // when
        list.add(1, 100);
        // then
        assertThat(list.size()).isEqualTo(4);
        assertThat(list.get(1)).isEqualTo(100);
    }

    @Test
    void add4() {
        // given
        List<Integer> list = new LinkedList<>();
        list.add(0);
        list.add(1);
        list.add(2);
        // when
        list.add(0, 100);
        // then
        assertThat(list.size()).isEqualTo(4);
        assertThat(list.get(0)).isEqualTo(100);
    }

    @Test
    void add5() {
        // given
        List<Integer> list = new LinkedList<>();
        list.add(0);
        list.add(1);
        list.add(2);
        // when
        list.add(3, 100);
        // then
        assertThat(list.size()).isEqualTo(4);
        assertThat(list.get(3)).isEqualTo(100);
    }

    @Test
    void indexOf() {
        // given
        List<Integer> list = new LinkedList<>();
        list.add(0);
        list.add(1);
        list.add(2);
        // when
        int index = list.indexOf(2);
        // then
        assertThat(index).isEqualTo(2);
    }
    
    @Test
    void indexOfNull() {
        // given
        List<Integer> list = new LinkedList<>();
        list.add(0);
        list.add(null);
        list.add(2);
        // when
        int index = list.indexOf(null);
        // then
        assertThat(index).isEqualTo(1);
    }

    @Test
    void get() {
        // given
        List<Integer> list = new LinkedList<>();
        list.add(0);
        list.add(1);
        list.add(2);

        // when
        Integer expected = list.get(1);

        // then
        assertThat(expected).isEqualTo(1);
    }

    @Test
    void set() {
        // given
        List<Integer> list = new LinkedList<>();
        list.add(0);
        list.add(1);
        list.add(2);
        // when

        list.set(1, 100);

        // then
        assertThat(list.get(1)).isEqualTo(100);
    }
}
