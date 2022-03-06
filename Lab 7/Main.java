import java.util.stream.Stream;
import java.util.stream.IntStream;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.Optional;

class Main {

    static boolean isPrime(int n) {

        return n > 1 && IntStream.range(2, (int) Math.sqrt(n) + 1)
            .noneMatch(x -> n % x == 0);
    }

    static long countTwinPrimes(int n) {

        IntStream i = IntStream.iterate(2, x -> x <= n, x -> x + 1)
            .filter(x -> isPrime(x));

        long totalTwinPrimes = i
            .filter(x -> isPrime(x + 2) || isPrime(x - 2))
            .count();

        return totalTwinPrimes;
    }

    static String reverse(String str) {

        int strLength = str.length();       

        return IntStream.range(0, strLength)
            .mapToObj(x -> str.charAt((strLength - 1) - x))
            .map(character -> String.valueOf(character))
            .collect(Collectors.joining(""));

    }

    static long countRepeats(int... array) {

        return IntStream.range(1,array.length - 1)
            .filter(index -> (array[index] == array[index + 1] 
                    && (array[index] != array[index - 1])) || (index == 1 && array[index] == array[index - 1]))
            .count();

    }

    static double normalizedMean(Stream<Integer> stream) {

        //System.out.println(stream.max((i,j) -> i.compareTo(j)));

        //System.out.println(stream.min((i,j) -> i.compareTo(j)));

        double[] doubleArray = stream.mapToDouble(x -> x).sorted().toArray();

        double max = DoubleStream.of(doubleArray).max().orElse(0.0);
        double min = DoubleStream.of(doubleArray).min().orElse(0.0);
        double sum = DoubleStream.of(doubleArray).sum();
        double average = DoubleStream.of(doubleArray).average().orElse(0.0);

        //System.out.println(max + " " + min + " " + sum + " " + average); 
        //DoubleSummaryStatistics stats = doubleStream.summaryStatistics();

        
        double answer = (average - min) / (max - min);

        return Optional.<Double>of(answer).filter(x -> !Double.isNaN(x)).orElse(0.0);
        //return 1.0;
    }
}
