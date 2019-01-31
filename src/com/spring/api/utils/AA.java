package com.spring.api.utils;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AA extends Feng {
	
	
	@RequestMapping("/getname")
	public ResponseBase getId() {
	
		List<BB> map = new ArrayList<BB>();
		BB bb = new BB();
		bb.setName("斩杀还能");
		map.add(bb);
		return setResult(200, "放回成功", map);
		//return setErrorResult(500, "五百");
		//return setResult(20,"正确", map);
		
	}

}
