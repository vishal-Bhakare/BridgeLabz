package bridgelabzjava8features;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BookMain {

    public static void main(String[] args) {

        List<Book> list = new ArrayList<>();

        list.add(new Book("Strength of Materials", "R.K. Bansal", "Mechanical Engineering", 4.8));
        list.add(new Book("Engineering Mechanics", "S.S. Bhavikatti", "Civil Engineering", 4.5));
        list.add(new Book("Theory of Machines", "S.S. Rattan", "Electrical Engineering", 4.7));
        list.add(new Book("Heat and Mass Transfer", "R.K. Rajput", "Mechanical Engineering", 4.6));
        list.add(new Book("Fluid Mechanics", "R.K. Bansal", "Mechanical Engineering", 4.3));
        list.add(new Book("Mechanical Vibrations", "G.K. Grover", "CSE Engineering", 4.4));
        list.add(new Book("Automobile Engineering", "Kirpal Singh", "Mechanical Engineering", 4.2));
        list.add(new Book("Basic and Applied Thermodynamics", "P.K. Nag", "IT Engineering", 4.1));
        list.add(new Book("Industrial Engineering and Production Management", "Martand Telsang", "Mechanical Engineering", 4.0));
        list.add(new Book("A Textbook of Fluid Mechanics", "Dr. R.K. Bansal", "AI Engineering", 4.5));

        findBooks(list);

    }

    public static void findBooks(List<Book> books) {


        //Filter books by genre "Mechanical Engineering" and rating > 4.0

        List<Book> mechanicalEngineering = books.stream().filter(gen -> gen.getGenre().equalsIgnoreCase("Mechanical Engineering") && gen.getRating() > 4.0)
                .collect(Collectors.toList());
        mechanicalEngineering.forEach(r -> System.out.println(r));

        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        //Create list of bookreccomdation
        List<BookRecommendation> listBook = mechanicalEngineering.stream().map(book -> new BookRecommendation(book.getTitle(), book.getRating())).collect(Collectors.toList());

        // Sort BookRecommendation by rating in descending order and limit 5
        List<BookRecommendation> limit = listBook.stream().sorted(Comparator.comparingDouble(BookRecommendation::getRating).reversed()).limit(10).collect(Collectors.toList());
        limit.forEach(e-> System.out.println(e));
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------");

        int pageSize = 5;
        List<List<BookRecommendation>> paginatedResult = new ArrayList<>();
        for (int i = 0; i < limit.size(); i += pageSize) {
            paginatedResult.add(limit.subList(i, Math.min(i + pageSize, limit.size())));
        }

        // Display paginated result
        for (int i = 0; i < paginatedResult.size(); i++) {
            System.out.println("Page " + (i + 1) + ":");
            paginatedResult.get(i).forEach(System.out::println);
            System.out.println("---------------------------------------------------");
        }
    }
    }

