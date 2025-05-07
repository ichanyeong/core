package hello.core.lifecycle;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LifeCycleConfig {
    @Bean
    public NetworkClient networkClient(){
        NetworkClient networkClient1=new NetworkClient();
        return networkClient1;
    }

}
