package hello.core.singleton;

public class SingleTonService {
    private static final SingleTonService instance=new SingleTonService();

    private SingleTonService() {
    }
    public  static SingleTonService getInntacne(){
        return instance;
    }
    public void logic(){
        System.out.println("싱글톤 객체 로직 생성.");
    }
}
