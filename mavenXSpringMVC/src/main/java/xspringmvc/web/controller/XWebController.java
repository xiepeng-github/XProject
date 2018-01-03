package xspringmvc.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.servlet.ModelAndView;
import xspringmvc.web.service.LongTermTaskCallback;
import xspringmvc.web.service.LongTimeAsyncCallService;

import javax.servlet.http.HttpSession;

@Controller
public class XWebController {

    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String index(HttpSession httpSession) {
        httpSession.setMaxInactiveInterval(1);//设置当前session 1秒钟后失效，设置为0，-1 表示永不超时
        System.out.println("index 当前登录人数：" + httpSession.getServletContext().getAttribute("Count"));
        return "index";
    }

    @RequestMapping(value="/asynctask", method = RequestMethod.GET)
    public DeferredResult<ModelAndView> asyncTask(){
        DeferredResult<ModelAndView> deferredResult = new DeferredResult<ModelAndView>();
        System.out.println("/asynctask 调用！thread id is : " + Thread.currentThread().getId());
        LongTimeAsyncCallService l = new LongTimeAsyncCallService();
        l.makeRemoteCallAndUnknownWhenFinish(new LongTermTaskCallback() {
            @Override
            public void callback(Object result) {
                System.out.println("异步调用执行完成, thread id is : " + Thread.currentThread().getId());
                ModelAndView mav = new ModelAndView("remotecalltask");
                mav.addObject("result", result);
                deferredResult.setResult(mav);
            }
        });

        return deferredResult;
    }
}
