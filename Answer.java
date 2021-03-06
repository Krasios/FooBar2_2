/* Return max number of identical substrings from a string
 */


public class Answer1_1 {   

    public static int answer(String s) { 
       int amount = 1;
       int length = s.length();
       boolean valid = false;
       for(int j = 1; j < length+1; j++){
           if(length%j!=0){//will have leftovers regardless
               continue;
           }
           int split = s.length()/j; //lenght of individual slice
           String part1 = s.substring(0,split);
           valid = checkOthers(part1,split,j,s);
           if(valid == false){
               continue;
           }
           amount = j;
       }
       return amount;

    } 
    private static boolean checkOthers(String part1, int size, int pieces,String s){
        for(int k = 1; k < pieces; k++){//check other slices
           String partk = s.substring(k*size,(k+1)*size);
           if(part1.equals(partk)==false){
              return false;
           }
        }
        return true;
    }
}
