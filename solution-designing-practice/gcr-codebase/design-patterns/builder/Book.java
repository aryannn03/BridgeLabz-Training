public class Book {
    private String title;
    private String author;
    private String edition;

    private Book(BookBuilder builder) {
        this.title = builder.title;
        this.author = builder.author;
        this.edition = builder.edition;
    }

    public static class BookBuilder {
        private String title;
        private String author;
        private String edition;

        public BookBuilder(String title) {
            this.title = title;
        }

        public BookBuilder author(String author) {
            this.author = author;
            return this;
        }

        public BookBuilder edition(String edition) {
            this.edition = edition;
            return this;
        }

        public Book build() {
            return new Book(this);
        }
    }

    public void show() {
        System.out.println(title + ", " + author + ", " + edition);
    }

    public static void main(String[] args) {
        Book book = new Book.BookBuilder("Design Patterns")
                .author("GoF")
                .edition("2nd")
                .build();
        book.show();
    }
}