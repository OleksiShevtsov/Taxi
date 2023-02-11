package main.java.parsers;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.sql.Date;
import java.text.SimpleDateFormat;

public class DateAdapter extends XmlAdapter<String, Date> {
    @Override
    public Date unmarshal(String date) throws Exception {
        return (Date) new SimpleDateFormat("dd-MM-yyyy").parse(date);
    }

    @Override
    public String marshal(Date date) throws Exception {
        return new SimpleDateFormat("dd-MM-yyyy").format(date);
    }
}
