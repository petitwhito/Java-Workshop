package fr.epita.assistants.seq;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * Extends the {@link Stream} interface, adding some very strangely lacking useful methods.
 * You should use the Forwarding-Interface pattern.
 * <p>
 * The use of infinite, unordered or parallel stream in this implementation will
 * not be tested.
 *
 * @param <ELEMENT_TYPE> the type of stream.
 */
@SuppressWarnings("unused")
public interface ExtendedStream<ELEMENT_TYPE> extends Stream<ELEMENT_TYPE> {


    /**
     * Creates a map out of the stream.
     * In case of duplicate keys, the latest element in the original stream will overwrite the one(s) in place.
     *
     * @param keyMapper  mapping function to extract map keys.
     * @param <KEY_TYPE> the expected type of key.
     * @return the created map.
     */
    <KEY_TYPE> Map<KEY_TYPE, ELEMENT_TYPE>
    toMap(final Function<ELEMENT_TYPE, KEY_TYPE> keyMapper);

    /**
     * Creates a map out of the stream.
     * In case of key duplicates, the latest element in the original stream will overwrite the one(s) in place.
     *
     * @param map          the map to fill/update.
     * @param keyMapper    mapping function to extract map keys.
     * @param valueMapper  mapping function to extract map values.
     * @param <KEY_TYPE>   the expected type of key.
     * @param <VALUE_TYPE> the expected type of value.
     * @param <MAP_TYPE>   the complete return type.
     * @return the created map.
     */
    <KEY_TYPE, VALUE_TYPE, MAP_TYPE extends Map<KEY_TYPE, VALUE_TYPE>>
    MAP_TYPE toMap(final MAP_TYPE map,
                   final Function<ELEMENT_TYPE, KEY_TYPE> keyMapper,
                   final Function<ELEMENT_TYPE, VALUE_TYPE> valueMapper);

    /**
     * Creates a map out of the stream.
     * In case of duplicate keys, the latest element in the original stream will overwrite the one(s) in place.
     *
     * @param keyMapper    mapping function to extract map keys.
     * @param valueMapper  mapping function to extract map values.
     * @param <KEY_TYPE>   the expected type of key.
     * @param <VALUE_TYPE> the expected type of value.
     * @return the created map.
     */
    <KEY_TYPE, VALUE_TYPE>
    Map<KEY_TYPE, VALUE_TYPE> toMap(final Function<ELEMENT_TYPE, KEY_TYPE> keyMapper,
                                    final Function<ELEMENT_TYPE, VALUE_TYPE> valueMapper);

    /**
     * Converts the stream to a list.
     *
     * @return the created list.
     */
    List<ELEMENT_TYPE> toList();

    /**
     * Dumps the content of the stream to the given list.
     *
     * @param list   the list to dump values to.
     * @param <LIST> the exact type of list.
     * @return the updated list.
     */
    <LIST extends List<ELEMENT_TYPE>> LIST toList(final LIST list);

    /**
     * Converts the stream to a set.
     *
     * @return the built set.
     */
    Set<ELEMENT_TYPE> toSet();

    /**
     * Dumps the content of the stream to the given set.
     *
     * @param set   the set to update
     * @param <SET> the set type.
     * @return the updated set.
     */
    <SET extends Set<ELEMENT_TYPE>> SET toSet(final SET set);

    /**
     * Creates a stream of pairs of the content of the stream and values produced by a supplier.
     *
     * @param supplier          the value supplier.
     * @param <ASSOCIATED_TYPE> the type of associated values.
     * @return the built stream.
     */
    <ASSOCIATED_TYPE>
    ExtendedStream<Pair<ELEMENT_TYPE, ASSOCIATED_TYPE>> associate(final Supplier<ASSOCIATED_TYPE> supplier);

    /**
     * Creates a stream of pairs of the content of the stream and values produces by another stream.
     * Once any of the two streams is closed, the produced stream is complete, regardless of potential values remaining
     * in the other stream.
     *
     * @param supplier          the value supplier.
     * @param <ASSOCIATED_TYPE> the type of associated values.
     * @return the built stream.
     */
    <ASSOCIATED_TYPE>
    ExtendedStream<Pair<ELEMENT_TYPE, ASSOCIATED_TYPE>> associate(final Stream<ASSOCIATED_TYPE> supplier);

    /**
     * Prints the element of the stream on the standard output.
     *
     * @return this.
     */
    ExtendedStream<ELEMENT_TYPE> print();

    /**
     * Adds the content of the given stream to the current stream and returns it as a new one.
     *
     * @param stream the stream to add.
     * @return a new stream containing the current one then the given one.
     */
    ExtendedStream<ELEMENT_TYPE> plus(final Stream<ELEMENT_TYPE> stream);

    /**
     * Builds a string by joining the string representation of all contained values, interspersed with the given string
     * delimiter.
     *
     * @param delimiter the delimiter string.
     * @return the built {@link String}.
     */
    String join(final String delimiter);

    /**
     * Builds a string by joining the string representation of all contained values.
     *
     * @return the built {@link String}.
     */
    String join();

    /**
     * Builds a pair of streams by partitioning the current one using the given pivot function.
     *
     * @param pivot      the function to segregate the values of the given stream.
     * @param <KEY_TYPE> type of partition key.
     * @return the pair of created streams.
     */
    <KEY_TYPE>
    ExtendedStream<Pair<KEY_TYPE, ExtendedStream<ELEMENT_TYPE>>>
    partition(final Function<ELEMENT_TYPE, KEY_TYPE> pivot);

    /**
     * A utility class representing a pair.
     *
     * @param <FIRST_TYPE>  the first value type.
     * @param <SECOND_TYPE> the second value type.
     */
    @SuppressWarnings("WeakerAccess")
    class Pair<FIRST_TYPE, SECOND_TYPE> {
        /**
         * The first value.
         */
        public final FIRST_TYPE first;

        /**
         * The second value.
         */
        public final SECOND_TYPE second;

        /**
         * Default CTor.
         *
         * @param first  value of the same name.
         * @param second value of the same name.
         */
        public Pair(final FIRST_TYPE first, final SECOND_TYPE second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public boolean equals(final Object obj) {
            if (obj == null) return false;
            if (!obj.getClass().equals(Pair.class)) return false;
            final Pair pair = (Pair) obj;
            return Objects.equals(first, pair.first) && Objects.equals(second, pair.second);
        }

        @Override
        public int hashCode() {
            return Objects.hash(first, second);
        }
    }
}
