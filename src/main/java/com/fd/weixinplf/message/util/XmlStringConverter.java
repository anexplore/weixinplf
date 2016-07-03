package com.fd.weixinplf.message.util;

import com.thoughtworks.xstream.converters.basic.StringConverter;

public class XmlStringConverter extends StringConverter {
    
    public static final String CDATA_PREFIX = "<![CDATA[";
    public static final String CDATA_SUFFIX = "]]>";
    
    @Override public String toString(Object obj) {
        return obj == null ? null : String.format("%s%s%s", CDATA_PREFIX, obj.toString(),
                CDATA_SUFFIX);
    }
}
