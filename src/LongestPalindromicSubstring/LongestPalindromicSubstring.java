package LongestPalindromicSubstring;

public class LongestPalindromicSubstring {
    public static void main(String[] args){
            String s = "cb";
            longestPalindrome(s);
    }

    static String longestPalindrome(String s) {
        String longestPalindromeStr="";
        int length = s.length();
        String subS;
        int subSLength;
        char[] subSChar;
        for(int i=0;i<length;i++){
            for(int j=i+1;j<=length;j++){
                subS = s.substring(i,j);
                subSLength = subS.length();
                subSChar = subS.toCharArray();
                 for(int n=0;n<=subSLength/2;n++){
                    if(subSChar[n]==subSChar[subSLength-1-n]){
                        if(n==subSLength/2&&subSLength>longestPalindromeStr.length()){
                            longestPalindromeStr = subS;
                        }
                    }else{
                        break;
                    }
                 }
            }
        }
        return longestPalindromeStr;
    }
}
