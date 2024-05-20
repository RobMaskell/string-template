# Experiment with Java 21's String Template

Test out whether you can make an easy to use java template solution using just pure java, specifically Java 21's new string templates

## Compatibility

I did this in vscode and there are a few hoops to jump through to get this code running
* I needed the eclipse gradle plugin to turn on Java 22 compatability in the ide and also the preview features in the buildship setting
* Also I needed Java 22 because you can ony turn on preview features in the ide for the latest version of java (apparently)

## Things I like
* The simmplicity
* It feels almost like making a composable UI
* Don't put code in the template (although you always end up doing it e.g. SpEL) but this puts the template in the code which feels different
* No mismatches between the model and the view, you have to add everything and you'll find out that you have everything and it's correctly typed in the IDE
* It's pure java so no template language or expression language to learn
* Complexity can be abstracted using standard java syntax
* Standard java so no issues with graalvm / native (tested for this simple example anyway)
* You can use package private to avoid view-models being use from outside the package helping to maintain good vertical deliniation of code, unlike templates in a directory where you have no idea where they are being used from

## Things I'm not so sure about because I haven't tested them yet
* General performance versus other more obvious template options Thymeleaf, Jstachio etc, not worth it until it's out of preview
* Is there going to be a problem here with large strings, probably not for a fairly basic webapp but for something with very long pages..... that isn't paged maybe, but passing the writer around all the time would make it much less clean
* is there a better way to handle the static methods than the default ones in BaseModel, I like how clean they are to use but...
* Is a way to use RAW.""" """ and not STR.""" """ to cache the string templates to improve performance, can't see how to do it though