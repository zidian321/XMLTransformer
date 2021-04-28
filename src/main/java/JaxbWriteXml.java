import entity.StringList;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class JaxbWriteXml {
 
	public static <T> Marshaller getMarshaller(Class<T> c) throws JAXBException{
		
		JAXBContext context = JAXBContext.newInstance(c);
		Marshaller marshaller = context.createMarshaller(); 
		//编码格式 
		marshaller.setProperty(Marshaller.JAXB_ENCODING,"UTF-8");
		//是否格式化生成的xml串    
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		//是否省略xml头信息（<?xml version="1.0" encoding="gb2312" standalone="yes"?>）
		marshaller.setProperty(Marshaller.JAXB_FRAGMENT, false);
		
		return marshaller;
	}

	
	public void test_xml2(StringList stringList) throws JAXBException, IOException {
		Marshaller marshaller = getMarshaller(StringList.class);
		BufferedOutputStream bos=new BufferedOutputStream(
				//文件会自动被创建，默认路径为该工程目录，
				new FileOutputStream("src/main/resources/stringsOut.xml"));
        marshaller.marshal(stringList, bos);
        bos.flush();
        bos.close();
	}
}
