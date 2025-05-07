package hello.core.controller;

import hello.core.common.Mylogger;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LogDemoService {

    private final Mylogger mylogger;
    public void logic(String id) {
        mylogger.log("serviceID = "+id);
    }
}
