package com.infoshareacademy.jjdd6.czfureczka.interceptors;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;
import java.util.logging.Logger;

public class StatisticSearchedStops {

    private static final Logger logger = Logger.getLogger(StatisticSearchedStops.class.getName());

    @AroundInvoke
    public Object intercept(InvocationContext context) throws Exception{

        logger.info("Check name of stop");
        return context.proceed();
    }

}
