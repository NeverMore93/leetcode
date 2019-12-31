package StringToIntegerAtoi;

public class StringToIntegerAtoi {
    public static void main(String args[]){
        System.out.println(myAtoi("42"));
    }
    static int myAtoi(String str) {
        str=str.trim();
        int strLength = str.length();
        if(strLength==0){
            return 0;
        }
        char[] strCharArray = str.toCharArray();
        char firstChar =  strCharArray[0];
        char[] baseAtoi = {'0','1','2','3','4','5','6','7','8','9'};
        int[] max = {2,1,4,7,4,8,3,6,4};
        StringBuilder resultStr = new StringBuilder();
        int resultNum = 0;
        boolean positive = true;

        if(firstChar=='-'){
            positive = false;
            strCharArray = str.substring(1,strLength).toCharArray();
            strLength-=1;
        }else if(firstChar=='+'){
            strCharArray = str.substring(1,strLength).toCharArray();
            strLength-=1;
        }
        firstChar = strCharArray[0];
        for(int j=0;j<10;j++){
            if(firstChar==baseAtoi[j]){
                break;
            }else if(j==9){
                return 0;
            }
        }

        for1:
        for(int i=0;i<strLength;i++){
            for(int j=0;j<10;j++){
                if(resultNum==0&&strCharArray[i]=='0'){
                    break;
                }else if(strCharArray[i]==baseAtoi[j]){
                    resultNum = resultNum*10+j;
                    resultStr.append(baseAtoi[j]);
                    break;
                }else if(strCharArray[i]=='.'){
                    break for1;
                }
            }
        }
        if(resultStr.length()<10){
            return positive?resultNum:-1*resultNum;
        }else if(resultStr.length()>10){
            return positive?2147483647:-2147483648;
        }else{
            char[] resultStrChar = resultStr.toString().toCharArray();
            for(int i=0;i<9;i++){
                for(int j=0;j<10;j++){
                    if(resultStrChar[i]==baseAtoi[j]){
                        if(j>max[i]){
                            return positive?2147483647:-2147483648;
                        }
                    }
                }
            }
            for(int j=0;j<10;j++){
                if(resultStrChar[9]==baseAtoi[j]){
                    if(positive){
                        if(j>=7){
                            return 2147483647;
                        }
                    }else if(j>=8){
                        return -2147483648;
                    }

                }
            }
        }
        return positive?resultNum:-1*resultNum;
    }
}
