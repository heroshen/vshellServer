package com.vshell.server.builder;

import com.vshell.server.VshellServerApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * Created by heroshen on 2017/12/12.
 */
public class WebBootInitializer extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(VshellServerApplication.class);
    }
}
