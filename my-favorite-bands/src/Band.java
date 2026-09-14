/**
 * Простая модель музыкальной группы.
 */
public class Band {
    private final String name;
    private final String genre;
    private final int foundedYear;

    public Band(String name, String genre, int foundedYear) {
        this.name = name;
        this.genre = genre;
        this.foundedYear = foundedYear;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("%s — %s (с %d года)", name, genre, foundedYear);
    }
}
