// OofMClass.java

// An application that utilizes the StudentRecord class

public class UofMClass {

    public static void main(String[] args) {

        // create an array of StudentRecords

        StudentRecord[] uofm = new StudentRecord[40000];

        // initialize the uofm *array* with StudentRecord Objects
        // using the default constructor

        for (int index = 0; index < uofm.length; index++)
            uofm[index] = new StudentRecord();

        // initialize two specific *StudentRecords* within the uofm array

        uofm[0].setFirst("John");
        uofm[0].setLast("Public");
        uofm[0].setMI('Q');
        uofm[0].setGPA(0.0);
        uofm[0].setID(9999999);

        uofm[1].setFirst("Eliza");
        uofm[1].setLast("Dolittle");
        uofm[1].setMI('A');
        uofm[1].setGPA(4.0);
        uofm[1].setID(12345);

        // loop to initialize 10 more *StudentRecords* within the uofm array

        for (int index = 2; index < 12; index++) {
            uofm[index].setFirst("tbd");
            uofm[index].setLast("tbd");
            uofm[index].setMI(' ');
            uofm[index].setID(index);
            uofm[index].setGPA(4.0);
        }
            
        // display the first 12 StudentRecords in the uofm array

        for (int index = 0; index < 11; index++) 
            System.out.println(uofm[index].toString());

}  // main

}  // class UofMClass

