import java.util.*;
public class ShoppingCart{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        Map<String,Integer> prices=new HashMap<>();
        Map<String,Integer> order=new LinkedHashMap<>();
        for(int i=0;i<n;i++){
            String p=sc.next();
            int price=sc.nextInt();
            prices.put(p,price);
            order.put(p,price);
        }
        System.out.println("INSERTION_ORDER");
        System.out.println(order);
        Map<Integer,List<String>> sorted=new TreeMap<>();
        for(String p:prices.keySet()){
            int price=prices.get(p);
            if(!sorted.containsKey(price)){
                sorted.put(price,new ArrayList<>());
            }
            sorted.get(price).add(p);
        }
        System.out.println("SORTED_BY_PRICE");
        System.out.println(sorted);
    }
}
