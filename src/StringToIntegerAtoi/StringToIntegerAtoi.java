package StringToIntegerAtoi;

public class StringToIntegerAtoi {
    public static void main(String args[]){
        System.out.println(myAtoi("-91283472332"));
    }
    static int myAtoi(String str) {
        str=str.trim();
        char[] strCharArray = str.toCharArray();
        boolean stop = true;
        char[] baseAtoi = {'0','1','2','3','4','5','6','7','8','9'};
        for(int j=0;j<10;j++){
            if(strCharArray[0]==baseAtoi[j]||strCharArray[0]=='-'){
                stop = false;
                break;
            }
        }
        if(stop){
            return 0;
        }

        Integer result = 0;
        boolean positive = true;
        int strLength = str.length();
        for(int i=0;i<strLength;i++){
            if(strCharArray[i]=='-'&&result==0){
                positive=false;
            }else {
                for(int j=0;j<10;j++){
                    if(strCharArray[i]==baseAtoi[j]){
                        result = result*10+j;
                        break;
                    }
                }
            }

        }
        //2147483647
        //-2147483648
        result = positive?result:result*-1;
        if(result>2147483647){
            return 2147483647;
        }else if(result<-2147483648){
            return -2147483648;
        }else{
            return result;
        }
    }
}
