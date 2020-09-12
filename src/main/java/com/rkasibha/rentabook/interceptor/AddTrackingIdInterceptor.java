package com.rkasibha.rentabook.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;


public class AddTrackingIdInterceptor extends HandlerInterceptorAdapter {

    private static final Logger LOG = LoggerFactory.getLogger(AddTrackingIdInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String trackingIdHeader = request.getHeader("WEBEX_TRACKINGID");
        System.out.println("In preHandle");
        if (trackingIdHeader == null || trackingIdHeader.equals("")) {
            trackingIdHeader = "BOOKSTORE_" + UUID.randomUUID().toString();
            response.setHeader("WEBEX_TRACKINGID", trackingIdHeader);
        }
        MDC.put("HOSTIP", request.getLocalAddr());
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        LOG.info("Completed request: " + request.getRequestURI());
    }
}
