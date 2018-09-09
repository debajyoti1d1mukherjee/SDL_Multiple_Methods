package com;

import java.util.Map;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import java.lang.reflect.Method;
import org.springframework.web.bind.annotation.RequestBody;

@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
@EnableHystrix
public class UsageServiceApplication {
    public static void main(String[] args){
		SpringApplication.run(UsageServiceApplication.class, args);
		}
}

	
	
@RestController
class UsageRestController {

	public UsageRestController(){}

  

//TEMPLATE_GET_METHOD_START
   @RequestMapping(value="getUsage/{id}", method = RequestMethod.GET,produces = { "application/json"})
   @HystrixCommand(fallbackMethod = "getUsageFallBack",commandProperties ={
				@HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="5000")
			})			
			
    public com.Usage.GetUsageResponse getUsage(@PathVariable("id") String id) throws Exception{
		  com.Usage.GetUsageResponse resp = new com.Usage.GetUsageResponse();
		  System.out.println("Get Method Invoked--------------------------");
		  Class respClass = resp.getClass();
		  Method[] methods = respClass.getMethods();
		  for(Method method : methods){			    
			    if(isSetter(method)) {
			    	System.out.println("setter: " + method);
			    	method.invoke(resp, new Object[] { "100M" });
			    }
			  }
	      return resp;
    }
    
//TEMPLATE_FALLBACK_GET_METHOD_START
   public com.Usage.GetUsageResponse getUsageFallBack(@PathVariable("id") String id) throws Exception{
		  com.Usage.GetUsageResponse resp = new com.Usage.GetUsageResponse();
		  System.out.println("Fallback Get Method Invoked--------------------------");
		  Class respClass = resp.getClass();
		  Method[] methods = respClass.getMethods();
		  for(Method method : methods){			    
			    if(isSetter(method)) {
			    	System.out.println("setter: " + method);
			    	method.invoke(resp, new Object[] { "100M" });
			    }
			  }
	      return resp;
    }
   
//TEMPLATE_POST_METHOD_START
   @RequestMapping(value="saveUsage/save", method = RequestMethod.POST,produces = { "application/json"})
   @HystrixCommand(fallbackMethod = "saveUsageFallBack",commandProperties ={
				@HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="5000")
			})			
			
    public com.Usage.SaveUsageResponse saveUsage(@RequestBody com.Usage.SaveUsageRequest request) throws Exception{
		  com.Usage.SaveUsageResponse resp = new com.Usage.SaveUsageResponse();
		  System.out.println("Post Method Invoked--------------------------");
		  Class respClass = resp.getClass();
		  Method[] methods = respClass.getMethods();
		  for(Method method : methods){			    
			    if(isSetter(method)) {
			    	System.out.println("setter: " + method);
			    	method.invoke(resp, new Object[] { "100M" });
			    }
			  }
	      return resp;
    }
   
//TEMPLATE_FALLBACK_POST_METHOD_END
   
      public static boolean isSetter(Method method){
	   if(!method.getName().startsWith("set")) return false;
	   if(method.getParameterTypes().length != 1) return false;
	   return true;
	 }

}	

