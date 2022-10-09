package com.itg.springMVC.convert;


import org.springframework.core.convert.converter.Converter;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConvert implements Converter<String, Date> {

    @Override
    public Date convert(String s) {
        try {
            if (s != null) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                return sdf.parse(s);
            }

        } catch (Exception e) {
            System.out.println("×ª»»Òì³££¡");
        }
        return null;
    }
}
