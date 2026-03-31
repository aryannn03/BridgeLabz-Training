public class FindAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> lst = new ArrayList<>();
        if(p.length()>s.length()){
            return lst;
        }
        int freq1[]=new int[26];
        for(int i=0;i<p.length();i++){
            freq1[p.charAt(i)-'a']++;
        }
        int freq2[]= new int[26];
        for(int i=0;i<p.length();i++){
            freq2[s.charAt(i)-'a']++;
        }
        boolean flag=true;
        for(int i=0;i<26;i++){
            if(freq1[i]!=freq2[i]){
                flag=false;
                break;
            }
        }
        if(flag){
            lst.add(0);
        }
        for(int i=p.length();i<s.length();i++){
            freq2[s.charAt(i)-'a']++;
            freq2[s.charAt(i-p.length())-'a']--;
            boolean f=true;
            for(int j=0;j<26;j++){
                if(freq1[j]!=freq2[j]){
                    f=false;
                    break;
                }
            }
            if(f){
                lst.add(i-(p.length()-1));
            }
        }
        return lst;
    }
}