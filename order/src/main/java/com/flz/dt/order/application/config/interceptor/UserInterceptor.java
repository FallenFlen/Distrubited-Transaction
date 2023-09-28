package com.flz.dt.order.application.config.interceptor;

import com.flz.dt.common.context.User;
import com.flz.dt.common.context.UserContext;
import com.flz.dt.common.exception.UnAuthorizedException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Component
public class UserInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String userId = Optional.ofNullable(request.getHeader("userId"))
                .orElseThrow(() -> new UnAuthorizedException("Unauthorized!"));
        String username = request.getHeader("username");
        UserContext.setUser(new User(userId, username));
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        UserContext.clear();
    }
}
