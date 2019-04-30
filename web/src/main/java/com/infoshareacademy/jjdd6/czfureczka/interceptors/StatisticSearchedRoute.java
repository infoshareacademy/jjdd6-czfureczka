package com.infoshareacademy.jjdd6.czfureczka.interceptors;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;
import java.util.logging.Logger;

public class StatisticSearchedRoute {

    private static final Logger logger = Logger.getLogger(StatisticSearchedRoute.class.getName());

    @AroundInvoke
    public Object intercept(InvocationContext context) throws Exception{

        logger.info("Check name of route");
        return context.proceed();
    }

}
