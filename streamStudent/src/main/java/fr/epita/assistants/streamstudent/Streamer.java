package fr.epita.assistants.streamstudent;

import org.apache.commons.lang3.ObjectUtils;

import java.util.Optional;
import java.util.stream.Stream;

import static java.lang.Double.NaN;

public class Streamer {

    private boolean goodgrade(Integer grade) {
        return grade >= 0 && grade <= 100;
    }
    private boolean goodlogin(String login) {
        boolean a = login.chars().filter(ch -> ch == '_').count() == 1;
        boolean b = login.chars().filter(ch -> ch == '.').count() == 1;
        return a ^ b;
    }
    public Stream<Pair<Integer, String>> validator(Stream<Pair<Integer, String>> stream) {
        return stream.filter(pair -> goodgrade(pair.getKey()) && goodlogin(pair.getValue()));
    }

    public Stream<Pair<Integer, String>> orderGrade(Stream<Pair<Integer, String>> stream) {
        return stream.sorted((a, b) -> {
                    int temp = Integer.compare(a.getKey(), b.getKey());
                    String a_temp = a.getValue();
                    return (temp != 0) ? temp : a_temp.compareTo(b.getValue());
                });
    }

    public Stream<Pair<Integer, String>> lowercase(Stream<Pair<Integer, String>> stream) {
        return stream.map(a -> {
                    int temp = a.getKey();
                    if (a.getValue().matches(".*[A-Z]+.*"))
                        temp /= 2;
                    return new Pair<>(temp, a.getValue().toLowerCase());
                });
    }

    public Optional<Pair<Integer, String>> headOfTheClass(Stream<Pair<Integer, String>> stream) {
        return stream.max((a, b) -> {
                    int temp = Integer.compare(a.getKey(), b.getKey());
                    String temp_b = b.getValue();
                    return (temp != 0) ? temp : temp_b.compareTo(a.getValue());
                });
    }

    public Stream<Pair<Integer, String>> quickFix(Stream<Pair<Integer, String>> stream) {
        return stream.map(a -> {
                    String temp = a.getValue().toLowerCase();
                    boolean d = temp.startsWith("ma");
                    boolean b = temp.startsWith("l");
                    boolean c = temp.endsWith("x");
                    if (d || (b && c) )
                        return new Pair<>(Math.min(a.getKey() * 2, 100), a.getValue());
                    return a;
        });
    }

    private String split_inverse_merge(Pair<Integer, String> a)
    {
        String temp = a.getValue();
        int len = temp.length();
        int splitIndex = len / 2;

        String firstHalf = temp.substring(0, splitIndex);
        String secondHalf = temp.substring(splitIndex);
        return secondHalf + firstHalf;
    }

    public Stream<Pair<Integer, String>> encryption(Stream<Pair<Integer, String>> stream) {
        return stream.map(a -> {
                    String res = split_inverse_merge(a);
                    return new Pair<>(a.getKey(), res);
                });
    }

}
