package hello.core.lifecycle;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.Setter;

@Setter
public class NetworkClient {
    String url;

    public void disconnected(){
        System.out.println("destroy:"+url);
    }
    @PostConstruct
    public void init(){
        System.out.println("NetworkClient.class");
        connect();
        call("초기화 연결 메세지");
    }
    @PreDestroy
    public void close1(){
        System.out.println("NetworkClient!.close");
        disconnected();
    }
    public void connect(){
        System.out.println("connect:"+url);
    }
    public void call(String message){
        System.out.println(message);
    }
}
