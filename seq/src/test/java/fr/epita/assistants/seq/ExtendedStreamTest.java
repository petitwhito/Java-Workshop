package fr.epita.assistants.seq;

import java.lang.reflect.Modifier;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;

import fr.epita.assistants.seq.ExtendedStream.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ExtendedStreamTest {

    private static <TYPE> ExtendedStream<TYPE> ctor(final List<TYPE> values) {
        // FIXME: replace by your own implementation.
        return Seq.of(values);
    }

    private static <TYPE> ExtendedStream<TYPE> ctor(final TYPE... values) {
        // FIXME: replace by your own implementation.
        return Seq.of(values);
    }

    private static <TYPE> ExtendedStream<TYPE> ctor(final Stream<TYPE> values) {
        // FIXME: replace by your own implementation.
        return Seq.of(values);
    }

    private static DummyObject dummy(final int id, final String name) {
        return new DummyObject(id, name);
    }

    @Test
    public void isSeqAnInterface() throws ClassNotFoundException {
        Class<?> seqClass = Class.forName("fr.epita.assistants.seq.Seq");
        int modifiers = seqClass.getModifiers();
        boolean isInterface = Modifier.isInterface(modifiers);
        assertTrue(isInterface, "Seq must be an interface");
    }

    @Test
    public void toMapKeyValue() {
        assertTimeoutPreemptively(Duration.ofSeconds(10), () -> {
            final ExtendedStream<DummyObject> es = ctor(dummy(1, "1"), dummy(2, "2"), dummy(2, "4"), dummy(3, "3"));
            final Map<Integer, String> map = es.toMap(DummyObject::getId, DummyObject::getName);
            assertEquals(3, map.size());
            assertEquals("1", map.get(1));
            assertEquals("4", map.get(2));
            assertEquals("3", map.get(3));
        });
    }

    @Test
    public void toMapKeyValueMap() {
        assertTimeoutPreemptively(Duration.ofSeconds(10), () -> {
            final ExtendedStream<DummyObject> es = ctor(dummy(1, "1"), dummy(2, "2"), dummy(2, "4"), dummy(3, "3"));
            final Map<Integer, DummyObject> source = new HashMap<>();
            source.put(42, new DummyObject(42, "me"));
            final Map<Integer, DummyObject> map = es.toMap(source, DummyObject::getId, it -> it);
            assertEquals(4, map.size());
            assertEquals("1", map.get(1).name);
            assertEquals("4", map.get(2).name);
            assertEquals("3", map.get(3).name);
            assertEquals("me", map.get(42).name);
        });
    }

    @Test
    public void toMapKey() {
        assertTimeoutPreemptively(Duration.ofSeconds(10), () -> {
            final ExtendedStream<DummyObject> es = ctor(dummy(1, "1"), dummy(2, "2"), dummy(2, "4"), dummy(3, "3"));
            final Map<Integer, DummyObject> map = es.toMap(DummyObject::getId);
            assertEquals(3, map.size());
            assertEquals("1", map.get(1).name);
            assertEquals("4", map.get(2).name);
            assertEquals("3", map.get(3).name);
        });
    }


    @Test
    public void toList() {
        assertTimeoutPreemptively(Duration.ofSeconds(10), () -> {
            final ExtendedStream<DummyObject> es = ctor(dummy(1, "1"), dummy(2, "2"), dummy(2, "4"), dummy(3, "3"));
            final List<DummyObject> list = es.toList();
            assertEquals(4, list.size());
            assertEquals("1", list.get(0).name);
            assertEquals("2", list.get(1).name);
            assertEquals("4", list.get(2).name);
            assertEquals("3", list.get(3).name);

        });
    }

    @Test
    public void toListWithList() {
        assertTimeoutPreemptively(Duration.ofSeconds(10), () -> {
            final ExtendedStream<DummyObject> es = ctor(dummy(1, "1"), dummy(2, "2"), dummy(2, "4"), dummy(3, "3"));
            final List<DummyObject> source = new ArrayList<>();
            source.add(new DummyObject(42, "me"));
            final List<DummyObject> list = es.toList(source);
            assertEquals(5, list.size());
            assertEquals("me", list.get(0).name);
            assertEquals("1", list.get(1).name);
            assertEquals("2", list.get(2).name);
            assertEquals("4", list.get(3).name);
            assertEquals("3", list.get(4).name);
        });
    }

    @Test
    public void toSet() {
        assertTimeoutPreemptively(Duration.ofSeconds(10), () -> {
            final ExtendedStream<Integer> es = ctor(1, 2, 2, 3);
            final Set<Integer> set = es.toSet();
            assertEquals(3, set.size());
            assertTrue(set.contains(1));
            assertTrue(set.contains(2));
            assertTrue(set.contains(3));
        });
    }

    @Test
    public void toSetWithSet() {
        assertTimeoutPreemptively(Duration.ofSeconds(10), () -> {
            final ExtendedStream<Integer> es = ctor(1, 2, 2, 3);
            final Set<Integer> source = new HashSet<>();
            source.add(1);
            source.add(2);
            source.add(42);
            final Set<Integer> set = es.toSet(source);
            assertEquals(4, set.size());
            assertTrue(set.contains(1));
            assertTrue(set.contains(2));
            assertTrue(set.contains(3));
            assertTrue(set.contains(42));
        });
    }

    @Test
    public void associateWithSupplier() {
        assertTimeoutPreemptively(Duration.ofSeconds(10), () -> {
            final ExtendedStream<String> es = ctor("a", "b", "c");
            final List<Pair<String, Integer>> list = es.associate(new Increment()).toList();

            assertEquals(3, list.size());
            assertEquals(new Pair<>("a", 0), list.get(0));
            assertEquals(new Pair<>("b", 1), list.get(1));
            assertEquals(new Pair<>("c", 2), list.get(2));


        });
    }

    @Test
    public void associateWithStream() {
        assertTimeoutPreemptively(Duration.ofSeconds(10), () -> {
            final ExtendedStream<String> es = ctor("a", "b", "c");
            final List<Pair<String, Integer>> list = es.associate(ctor(0, 1, 2, 3, 4, 5)).toList();

            assertEquals(3, list.size());
            assertEquals(new Pair<>("a", 0), list.get(0));
            assertEquals(new Pair<>("b", 1), list.get(1));
            assertEquals(new Pair<>("c", 2), list.get(2));
        });
    }

    @Test
    public void plus() {
        assertTimeoutPreemptively(Duration.ofSeconds(10), () -> {
            final ExtendedStream<String> es = ctor("a", "b", "c").plus(ctor("d", "e", "f"));
            assertEquals("abcdef", es.join());
        });
    }

    @Test
    public void join() {
        assertTimeoutPreemptively(Duration.ofSeconds(10), () -> {
            final ExtendedStream<String> es = ctor("a", "b", "c", "d", "e", "f");
            assertEquals("abcdef", es.join());
        });
    }

    @Test
    public void joinWithDelimiter() {
        assertTimeoutPreemptively(Duration.ofSeconds(10), () -> {
            final ExtendedStream<String> es = ctor("a", "b", "c", "d", "e", "f");
            assertEquals("a-b-c-d-e-f", es.join("-"));
        });
    }

    @Test
    public void partition() {
        assertTimeoutPreemptively(Duration.ofSeconds(10), () -> {
            final ExtendedStream<Integer> es = ctor(0, 1, 2, 3, 4, 5, 6, 7);
            final ExtendedStream<Pair<Boolean, ExtendedStream<Integer>>> partitions = es.partition(val -> val % 2 == 0);
            final List<Pair<Boolean, ExtendedStream<Integer>>> list = partitions.toList();


            assertEquals(list.get(0).first ? "0246" : "1357", list.get(0).second.join());
            assertEquals(list.get(0).first ? "1357" : "0246", list.get(1).second.join());
        });
    }

    static class DummyObject {
        public final Integer id;
        public final String name;

        public DummyObject(final Integer id, final String name) {
            this.id = id;
            this.name = name;
        }

        public Integer getId() {
            return id;
        }

        public String getName() {
            return name;
        }
    }


    static class Increment implements Supplier<Integer> {
        private int increment = 0;

        @Override
        public Integer get() {
            return increment++;
        }
    }
}
