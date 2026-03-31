class PalindromeChecker{
    private String text;

    PalindromeChecker(String text){
        this.text=text;
    }

    boolean isPalindrome(){
        String s=text.replaceAll("\\s","").toLowerCase();
        String r=new StringBuilder(s).reverse().toString();
        return s.equals(r);
    }

    void display(){
        if(isPalindrome())
            System.out.println(text+" is palindrome");
        else
            System.out.println(text+" is not Palindrome");
    }
}

public class PalindromeMain{
    public static void main(String[]args){
        PalindromeChecker p1=new PalindromeChecker("A man a plan a canal Panama");
        PalindromeChecker p2=new PalindromeChecker("Hello");
        p1.display();
        p2.display();
    }
}
