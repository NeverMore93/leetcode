package ZigzagConversion;

import java.util.Arrays;

public class ZigzagConversion {
    public static void main(String args[]){
        String str  = "AB";
        convert(str,1);
    }
    static String convert(String s, int numRows) {

        int sLength = s.length();
        if(sLength<2||numRows<2){
            return s;
        }
        int blockLength = 2* numRows -2;
        int block = sLength%blockLength==0?sLength/blockLength:sLength/blockLength+1;
        char[] sChar = s.toCharArray();
        char[][] array = new char[block][blockLength];
        int sIndex=0;
        for(int j=0;j<block;j++){
            for(int k =0;k<blockLength&&sIndex<sLength;k++,sIndex++){
                array[j][k] = sChar[sIndex];
            }
        }
        StringBuilder result =new StringBuilder();
        for(int k =0;k<numRows;k++){
            for(int j=0;j<block;j++){
                String jk = String.valueOf(array[j][k]).trim();
                if(!"".equals(jk)){
                    result.append(jk);
                }

                if(k!=0&&k!=numRows-1){
                    String jbk = String.valueOf(array[j][blockLength-k]).trim();
                    if(!"".equals(jbk)){
                        result.append(array[j][blockLength-k]);
                    }
                }
            }
        }
        return result.toString();
    }
}
