package com.experimental.stringtemplate.skunkworks;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {
	

	@GetMapping("/test")
	public PageModel getPage() throws IOException {


		//return JStachioModelView.of(new PageModel());
		// return new PageModel(new SubtitleModel("The Actual Subtitle"), "Blah");
		return new PageModel(new SubtitleModel("Blah"));
	}
}
