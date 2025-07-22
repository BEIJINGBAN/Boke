package com.example.boke;

import com.example.boke.utils.TokenUtil;
import io.swagger.v3.oas.models.PathItem;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.HttpServletBean;

/**
 * @author bjingban
 * @date 2025-07-14 17:50
 */

public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler){
        if(HttpMethod.OPTIONS.toString().equals(request.getMethod())){
            System.out.println("OPTIONS请求,放行");
            return true;
        }
        String token = request.getParameter("token");
        if(TokenUtil.verify(token)){
            return true;
        }

        request.setAttribute("mag","消息出错");
        request.getRemoteHost();
//        request.getRequestDispatcher("/login").forward(request,response);
        return false;
    }
}
