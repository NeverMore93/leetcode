package LongestSubstringWithoutRepeatingCharacters;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args ){
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }

    private static int lengthOfLongestSubstring(String s) {
        int max = 0;
        int length = s.length();
        char[] charS = s.toCharArray();
        for(int i=0;i<length;i++){
            String initStr = s.substring(i,i+1);
            for(int j=i+1;j<length;j++){
               if(initStr.indexOf(charS[j])==-1){
                   initStr=initStr+charS[j];
               }else{
                   break;
               }
            }
            if(initStr.length()>max){
                max = initStr.length();
            }
        }
        return max;
    }
}
