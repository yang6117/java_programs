// Clone.java
// Method example to clone a single dimensioned array
// Compare this with Copy.java
// What are ALL the differences?
// How would you explain cloning vs. copying?

public class Clone {

public static int[] clone(int[] originalArray) {
    // clones a 1 dimensional array of ints
    
    int[] cloneArray = new int[originalArray.length]; 

    for (int index = 0; index < originalArray.length; index++)
            cloneArray[index] = originalArray[index];

    return cloneArray;

}  // clone 
 
public static void printArray(int[] a) {
    // prints out a 1 dimenaional array of ints

    System.out.println();
    for (int index = 0; index < a.length; index++)
        System.out.print("  " + a[index]);
    System.out.println();
}  // printArray
   
 
public static void main(String[] args) {
    int[] a = {2, 5, 100, 18, 7};
    int[] b;
    int[] c;

    b = clone(a);
    c = clone(a); 

    System.out.println();
    System.out.println("Array a is : ");
    printArray(a);
    System.out.println();
    System.out.println("Array b is : ");
    printArray(b);
    System.out.println();
    System.out.println("Array c is : ");
    printArray(c);
    System.out.println();
}  // main method

}  // Clone class
