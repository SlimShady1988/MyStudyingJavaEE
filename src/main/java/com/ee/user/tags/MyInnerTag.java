package com.ee.user.tags;

import jakarta.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

public class MyInnerTag extends SimpleTagSupport {
    @Override
    public void doTag() throws IOException {
        TagSup myTag = (TagSup) findAncestorWithClass(this, TagSup.class);
        getJspContext().getOut().print(myTag.getName());
    }
}
