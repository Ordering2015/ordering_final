package ordering;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class Marshal_disconnect 
{
	public String FILE_NAME="xml";
	
	
	public String jaxbObjectToXML(XmlBean_disconnect x) {

		
		try {

		JAXBContext context = JAXBContext.newInstance(XmlBean_disconnect.class);
		Marshaller m = context.createMarshaller();


		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);


		m.marshal(x, new File(FILE_NAME));
		} catch (JAXBException e) {
		e.printStackTrace();
		}

		String con=" ";
		final String EoL = System.getProperty("line.separator");
		List<String> lines;
		try{
		lines = Files.readAllLines(Paths.get(FILE_NAME),
		Charset.defaultCharset());


		StringBuilder sb = new StringBuilder();
		for (String line : lines) {
		sb.append(line).append(EoL);
		}
		final String content = sb.toString();
		con=content;
		System.out.println(content);
		} catch (IOException e) {


		e.printStackTrace();
		}

		return con;
		}


}
