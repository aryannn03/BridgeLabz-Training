public class AccessBook{
    public String ISBN;
    protected String title;
    private String author;

    public void setAuthor(String author){
        this.author=author;
    }

    public String getAuthor(){
        return author;
    }

    public static void main(String[]args){
        AccessBook b=new AccessBook();
        b.ISBN="123";
        b.title="Java";
        b.setAuthor("James");
        System.out.println(b.getAuthor());
    }
}
