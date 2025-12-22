import java.util.Scanner;
public class DeckOfCards{
    public static String[]initializeDeck(String[]suits,String[]ranks){
        int numOfCards=suits.length*ranks.length;
        String[]deck=new String[numOfCards];
        int index=0;
        for(int i=0;i<suits.length;i++){
            for(int j=0;j<ranks.length;j++){
                deck[index]=ranks[j]+" of "+suits[i];
                index++;
            }
        }
        return deck;
    }
    public static String[]shuffleDeck(String[]deck){
        int n=deck.length;
        for(int i=0;i<n;i++){
            int randomCardNumber=i+(int)(Math.random()*(n-i));
            String temp=deck[i];
            deck[i]=deck[randomCardNumber];
            deck[randomCardNumber]=temp;
        }
        return deck;
    }
    public static String[][]distributeCards(String[]deck,int totalCards,int players){
        if(totalCards%players!=0){
            return null;
        }
        int cardsPerPlayer=totalCards/players;
        String[][]playerCards=new String[players][cardsPerPlayer];
        int index=0;
        for(int i=0;i<players;i++){
            for(int j=0;j<cardsPerPlayer;j++){
                playerCards[i][j]=deck[index++];
            }
        }
        return playerCards;
    }
    public static void printPlayers(String[][]playerCards){
        for(int i=0;i<playerCards.length;i++){
            System.out.println("Player "+(i+1));
            for(int j=0;j<playerCards[i].length;j++){
                System.out.println(playerCards[i][j]);
            }
            System.out.println();
        }
    }
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        String[]suits={"Hearts","Diamonds","Clubs","Spades"};
        String[]ranks={"2","3","4","5","6","7","8","9","10","Jack","Queen","King","Ace"};
        int players=sc.nextInt();
        String[]deck=initializeDeck(suits,ranks);
        deck=shuffleDeck(deck);
        String[][]playerCards=distributeCards(deck,deck.length,players);
        if(playerCards==null){
            System.out.println("Cards cannot be distributed equally");
        }else{
            printPlayers(playerCards);
        }
    }
}
