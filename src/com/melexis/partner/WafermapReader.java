package com.melexis.partner;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class WafermapReader {

    public static byte[] readWafermap(String filename) throws IOException {
	InputStream is = new FileInputStream(new File(filename));
	
	byte[] map = new byte[is.available()];
	is.read(map);
	
	return map;
    }
}
