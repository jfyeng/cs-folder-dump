import java.util.Arrays;

class Array2 {
  public static void main(String[]args){
    // Arrays in Java DO NOT SHRINK OR GROW (NO APPEND)
    int []nums;          // declare
    nums = new int[10];  // initialize
    int []vals = {12, 34, 55}; 
    // vals = new int[]{5,5,5};
    
    nums[0] = 12;
    System.out.println(Arrays.toString(nums));
    
    for(int n : vals){
      System.out.println(n);
    }
    
    for(int i=0; i < vals.length; i++){
      vals[i] *= 2;
    }
    
    for(int n : vals){
      System.out.println(n);
    }
  }
}