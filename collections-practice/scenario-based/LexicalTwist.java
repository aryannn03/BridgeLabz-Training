import java.util.*;
public class LexicalTwist {
    public static void main(String args[]) {
        Scanner ob=new Scanner(System.in);
        System.out.println("Enter the first word");
        String first=ob.nextLine();

        if(!checkWord(first)) {
            System.out.println(first+" is an invalid word");
            return;
        }
        System.out.println("Enter the second word");
        String second=ob.nextLine();

        if(!checkWord(second)) {
            System.out.println(second+" is an invalid word");
            return;
        }

        if(checkReverse(first,second)) {
            StringBuilder sb=new StringBuilder(first);
            sb.reverse();
            first=sb.toString().toLowerCase();
            first=replaceVowel(first);
            System.out.println(first);
        } else {
            String word=(first+second).toUpperCase();
            int vCount=vowelCount(word);
            int cCount=consonantCount(word);
            if(vCount>cCount) {
                printAnswer1(word);
            } else if(vCount<cCount) {
                printAnswer2(word);
            } else {
                System.out.println("Vowels and consonants are equal");
            }
        }
    }

    public static boolean checkWord(String word) {
        return !word.contains(" ");
    }

    public static boolean checkReverse(String first,String second) {
        StringBuilder sb=new StringBuilder(first);
        sb.reverse();
        return sb.toString().equalsIgnoreCase(second);
    }

    public static String replaceVowel(String word) {
        StringBuilder sb=new StringBuilder();
        for(char ch:word.toCharArray()) {
            if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u') {
                sb.append('@');
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    public static int vowelCount(String word) {
        int count=0;
        for(char ch:word.toCharArray()) {
            if(checkVowel(ch)) {
                count++;
            }
        }
        return count;
    }

    public static int consonantCount(String word) {
        int count=0;
        for(char ch:word.toCharArray()) {
            if(!checkVowel(ch)&&Character.isLetter(ch)) {
                count++;
            }
        }
        return count;
    }

    public static boolean checkVowel(char ch) {
        return ch=='A'||ch=='E'||ch=='I'||ch=='O'||ch=='U';
    }

    public static void printAnswer1(String word) {
        Set<Character> set=new LinkedHashSet<>();

        for(int i=0;i<word.length()&&set.size()<2;i++) {
            char ch=word.charAt(i);
            if(checkVowel(ch)) {
                set.add(ch);
            }
        }

        StringBuilder sb=new StringBuilder();
        for(char c:set) {
            sb.append(c);
        }

        System.out.println(sb.toString());
    }

    public static void printAnswer2(String word) {
        Set<Character> set=new LinkedHashSet<>();

        for(int i=0;i<word.length()&&set.size()<2;i++) {
            char ch=word.charAt(i);
            if(!checkVowel(ch)&&Character.isLetter(ch)) {
                set.add(ch);
            }
        }

        StringBuilder sb=new StringBuilder();
        for(char c:set) {
            sb.append(c);
        }

        System.out.println(sb.toString());
    }
}