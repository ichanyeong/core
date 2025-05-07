package hello.core.controller;

import hello.core.common.Mylogger;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.logging.Logger;
@Controller
@RequiredArgsConstructor
public class LogDemoController {
    private final LogDemoService logDemoService;

    private final Mylogger mylogger;
    @RequestMapping("log-demo")
    @ResponseBody
    public String logDemo(HttpServletRequest request){
        String url = request.getRequestURL().toString();

        mylogger.setRequestUrl(url);
        System.out.println("mylogger = " + mylogger);
        mylogger.log("controller test");
        System.out.println("mylogger = " + mylogger);
        try {

        Thread.sleep(1000L);
        }catch (InterruptedException e){
            System.out.println(e.toString());
        }
        logDemoService.logic("testID");
        return "OK";
    }
}
