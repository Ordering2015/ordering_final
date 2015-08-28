package com.DAO;

import java.beans.XMLEncoder;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.customer.CustomerBean;
import com.customer.Table1;
import com.customer.Table3;
import com.customer.Table2;

public class CreateXML {
	private static final String FILE_NAME = "jaxb-emp.xml";

	private static CustomerBean jaxbXMLToObject() {
		try {
			JAXBContext context = JAXBContext.newInstance(CustomerBean.class);
			Unmarshaller un = context.createUnmarshaller();
			CustomerBean emp = (CustomerBean) un.unmarshal(new File(FILE_NAME));
			return emp;
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return null;
	}

	/*
	 * private static void jaxbObjectToXML(CustomerBean emp) { try { JAXBContext
	 * context = JAXBContext.newInstance(CustomerBean.class); Marshaller m =
	 * context.createMarshaller();
	 * 
	 * m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
	 * 
	 * m.marshal(emp, new File(FILE_NAME)); } catch (JAXBException e) {
	 * e.printStackTrace(); } }
	 */
	public static void jaxbObjectToXML(Table1 t1) throws JAXBException {
		try {
			JAXBContext context = JAXBContext.newInstance(Table1.class);
			Marshaller m = context.createMarshaller();

			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

			m.marshal(t1, new File(FILE_NAME));
		} catch (JAXBException e) {
			e.printStackTrace();
			throw e;
		}
	}

	public static void jaxbTable2ToXML(Table2 t1) {
		try {
			JAXBContext context = JAXBContext.newInstance(Table2.class);
			Marshaller m = context.createMarshaller();

			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

			m.marshal(t1, new File(FILE_NAME));
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

	public static void jaxbTable3ToXML(Table3 t1) {
		try {
			JAXBContext context = JAXBContext.newInstance(Table3.class);
			Marshaller m = context.createMarshaller();

			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

			m.marshal(t1, new File(FILE_NAME));
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

	public static String getStringTable1(Table1 t1) throws JAXBException {
		/*
		 * CustomerBean cb = new CustomerBean();
		 * 
		 * cb.setEmailId("Email"); cb.setFirstName("firstName");
		 * cb.setLastName("lastName"); cb.setPaymentMethod("paymentmethod");
		 * cb.setPhoneNo(453545345); cb.setServiceAddress("request");
		 * cb.setStatus("Provision Ready"); cb.setType("Residential");
		 * 
		 * 
		 * // t1.setCustomer_Bill_pay("asd"); // t1.setCustomer_email_id("asd");
		 * // t1.setCustomer_fname("asdads");
		 */
		String s = "";
		jaxbObjectToXML(t1);
		final String EoL = System.getProperty("line.separator");
		List<String> lines;
		try {
			lines = Files.readAllLines(Paths.get(FILE_NAME),
					Charset.defaultCharset());
			StringBuilder sb = new StringBuilder();
			for (String line : lines) {
				if(!line.equals("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>"))
					sb.append(line).append(EoL); }
					final String content = sb.toString();
					s = content;
					// System.out.println(content);
					} catch (IOException e) {
			e.printStackTrace();
		}
		return s;
	}

	public static String getStringTable2(Table2 t1) {
		String s = "";
		jaxbTable2ToXML(t1);
		final String EoL = System.getProperty("line.separator");
		List<String> lines;
		try {
			lines = Files.readAllLines(Paths.get(FILE_NAME),
					Charset.defaultCharset());
			StringBuilder sb = new StringBuilder();
			for (String line : lines) {
				if(!line.equals("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>"))
					sb.append(line).append(EoL); }
					final String content = sb.toString();
					s = content;
					// System.out.println(content);
					} catch (IOException e) {
			e.printStackTrace();
		}
		return s;
	}

	public static String getStringTable3(Table3 t1) {
		String s = "";
		jaxbTable3ToXML(t1);
		final String EoL = System.getProperty("line.separator");
		List<String> lines;
		try {
			lines = Files.readAllLines(Paths.get(FILE_NAME),
					Charset.defaultCharset());
			StringBuilder sb = new StringBuilder();
			for (String line : lines) {
				if(!line.equals("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>"))
					sb.append(line).append(EoL); }
					final String content = sb.toString();
					s = content;
					// System.out.println(content);
					} catch (IOException e) {
			e.printStackTrace();
		}
		return s;
	}
}