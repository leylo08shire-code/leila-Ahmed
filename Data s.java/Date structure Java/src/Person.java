class Person {
    protected String name;

    Person(String name) {
        // Java inserts super(); here = Object()
        this.name = name;
        System.out.println("1. Person: " + name);
    }

    String describe() {
        return name;
    }
}

class Student extends Person {
    protected double gpa;

    Student(String name, double gpa) {
        super(name);               // pass name up to Person
        this.gpa = gpa;
        System.out.println("2. Student: GPA " + gpa);
    }
}

class Postgrad extends Student {
    private String thesis;

    Postgrad(String name, double gpa, String thesis) {
        super(name, gpa);          // pass name and gpa up to Student
        this.thesis = thesis;
        System.out.println("3. Postgrad: " + thesis);
    }

    String card() {
        return super.describe() + " | GPA " + gpa + " | " + thesis;
        // reuse the parent's method
    }
}

 class ConstructorChainDemo {
    public static void main(String[] args) {
        Postgrad hodan = new Postgrad("Hodan", 3.8, "Somali NLP");
        System.out.println(hodan.card());
    }
}
