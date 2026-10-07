import java.util.List;

/**
 * Hello, World! в мире музыки.
 * Точка входа выводит приветствие и список любимых групп.
 */
public class HelloBands {
    public static void main(String[] args) {
        System.out.println("Hello, World! Это плейлист моей жизни 🎧");

        List<Band> favorites = List.of(
                new Band("Nirvana", "Grunge", 1987),
                new Band("Deftones", "Alternative Metal", 1988),
                new Band("Кишлак", "Пост-панк", 2018),
                new Band("Хаски", "Хип-хоп / Поэзия", 2013)
        );

        favorites.forEach(band -> System.out.println(" - " + band));
    }
}
