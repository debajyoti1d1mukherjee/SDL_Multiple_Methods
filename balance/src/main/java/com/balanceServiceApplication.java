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
public class balanceServiceApplication {
    public static void main(String[] args){
		SpringApplication.run(balanceServiceApplication.class, args);
		}
}

	
	
@RestController
class balanceRestController {

	public balanceRestController(){}

  

//TEMPLATE_GET_METHOD_START
   @RequestMapping(value="getBalance/{id}", method = RequestMethod.GET,produces = { "application/json"})
   @HystrixCommand(fallbackMethod = "getBalanceFallBack",commandProperties ={
				@HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="5000")
			})			
			
    public com.balance.GetBalanceResponse getBalance(@PathVariable("id") String id) throws Exception{
		  com.balance.GetBalanceResponse resp = new com.balance.GetBalanceResponse();
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
   public com.balance.GetBalanceResponse getBalanceFallBack(@PathVariable("id") String id) throws Exception{
		  com.balance.GetBalanceResponse resp = new com.balance.GetBalanceResponse();
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
   @RequestMapping(value="saveBalance/save", method = RequestMethod.POST,produces = { "application/json"})
   @HystrixCommand(fallbackMethod = "saveBalanceFallBack",commandProperties ={
				@HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="5000")
			})			
			
    public com.balance.SaveBalanceResponse saveBalance(@RequestBody com.balance.SaveBalanceRequest request) throws Exception{
		  com.balance.SaveBalanceResponse resp = new com.balance.SaveBalanceResponse();
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
   
//TEMPLATE_GET_METHOD_START
   @RequestMapping(value="getBalance1/{id}", method = RequestMethod.GET,produces = { "application/json"})
   @HystrixCommand(fallbackMethod = "getBalance1FallBack",commandProperties ={
				@HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="5000")
			})			
			
    public com.balance.GetBalanceResponse1 getBalance1(@PathVariable("id") String id) throws Exception{
		  com.balance.GetBalanceResponse1 resp = new com.balance.GetBalanceResponse1();
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
   public com.balance.GetBalanceResponse1 getBalance1FallBack(@PathVariable("id") String id) throws Exception{
		  com.balance.GetBalanceResponse1 resp = new com.balance.GetBalanceResponse1();
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
   @RequestMapping(value="saveBalance1/save", method = RequestMethod.POST,produces = { "application/json"})
   @HystrixCommand(fallbackMethod = "saveBalance1FallBack",commandProperties ={
				@HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="5000")
			})			
			
    public com.balance.SaveBalanceResponse1 saveBalance1(@RequestBody com.balance.SaveBalanceRequest1 request) throws Exception{
		  com.balance.SaveBalanceResponse1 resp = new com.balance.SaveBalanceResponse1();
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

