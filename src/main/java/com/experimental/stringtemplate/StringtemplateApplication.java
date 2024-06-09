package com.experimental.stringtemplate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.jstach.jstache.JStacheFlags;
import io.jstach.jstache.JStacheFlags.Flag;
import io.jstach.jstache.JStachePartial;
import io.jstach.jstache.JStachePartials;

@JStacheFlags(flags = Flag.DEBUG)
@JStachePartials({

	@JStachePartial(name = "subtitle", template = """
    	<p>*** {{thesubtitle}} ***</p>
    """),

	@JStachePartial(name = "layout", template = """
		<!DOCTYPE html>
		<html>
			<head>
				<title>Default Page Title</title>
			</head>
			<body>
				{{$pagetitle}}
				<h1>Default Layout Title</h1>
				{{/pagetitle}}

				<p>Some basic content</p>
	
			</body>
		</html>
    """)

})
@SpringBootApplication
public class StringtemplateApplication {

	public static void main(String[] args) {
		SpringApplication.run(StringtemplateApplication.class, args);
	}

}
