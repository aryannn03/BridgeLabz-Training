import java.util.*;
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> list= new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0){
                break;
            }
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }
			int t=0-nums[i];
			int l=i+1;
			int h =nums.length-1;
			while(l<h){
				if(nums[l]+nums[h]==t){
					List<Integer> lst=new ArrayList<>();
					lst.add(nums[i]);
					lst.add(nums[l]);
					lst.add(nums[h]);
					list.add(lst);
					l++;
                    h--;
                    while (l<h && nums[l]==nums[l - 1]) {
                        l++;
                    }
                }
				else if(nums[l]+nums[h]>t){
					h--;
				}
				else{
					l++;
				}
			}
		}
		return list;
    }
}