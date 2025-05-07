package hello.core.oriented;

public class StudentWorker {
    public static void main(String[] args) {
        Person p=new Person();
        System.out.println("p = " + p);
        Person s=new Student();
        Person P1=(Person)s;
        System.out.println("s = " + s);
        System.out.println("P1 = " + P1);
        p.speak();
        s.speak();
        P1.speak();
    }
}
