package com.experimental.stringtemplate.skunkworks;

import io.jstach.jstache.JStacheFlags;
import io.jstach.jstache.JStacheFlags.Flag;
import io.jstach.jstache.JStachePartial;
import io.jstach.jstache.JStachePartials;

@JStacheFlags(flags = Flag.DEBUG)
// @JStachePartials({
// 	@JStachePartial(name = "subtitle", template = """
//         	<h2>{{actualSubtitle}}</h2>
//     	""")
// })
// @JStachePartials({
// 	@JStachePartial(name = "subtitle", template = """
//     	<p>*** {{thesubtitle}} ***</p>
//     """)
// })
public record SubtitleModel(String actualsubtitle) {
    
}
