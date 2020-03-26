package com.rkasibha.rentabook.interceptor;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;


public class AddTrackingIdInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String trackingIdHeader = request.getHeader("WEBEX_TRACKINGID");
        System.out.println("In preHandle");
        if (trackingIdHeader == null || trackingIdHeader.equals("")) {
            trackingIdHeader = "BOOKSTORE_" + UUID.randomUUID().toString();
            response.setHeader("WEBEX_TRACKINGID", trackingIdHeader);
        }

        return true;
    }
}
