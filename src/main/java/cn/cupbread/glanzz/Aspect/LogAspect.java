package cn.cupbread.glanzz.Aspect;

import lombok.Data;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @Date: 2020/2/21
 * @Author: CupOfBread
 * @Description: 日志切面
 */
@Aspect
@Component
public class LogAspect {
    private final Logger logger= LoggerFactory.getLogger(this.getClass());

    @Pointcut("execution(* cn.cupbread.glanzz.Controller.*.*(..))")
    public void log() {}

    @Before("log()")
    public void doBefore(JoinPoint joinpoint){
        ServletRequestAttributes attributes= (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request=attributes.getRequest();
        String url=request.getRequestURL().toString();
        String ip=request.getRemoteAddr();
        String classMethod=joinpoint.getSignature().getDeclaringTypeName()+"."+joinpoint.getSignature().getName();
        Object[] args=joinpoint.getArgs();
        RequestLog requestLog=new RequestLog(url,ip,classMethod,args);
        logger.info("IP :"+ip+"; Request :"+requestLog);
    }

    @After("log()")
    public void doAfter(){
//        logger.info("----doAfter----");
    }

    @AfterReturning(returning = "result",pointcut = "log()")
    public void doAfterReturn(Object result ){
        logger.info("返回内容 : {}",result);
    }

    @Data
    private class RequestLog{
        private String ip;
        private String url;
        private String classMethod;
        private Object[] args;

        public RequestLog(String url, String ip, String classMethod, Object[] args) {
            this.url = url;
            this.ip = ip;
            this.classMethod = classMethod;
            this.args = args;
        }
    }

}
