package com.fd.weixinplf.message.util;

import java.io.Writer;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XppDriver;

public class XmlSerializerInitializer implements XmlInitializer {

    @Override
    public XStream initialize() {
        XStream xstream = new XStream(new XppDriver() {
            @Override public HierarchicalStreamWriter createWriter(Writer out) {
                return new PrettyPrintWriter(out, getNameCoder()) {
                    @Override protected void writeText(QuickWriter writer, String text) {
                        if (text.startsWith("<![CDATA[") && text.endsWith("]]>")) {
                            writer.write(text);
                        } else {
                            super.writeText(writer, text);
                        }
                    }
                    @Override public String encodeNode(String name) {
                        return name;
                    }
                };
            }
        });
        return xstream;
    }

}
