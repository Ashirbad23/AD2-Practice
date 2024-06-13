public class stringSearchBrute {
    static int StringSearch(String str, String pattern){
        int ls = str.length();
        int lp = pattern.length();
        int max = ls-lp+1;
        for(int i=0;i<max;i++){
            boolean flag = true;
            for(int j=0;j<lp & flag==true; j++){
                if(pattern.charAt(j)!=str.charAt(i+j)){
                    flag=false;
                }
            }
            if(flag==true){
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        String str = "a quick brown fox jumps over a lazy dog!";
        String pattern = "Royale";

        if(StringSearch(str, pattern)==-1){
            System.out.println("Pattern not found! ");
        }
        else{
            System.out.println("Pattern found on index: "+StringSearch(str, pattern));
        }
    }
}
