package profesorp.oauth2;

import java.util.HashMap;
import java.util.LinkedHashMap;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class RestTestController
{
	// You can access this api without BEARER
	  @RequestMapping("/")
	  public HashMap<String, Object>  index() {
	    HashMap<String, Object> test = new LinkedHashMap<String, Object>();
		test.put("status", true);
		test.put("message", "Ini Bisa diakses manapun");

	    return test;
	  }
	
	  // You can access this api with required BEARER
	  @RequestMapping("rahasia")
	  public HashMap<String, Object> rahasia() {
		HashMap<String, Object> test = new LinkedHashMap<String, Object>();
		test.put("status", true);
		test.put("message", "Tiap tahun bulan menjauh 3.82 cm dari bumi ");

	    return test;
	  }

}

