package com.melexis.partner.model;

import java.io.File;

public class Wafermap
{

    private Integer id;
    private String filename;
    private boolean valid = false;
    private String validationMsg;
    private byte[] wafermap;
    
    private String lotname;
    private String devicename;
    private String partner;
    private Integer waferNumber;
    private String item;
    

    public final static String INK_TH01 = "wafermap does not contain INK_TH01 marker";
    public final static String NUMBER_OF_DIES = "number of dies is different from ERP system";
    public final static String PASS = "pass";
    public final static String ROW_COL_SMALLER_THEN_EXPECTED = "row/col < expected";
    public final static String ROW_COL_SWAPPED = "row/col swapped";
    public final static String ROW_COL_GREATER_THEN_EXPECTED = "row/col > expected";
    public final static String OTHER = "unknown";

    public String getFilename()
    {
	return filename;
    }
    
    public void setFilename(String filename)
    {
	this.filename = filename;
    }
    
    public void setWafermap(byte[] wafermap)
    {
	this.wafermap = wafermap;
    }
    
    public byte[] getWafermap() {
	return wafermap;
    }

    public String getFileWithoutPath()
    {
	File file = new File(filename);
	return file.getName();
    }


    public Integer getId() {
	return id;
    }
    public void setId(Integer id) {
	this.id = id;
    }

    public boolean isValid() {
	return valid;
    }
    public void setValid(boolean valid) {
	this.valid = valid;
    }
    public String getValidationMsg() {
	return validationMsg;
    }
    public void setValidationMsg(String validationMsg) {
	this.validationMsg = validationMsg;
    }

    public String getLotname() {
        return lotname;
    }

    public void setLotname(String lotname) {
        this.lotname = lotname;
    }

    public String getDevicename() {
        return devicename;
    }

    public void setDevicename(String devicename) {
        this.devicename = devicename;
    }

    public String getPartner() {
        return partner;
    }

    public void setPartner(String partner) {
        this.partner = partner;
    }

    public Integer getWaferNumber() {
        return waferNumber;
    }

    public void setWaferNumber(Integer waferNumber) {
        this.waferNumber = waferNumber;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

}
