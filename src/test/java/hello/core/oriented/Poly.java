package hello.core.oriented;

public class Poly {
    public static void main(String[] args) {
        PolyA p0=new PolyB();
        PolyA p1=new PolyC();
        p0.speak();
        p1.speak();
    }
}
interface PolyA{
    public void speak();

}
class PolyB implements PolyA{
    @Override
    public void speak(){
        System.out.println("PolyB.speak");
    }
}
class PolyC implements PolyA{
    public void speak(){
        System.out.println("PolyC.speak");
    }
}
