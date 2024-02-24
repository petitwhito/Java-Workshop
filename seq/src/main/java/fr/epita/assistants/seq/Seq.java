package fr.epita.assistants.seq;

import java.util.*;

import java.util.function.*;
import java.util.stream.*;

public interface Seq<T> extends ExtendedStream<T> {

    class innerclass<T> implements Seq<T>
    {
        private Stream<T> real;

        public innerclass(Stream real) {
            this.real = real;
        }

        @Override
        public <KEY_TYPE> Map<KEY_TYPE, T> toMap(Function<T, KEY_TYPE> keyMapper) {
            Map<KEY_TYPE, T> map = new HashMap<>();
            real.forEach(s -> map.put(keyMapper.apply(s), s));
            return map;
        }

        @Override
        public <KEY_TYPE, VALUE_TYPE, MAP_TYPE extends Map<KEY_TYPE, VALUE_TYPE>> MAP_TYPE toMap(MAP_TYPE map, Function<T, KEY_TYPE> keyMapper, Function<T, VALUE_TYPE> valueMapper) {
            real.forEach(s -> map.put(keyMapper.apply(s), valueMapper.apply(s)));
            return map;
        }

        @Override
        public <KEY_TYPE, VALUE_TYPE> Map<KEY_TYPE, VALUE_TYPE> toMap(Function<T, KEY_TYPE> keyMapper, Function<T, VALUE_TYPE> valueMapper) {
            Map<KEY_TYPE, VALUE_TYPE> map = new HashMap<>();
            real.forEach(s -> map.put(keyMapper.apply(s), valueMapper.apply(s)));
            return map;
        }

        @Override
        public Stream<T> filter(Predicate<? super T> predicate) {
            return real.filter(predicate);
        }

        @Override
        public <R> Stream<R> map(Function<? super T, ? extends R> mapper) {
            return real.map(mapper);
        }

        @Override
        public IntStream mapToInt(ToIntFunction<? super T> mapper) {
            return real.mapToInt(mapper);
        }

        @Override
        public LongStream mapToLong(ToLongFunction<? super T> mapper) {
            return real.mapToLong(mapper);
        }

        @Override
        public DoubleStream mapToDouble(ToDoubleFunction<? super T> mapper) {
            return real.mapToDouble(mapper);
        }

        @Override
        public <R> Stream<R> flatMap(Function<? super T, ? extends Stream<? extends R>> mapper) {
            return real.flatMap(mapper);
        }

        @Override
        public IntStream flatMapToInt(Function<? super T, ? extends IntStream> mapper) {
            return real.flatMapToInt(mapper);
        }

        @Override
        public LongStream flatMapToLong(Function<? super T, ? extends LongStream> mapper) {
            return real.flatMapToLong(mapper);
        }

        @Override
        public DoubleStream flatMapToDouble(Function<? super T, ? extends DoubleStream> mapper) {
            return real.flatMapToDouble(mapper);
        }

        @Override
        public Stream<T> distinct() {
            return real.distinct();
        }

        @Override
        public Stream<T> sorted() {
            return real.sorted();
        }

        @Override
        public Stream<T> sorted(Comparator<? super T> comparator) {
            return real.sorted(comparator);
        }

        @Override
        public Stream<T> peek(Consumer<? super T> action) {
            return real.peek(action);
        }

        @Override
        public Stream<T> limit(long maxSize) {
            return real.limit(maxSize);
        }

        @Override
        public Stream<T> skip(long n) {
            return real.skip(n);
        }

        @Override
        public void forEach(Consumer<? super T> action) {
            real.forEach(action);
        }

        @Override
        public void forEachOrdered(Consumer<? super T> action) {
            real.forEachOrdered(action);
        }

        @Override
        public Object[] toArray() {
            return real.toArray();
        }

        @Override
        public <A> A[] toArray(IntFunction<A[]> generator) {
            return real.toArray(generator);
        }

        @Override
        public T reduce(T identity, BinaryOperator<T> accumulator) {
            return real.reduce(identity, accumulator);
        }

        @Override
        public Optional<T> reduce(BinaryOperator<T> accumulator) {
            return real.reduce(accumulator);
        }

        @Override
        public <U> U reduce(U identity, BiFunction<U, ? super T, U> accumulator, BinaryOperator<U> combiner) {
            return real.reduce(identity, accumulator, combiner);
        }

        @Override
        public <R> R collect(Supplier<R> supplier, BiConsumer<R, ? super T> accumulator, BiConsumer<R, R> combiner) {
            return real.collect(supplier, accumulator, combiner);
        }

