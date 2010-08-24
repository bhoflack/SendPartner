package com.melexis.partner;

import javax.jms.BytesMessage;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import com.melexis.partner.model.Wafermap;

public class WaferSenderImpl implements WaferSender {

    private JmsTemplate jmsTemplate;
    
    public JmsTemplate getJmsTemplate() {
        return jmsTemplate;
    }

    public void setJmsTemplate(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public void sendWafer(final Wafermap w) {
	jmsTemplate.send(new MessageCreator() {
	    public Message createMessage(Session session) {
		BytesMessage message = null;
		
		try {
        		message = session.createBytesMessage();
        		message.writeBytes(w.getWafermap());
        		message.setStringProperty("lotName", w.getLotname());
        		message.setIntProperty("waferNumber", w.getWaferNumber());
        		message.setIntProperty("totalWafersInLot", 5);
        		message.setStringProperty("condition", "");
        		message.setStringProperty("devicename", w.getDevicename());
        		message.setStringProperty("item", w.getItem());
        		message.setStringProperty("partner", w.getPartner());
		} catch (JMSException e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		}
		
		return message;
	    }
	});
    }


}
