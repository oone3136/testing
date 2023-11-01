package com.Test.praktek.component;

import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class InvoiceGenerator {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMyyyy");
    private static int counter = 1;

    public String generateInvoiceNumber(Date createdOn) {
        String datePart = dateFormat.format(createdOn);
        String counterPart = String.format("%03d", counter);
        counter++;
        return "INV" + datePart + "-" + counterPart;
    }
}
