package com.tribune.backend.infrastructure.config.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.*;
import java.io.IOException;


@Slf4j
public class CustomFilter extends GenericFilterBean {

    @Override
    public void doFilter(
            ServletRequest request,
            ServletResponse response,
            FilterChain chain) throws IOException, ServletException {
        log.error("XXX");
        chain.doFilter(request, response);
    }
}
