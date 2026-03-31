public class ArraysIntersection {
    public int[] intersection(int[] nums1, int[] nums2) {
        ArrayList <Integer> lst= new ArrayList<>();
        for(int i =0;i<nums1.length;i++){
            lst.add(nums1[i]);
        }
        HashSet<Integer> set=new HashSet<>();
        for(int i=0;i<nums2.length;i++){
            if(lst.contains(nums2[i])){
                set.add(nums2[i]);
            }
        }
        int res[]= new int[set.size()];
        int in=0;
        for(int i :set){
            res[in]=i;
            in++;
        }
        return res;
    }
}