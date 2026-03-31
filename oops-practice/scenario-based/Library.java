class Library {

    static String[] title={"Java Basics","Python Guide","Data Structures","Web Development"};
    static String[] author={"James","Guido","Mark","Tim"};
    static boolean[] avail={true,true,true,true};

    static void displayBooks(){
        for(int i=0;i<title.length;i++){
            System.out.println(title[i]+" | "+author[i]+" | "+(avail[i]?"Available":"Checked Out"));
        }
    }

    static void searchBook(String key){
        boolean f=false;
        for(int i=0;i<title.length;i++){
            if(title[i].toLowerCase().contains(key.toLowerCase())){
                System.out.println("Found: "+title[i]+" | "+author[i]);
                f=true;
            }
        }
        if(!f)
            System.out.println("Book not found");
    }

    static void checkoutBook(String t){
        for(int i=0;i<title.length;i++){
            if(title[i].equalsIgnoreCase(t)){
                if(avail[i]){
                    avail[i]=false;
                    System.out.println("Book checked out successfully");
                }else{
                    System.out.println("Book already checked out");
                }
                return;
            }
        }
        System.out.println("Book not available");
    }

    public static void main(String[] args){
        displayBooks();
        System.out.println();
        searchBook("java");
        System.out.println();
        checkoutBook("Java Basics");
        System.out.println();
        displayBooks();
    }
}
