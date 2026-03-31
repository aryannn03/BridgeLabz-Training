import java.util.*;
import java.util.stream.*;

class Movie{
    String name;
    double rating;
    int year;
    Movie(String name,double rating,int year){
        this.name=name;
        this.rating=rating;
        this.year=year;
    }
}

public class TopTrendingMovies{
    public static void main(String[] args){
        List<Movie> movies=Arrays.asList(
            new Movie("MovieA",4.5,2024),
            new Movie("MovieB",4.8,2025),
            new Movie("MovieC",4.2,2023),
            new Movie("MovieD",4.9,2025),
            new Movie("MovieE",4.7,2024),
            new Movie("MovieF",4.6,2025)
        );

        movies.stream()
            .filter(m->m.year>=2023)
            .sorted((a,b)->{
                if(b.rating!=a.rating)
                    return Double.compare(b.rating,a.rating);
                return Integer.compare(b.year,a.year);
            })
            .limit(5)
            .forEach(m->System.out.println(m.name+" "+m.rating+" "+m.year));
    }
}
