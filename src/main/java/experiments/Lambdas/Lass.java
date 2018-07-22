package experiments.Lambdas;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;

public class Lass {

    public static void main(String[] args) {
        List <Track> tracks = asList(new Track("Track1", 46),
                new Track("Track2", 18),
                new Track("Track3", 56));

        List <Track> list1 = tracks.stream()
                .filter(track -> track.lenght >= 25)
                .collect(toList());

        list1.forEach(System.out::println);
        System.out.println();

        Track shortest = tracks.stream()
                .min(Comparator.comparing(Track::getLenght))
                .orElseGet(Track::new);

        System.out.println(shortest);
        System.out.println();

        int summ = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9)
                .reduce(0, (x, y) -> x + y);

        System.out.println(summ);
    }
}
