package ZigzagConversion;

import java.util.Arrays;

public class ZigzagConversion {
    public static void main(String args[]){
        String str  = "LEETCODEISHIRING";
        convert(str,4);
    }
    static String convert(String s, int numRows) {
        int sLength = s.length();
        int blockLength = 2* numRows -2;
        int block = sLength%blockLength==0?sLength/blockLength:sLength/blockLength+1;
        char[] sChar = s.toCharArray();
        char[][] array = new char[block][blockLength];
        int sIndex=0;
        for(int j=0;j<block;j++){
            for(int k =0;k<blockLength;k++){
                array[j][k] = sChar[sIndex];
                sIndex++;
            }
        }
        System.out.println( Arrays.deepToString(array));
        StringBuilder result =new StringBuilder("");
        for(int k =0;k<numRows;k++){
            for(int j=0;j<block;j++){
                result.append(array[j][k]);
                if(k!=0&&k!=numRows-1){
                    result.append(array[j][blockLength-k]);
                }
            }
        }
        System.out.println(result.toString());
        return null;
    }
}