        @Override
        public <R, A> R collect(Collector<? super T, A, R> collector) {
            return real.collect(collector);
        }

        @Override
        public List<T> toList() {
            return real.toList();
        }

        @Override
        public Optional<T> min(Comparator<? super T> comparator) {
            return real.min(comparator);
        }

        @Override
        public Optional<T> max(Comparator<? super T> comparator) {
            return real.max(comparator);
        }

        @Override
        public long count() {
            return real.count();
        }

        @Override
        public boolean anyMatch(Predicate<? super T> predicate) {
            return real.anyMatch(predicate);
        }

        @Override
        public boolean allMatch(Predicate<? super T> predicate) {
            return real.allMatch(predicate);
        }

        @Override
        public boolean noneMatch(Predicate<? super T> predicate) {
            return real.noneMatch(predicate);
        }

        @Override
        public Optional<T> findFirst() {
            return real.findFirst();
        }

        @Override
        public Optional<T> findAny() {
            return real.findAny();
        }

        @Override
        public <LIST extends List<T>> LIST toList(LIST list) {
            list.addAll(real.toList());
            return list;
        }

        @Override
        public Set<T> toSet() {
            Set<T> set = real.collect(Collectors.toSet());
            return set;
        }

        @Override
        public <SET extends Set<T>> SET toSet(SET set) {
            real.forEach(set::add);
            return set;
        }

        @Override
        public <ASSOCIATED_TYPE> ExtendedStream<Pair<T, ASSOCIATED_TYPE>> associate(Supplier<ASSOCIATED_TYPE> supplier) {
            Stream<Pair<T, ASSOCIATED_TYPE>> temp = real.map(i -> new Pair<T, ASSOCIATED_TYPE>(i, supplier.get()));
            return new innerclass<>(temp);
        }

        @Override
        public <ASSOCIATED_TYPE> ExtendedStream<Pair<T, ASSOCIATED_TYPE>> associate(Stream<ASSOCIATED_TYPE> supplier) {
            Iterator<ASSOCIATED_TYPE> supplierIterator = supplier.iterator();
            Stream<Pair<T, ASSOCIATED_TYPE>> temp = real.filter(i -> supplierIterator.hasNext())
                    .map(i -> new Pair<>(i, supplierIterator.next()));

            return new innerclass<>(temp);

        }

        @Override
        public ExtendedStream<T> print() {
            real.forEach(s -> System.out.println(s));
            return this;
        }

        @Override
        public ExtendedStream<T> plus(Stream<T> stream) {
            return new innerclass<>(Stream.of(real, stream).flatMap(x -> x));
        }

        @Override
        public String join(String delimiter) {
            List<Character> str = (List<Character>) real.toList();
            String res = "";
            for (int i = 0; i < str.size(); i++)
            {
                res += str.get(i);
                if (i + 1 != str.size())
                    res+=delimiter;
            }
            return res;
        }

        @Override
        public String join() {
            List<Character> str = (List<Character>) real.toList();
            return str.toString().substring(1, 3 * str.size() - 1)
                    .replaceAll(", ", "");
        }

        @Override
        public <KEY_TYPE> ExtendedStream<Pair<KEY_TYPE, ExtendedStream<T>>> partition(Function<T, KEY_TYPE> pivot) {
            Map<KEY_TYPE, List<T>> partitionedMap = real.collect(Collectors.groupingBy(pivot));
            Stream<Pair<KEY_TYPE, ExtendedStream<T>>> partitionedStream = partitionedMap.entrySet().stream()
                    .map(entry -> new Pair<>(entry.getKey(), of(entry.getValue())));
            return new innerclass<>(partitionedStream);
        }

        @Override
        public Iterator<T> iterator() {
            return real.iterator();
        }

        @Override
        public Spliterator<T> spliterator() {
            return real.spliterator();
        }

        @Override
        public boolean isParallel() {
            return real.isParallel();
        }

        @Override
        public Stream<T> sequential() {
            return real.sequential();
        }

        @Override
        public Stream<T> parallel() {
            return real.parallel();
        }

        @Override
        public Stream<T> unordered() {
            return real.unordered();
        }

        @Override
        public Stream<T> onClose(Runnable closeHandler) {
            return real.onClose(closeHandler);
        }

        @Override
        public void close() {
            real.close();
        }
    }

    static <TYPE> Seq<TYPE> of(final List<TYPE> values) {
        return new innerclass(values.stream());
    }

    static <TYPE> Seq<TYPE> of(final TYPE... values) {
        return new innerclass(Arrays.stream(values));
    }

    static <TYPE> Seq<TYPE> of(final Stream<TYPE> values) {
        return new innerclass(values);
    }

}