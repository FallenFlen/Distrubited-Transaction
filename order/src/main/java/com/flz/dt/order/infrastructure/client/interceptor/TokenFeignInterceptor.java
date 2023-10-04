package com.flz.dt.order.infrastructure.client.interceptor;

import com.flz.dt.common.constant.UserConstant;
import com.flz.dt.common.context.UserContext;
import feign.RequestInterceptor;
import feign.RequestTemplate;

public class TokenFeignInterceptor implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate requestTemplate) {
        requestTemplate.header(UserConstant.USER_ID_KEY, UserContext.getUser().getId());
        requestTemplate.header(UserConstant.USER_NAME_KEY, UserContext.getUser().getName());
    }
}
