public class StringUtils{
    public String reverse(String str){
        String rev="";
        for(int i=str.length()-1;i>=0;i--){
            rev+=str.charAt(i);
        }
        return rev;
    }
    public boolean isPalindrome(String str){
        return str.equals(reverse(str));
    }
    public String toUpperCase(String str){
        return str.toUpperCase();
    }
    public static void main(String[]args){
        StringUtils s=new StringUtils();
        System.out.println(s.reverse("java"));
        System.out.println(s.isPalindrome("madam"));
        System.out.println(s.toUpperCase("bridgeLabz"));
    }
}
