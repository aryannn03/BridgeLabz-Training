import java.util.*;
public class BaseballGame {
    public int calPoints(String[] operations) {
        Stack<String> st= new Stack<>();
        int ans=0;
        for(String i:operations){
            if(i.equals("+")){
                int v1=Integer.parseInt(st.pop());
                int v2=Integer.parseInt(st.peek());
                st.push(Integer.toString(v1));
                st.push(Integer.toString(v1+v2));
            }
            else if(i.equals("D")){ 
                String top=st.peek();
                int v1=Integer.parseInt(st.pop())*2;
                st.push(top);
                st.push(Integer.toString(v1));
            }
            else if(i.equals("C")){
                st.pop();
            }
            else{
                st.push(i);
            }
        }
        while(!st.isEmpty()){
            ans+=Integer.parseInt(st.pop());
        }
        return ans;
    }
}