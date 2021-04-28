import entity.StringList;
import entity.StringObj;

import java.io.InputStream;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;


public class JaxbReadXml {
 
    public static <T> T readString(Class<T> clazz, String context) throws Exception {
        try {
            InputStream inputStream = ClassLoader.getSystemResource(context).openStream();
            JAXBContext jc = JAXBContext.newInstance(clazz);
            Unmarshaller u = jc.createUnmarshaller();

           return (T) u.unmarshal(inputStream);
        } catch (Exception e) {
            throw e;
        }
    }
 
    public StringList test_xml() throws Exception {
    	
    	StringList stringList = JaxbReadXml.readString(StringList.class, "strings.xml");
    	return stringList;
    }

}