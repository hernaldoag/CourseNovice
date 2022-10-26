package notSelenium;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;

import java.io.IOException;
import java.io.StringWriter;

public class JsontoXml {

    public static void main(String [] args){


        try{
            final String str = "{\"name\":\"JSON\",\"integer\":1,\"double\":2.0,\"boolean\":true,\"nested\":{\"id\":42},\"array\":[1,2,3]}";


            ObjectMapper jsonMapper = new ObjectMapper();
            JsonNode node = jsonMapper.readValue(str, JsonNode.class);

        XmlMapper xmlMapper = new XmlMapper();
                    xmlMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
                    xmlMapper.configure(ToXmlGenerator.Feature.WRITE_XML_DECLARATION, true);
                    xmlMapper.configure(ToXmlGenerator.Feature.WRITE_XML_1_1, true);
        ObjectWriter ow = xmlMapper.writer().withRootName("root");
        StringWriter w = new StringWriter();
        ow.writeValue(w, node);
        System.out.println(w.toString());
        }
        catch(IOException ex){
            System.out.println (ex);
        }
    }
}
