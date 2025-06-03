package com.myFeignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="MyWebApplication",url="http://localhost:8080/Admin")
public interface FeignReciever {

	@GetMapping (value="/get1")
	public String getword();
	
	@GetMapping (value="/get2/{name}")
	public String get2(@PathVariable String name);
	
	@GetMapping (value="/get3/{a}/{b}/{c}")
	
	public String get3(@PathVariable int a,@PathVariable int b,@PathVariable int c); 
}
