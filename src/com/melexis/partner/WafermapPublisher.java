package com.melexis.partner;

import java.io.IOException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.melexis.partner.model.Wafermap;

public class WafermapPublisher {

    private static ApplicationContext context;
    
    public static void main(String[] args) throws IOException {
	 context = new ClassPathXmlApplicationContext("applicationContext.xml");
	 
	 if (args.length < 6) {
	     System.err.println("Invalid arguments!");
	     System.err.println(String.format("Expected format : %s <<lotname>> <<wafernumber>> <<partner>> <<device>> <<item>> <<path to wafermap>>", "sendPartner"));
	     return;
	 }
	     
	 
	 String lot = args[0];
	 Integer waferNr = Integer.parseInt(args[1]);
	 String partner = args[2];
	 String device = args[3];
	 String item = args[4];
	 String wafermap = args[5];
	 
	 Wafermap w = new Wafermap();
	 w.setWafermap(WafermapReader.readWafermap(wafermap));
	 w.setLotname(lot);
	 w.setWaferNumber(waferNr);
	 w.setPartner(partner);
	 w.setDevicename(device);
	 w.setItem(item);
	 
	 WaferSender sender = (WaferSender) context.getBean("waferSender");
	 sender.sendWafer(w);
    }
}
