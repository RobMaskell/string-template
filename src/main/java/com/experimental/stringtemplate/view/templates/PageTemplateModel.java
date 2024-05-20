package com.experimental.stringtemplate.view.templates;

import com.experimental.stringtemplate.view.BaseModel;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@AllArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class PageTemplateModel implements BaseModel {

    private boolean isPartialRequested;
    private String pageTitle;
    private BaseModel sectionModel;
    
    
    @SuppressWarnings("preview")
    public String toString() {

        return isPartialRequested ? STR."""
            <title>\{pageTitle}</title>
            \{sectionModel}
            """ : STR."""
            <!DOCTYPE html>
            <html lang="en-gb">
            <head>
                <title>\{pageTitle}</title>
                <meta charset="utf-8">
                <meta http-equiv="X-UA-Compatible" content="IE=edge">
                <meta name="viewport" content="width=device-width, initial-scale=1">
            
                <link rel="stylesheet" href="/css/normalize.css">
                <link rel="stylesheet" href="/css/style.css">
            
                <script src="/js/htmlx.js"></script>
            
            </head>
            <body>
                <header>
                    <span><a href="/">Site header</a></span><span style="float: right;"><a href="/groups">Groups</a></span><span style="float: right;"</span>
                </header>
            \{sectionModel}
                <footer></footer>
            </body>
            </html>
            """;
    }

}
