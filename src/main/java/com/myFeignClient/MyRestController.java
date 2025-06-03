package com.myFeignClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyRestController {
	@Autowired
	FeignReciever fr;
	
	@GetMapping(value="/getFeign")
	public String getthis() {
		return fr.getword();
	}
	
	@GetMapping (value="/getFeign1/{n}")
	public String getthis1(@PathVariable String n) {
		return n+" "+"Nishanthi Mam";
	}
	
	@GetMapping (value="/getFeign2/{a}/{b}/{c}")
	
	public String getthis2(@PathVariable int a,@PathVariable int b,@PathVariable int c) {
		
if(a>b && a>c) {
			
			return "a is max"+a;
		}
		
		else if(b>a && b>c) {
			return "b is max"+b;
			
		}
		
		else {
			return "c is max"+c;
		}	
	}

}
