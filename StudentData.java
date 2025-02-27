import java.io.*;

class S implements Serializable {
    int id;
    String name;
    double gpa;

    S(int id, String name, double gpa) {
        this.id = id;
        this.name = name;
        this.gpa = gpa;
    }
}

public class StudentData {
    public static void main(String[] args) {
        S s1 = new S(202, "Alice", 3.8);

        
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("data.txt"));
            out.writeObject(s1);
            out.close();
            System.out.println("Student object serialized and saved to data.txt");
        } catch (IOException e) {
            System.out.println("Problem while saving: " + e.getMessage());
             
        }

        
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("data.txt"));
            S s2 = (S) in.readObject();
            in.close();
            System.out.println("Student object deserialized from data.txt");
            System.out.println("ID -->   " + s2.id);
            System.out.println("Name --> " + s2.name);
            System.out.println("GPA -->  " + s2.gpa);
        } catch (IOException e) {
            System.out.println("Error while reading: " + e.getMessage());
                 
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found: " + e.getMessage());
             
        }
    }
}
