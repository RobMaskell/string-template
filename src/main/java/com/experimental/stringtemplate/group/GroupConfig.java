package com.experimental.stringtemplate.group;

import org.springframework.aot.hint.annotation.RegisterReflectionForBinding;
import org.springframework.context.annotation.Configuration;

@Configuration
@RegisterReflectionForBinding({Group.class})
public class GroupConfig {
    
}
