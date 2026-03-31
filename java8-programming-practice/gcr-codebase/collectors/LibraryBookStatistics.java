import java.util.*;
import java.util.stream.*;

public class LibraryBookStatistics {
    static class Book {
        String title;
        String genre;
        int pages;

        Book(String title,String genre,int pages){
            this.title=title;
            this.genre=genre;
            this.pages=pages;
        }

        String getGenre(){
            return genre;
        }

        int getPages(){
            return pages;
        }
    }

    public static void main(String[] args){

        List<Book> books=Arrays.asList(
                new Book("Clean Code","Programming",450),
                new Book("Effective Java","Programming",380),
                new Book("Harry Potter","Fantasy",520),
                new Book("Hobbit","Fantasy",310),
                new Book("Atomic Habits","SelfHelp",280)
        );

        Map<String,IntSummaryStatistics> statisticsByGenre=
                books.stream()
                        .collect(Collectors.groupingBy(
                                Book::getGenre,
                                Collectors.summarizingInt(Book::getPages)
                        ));
        statisticsByGenre.forEach((genre,stats)->{
            System.out.println(genre);
            System.out.println("total="+stats.getSum());
            System.out.println("average="+stats.getAverage());
            System.out.println("max="+stats.getMax());
        });
    }
}
