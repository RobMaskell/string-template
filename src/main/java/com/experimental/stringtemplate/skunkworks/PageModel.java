package com.experimental.stringtemplate.skunkworks;

import io.jstach.jstache.JStache;
import io.jstach.jstache.JStacheFlags;
import io.jstach.jstache.JStacheFlags.Flag;

// @JStache(template = """

//     {{<layout}}
//         {{$pagetitle}}
//             <h1>Actual Page title</h1>
// 			{{>subtitle}}
//         {{/pagetitle}}
//     {{/layout}}
//     """)
//{{>subtitle}}
@JStacheFlags(flags = Flag.DEBUG)
@JStache(template = """

		<h1>Actual Page title</h1>
		{{>subtitle(subtitleModel)}}
    """)
public record PageModel(SubtitleModel subtitleModel) {
    
}
