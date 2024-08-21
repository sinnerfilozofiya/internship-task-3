import java.util.List;
import java.util.Scanner;
import java.util.IntSummaryStatistics;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamApiTask {

    // ANSI escape codes for colors
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RESET = "\u001B[0m";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Kullanıcıdan başlangıç ve bitiş sayılarını al
        System.out.print("Başlangıç sayısını girin: ");
        int start = scanner.nextInt();

        System.out.print("Bitiş sayısını girin: ");
        int end = scanner.nextInt();

        // Belirtilen aralıkta sayılar oluştur
        List<Integer> numbers = IntStream.rangeClosed(start, end)
                                         .boxed()
                                         .collect(Collectors.toList());

        // 2 ve 4 ile bölünebilen sayıları filtrele ve sayısını al
        List<Integer> divisibleBy2And4 = numbers.stream()
                                                .filter(n -> n % 2 == 0 && n % 4 == 0)
                                                .collect(Collectors.toList());
        // System.out.println("2 ve 4 ile bölünebilen sayılar: " + ANSI_GREEN + divisibleBy2And4 + ANSI_RESET);
        System.out.println("2 ve 4 ile bölünebilen sayıların sayısı: " + ANSI_GREEN + divisibleBy2And4.size() + ANSI_RESET);

        // Tek sayıları filtrele ve sayısını ve toplamını al
        List<Integer> oddNumbers = numbers.stream()
                                          .filter(n -> n % 2 != 0)
                                          .collect(Collectors.toList());
        IntSummaryStatistics oddStats = oddNumbers.stream()
                                                  .mapToInt(Integer::intValue)
                                                  .summaryStatistics();
        // System.out.println("Tek sayılar: " + ANSI_GREEN + oddNumbers + ANSI_RESET);
        System.out.println("Tek sayıların sayısı: " + ANSI_GREEN + oddStats.getCount() + ANSI_RESET);
        System.out.println("Tek sayıların toplamı: " + ANSI_GREEN + oddStats.getSum() + ANSI_RESET);

        // Çift sayıları filtrele ve sayısını ve toplamını al
        List<Integer> evenNumbers = numbers.stream()
                                           .filter(n -> n % 2 == 0)
                                           .collect(Collectors.toList());
        IntSummaryStatistics evenStats = evenNumbers.stream()
                                                    .mapToInt(Integer::intValue)
                                                    .summaryStatistics();
        // System.out.println("Çift sayılar: " + ANSI_GREEN + evenNumbers + ANSI_RESET);
        System.out.println("Çift sayıların sayısı: " + ANSI_GREEN + evenStats.getCount() + ANSI_RESET);
        System.out.println("Çift sayıların toplamı: " + ANSI_GREEN + evenStats.getSum() + ANSI_RESET);
    }
}
