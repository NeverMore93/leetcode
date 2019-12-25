package MedianOfTwoSortedArrays;

public class MedianOfTwoSortedArrays {
    public static void main(String args[]){
        int[] nums1 = new int[]{3,4};
        int[] nums2 = new int[]{};
        System.out.print(findMedianSortedArrays(nums1,nums2));
    }

    static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int nums1Index = 0,nums2Index=0,nums1Length = nums1.length,nums2Length = nums2.length;
        int[] combine=new int[nums1Length+nums2Length];
        int index = 0,indexLength=nums1Length+nums2Length;
        for(;index<indexLength;index++){
            if(nums2Index==nums2Length){
                for(;nums1Index<nums1Length;nums1Index++){
                    combine[index]=nums1[nums1Index];
                }
            }else if(nums1Index==nums1Length){
                for(;nums2Index<nums2Length;nums2Index++){
                    combine[index]=nums2[nums2Index];
                    index++;
                }
            }else{
                if(nums1[nums1Index]<nums2[nums2Index]){
                    combine[index]=nums1[nums1Index];
                    nums1Index++;
                }else if(nums1[nums1Index]>nums2[nums2Index]){
                    combine[index]=nums2[nums2Index];
                    nums2Index++;
                }else{
                    combine[index]=nums1[nums1Index];
                    nums1Index++;
                    index++;
                    combine[index]=nums2[nums2Index];
                    nums2Index++;
                }
            }
        }
        int mid = indexLength/2;
        if(indexLength%2==1){
            return (double)combine[mid];
        }else{
            return ((double)combine[mid]+(double)combine[mid-1])/2;
        }

    }
}
