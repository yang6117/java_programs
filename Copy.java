// Copy.java

// Method example to copy a single dimensioned array
// Compare with Clone.java
// What are ALL the differences?
// How would you explain cloning vs. copying?

public class Copy {

public static void copy(int[] originalArray, int[] copyArray) {
    // copies a 1 dimensional array of ints to copyArray

        for (int index = 0; index < Math.min(originalArray.length, copyArray.length); index++)
            copyArray[index] = originalArray[index];
}  // copy
 
public static void printArray(int[] a) {
    // prints out a 1 dimenaional array of ints

    System.out.println();
    for (int index = 0; index < a.length; index++)
        System.out.print("  " + a[index]);
    System.out.println();
}  // printArray
   
 
public static void main(String[] args) {
    int[] a = {2, 5, 100, 18, 7};
    int[] b = new int[8];
    int[] c = new int[3];

    copy(a, b);
    copy(a, c);

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

}  // Copy class
