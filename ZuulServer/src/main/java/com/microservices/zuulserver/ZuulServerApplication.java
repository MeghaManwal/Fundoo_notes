package com.microservices.zuulserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.microservices.zuulserver.filters.ErrorFilter;
import com.microservices.zuulserver.filters.PostFilter;
import com.microservices.zuulserver.filters.PreFilter;
import com.microservices.zuulserver.filters.RouteFilter;

@EnableZuulProxy
@SpringBootApplication
public class ZuulServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZuulServerApplication.class, args);
	}
	
	@Bean
    public PreFilter preFilter() {
            return new PreFilter();
    }

    @Bean
    public PostFilter postFilter(){
            return new PostFilter();
    }

   @Bean
   public RouteFilter routerFilter(){
           return new RouteFilter();
   }

  @Bean
  public ErrorFilter filterError(){
          return new ErrorFilter();
  }


}
