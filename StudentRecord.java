// StudentRecord.java

// Example of a class definition

public class StudentRecord {

// attributes

    private String first;
    private String last;
    private char mi;
    private int id;
    private double gpa;

// constructors

    public StudentRecord() {}
        // default constructor replaces default constructor removed by
        // programmer-defined constructor(s) below

    public StudentRecord(String first, String last, char mi) {
        this.first = first;
        this.last = last;
        this.mi = mi;
        gpa = 0.0;
        id = 9999999;
    }  // programmer-defined constructor

// selectors
 
    public String toString() {
        return last + ", " + first + " " + mi + " " + id + " " + gpa;
    }  // toString

    public String getFirst()  { return first; }

    public String getLast()  { return last; }

    public char getMI()  { return mi; }

    public int getID()  { return id; }

    public double getGPA()  { return gpa; }

    public void setFirst(String name)  { first = name; }

    public void setLast(String name)  { last = name; }
 
    public void setMI(char c)  { mi = c; }

    public void setID(int n)  { id = n; }

    public void setGPA(double n)  { gpa = n; }

// methods and operators

// optional main() method for testing
// also see UofMClass.java for a more typical example of StudentRecord usage

public static void main(String[] args) {
    // test and demo method for class StudentRecord

    // create two instances of a StudentRecord Object

    StudentRecord student1 = new StudentRecord("John", "Doe", 'Q');
    StudentRecord anotherStudent = new StudentRecord("Sue", "Smith", ' ');

    System.out.println(student1.toString());
    System.out.println(anotherStudent.toString());

    // try other get and set methods and display the results

}  // main - test method

}  // StudentRecord class
