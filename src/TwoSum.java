public class TwoSum {

    public static void main(String[] args){
        int[] nums = {2,7,11,15};
        int target = 9;

    }

    public int[] twoSum(int[] nums, int target) {
        int length = nums.length;
        int i=0,j=0;
        for(;i<length;i++){
            j=i+1;
            for(;j<length;j++){
                break;
            }
        }
        return new int[]{i,j};
    }

}
