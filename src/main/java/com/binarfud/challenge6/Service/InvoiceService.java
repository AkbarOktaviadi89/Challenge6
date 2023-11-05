package com.binarfud.challenge6.Service;
import net.sf.jasperreports.engine.JRException;

import java.io.FileNotFoundException;

public interface InvoiceService {

    byte[] generateInvoice(String username) throws FileNotFoundException, JRException;

}