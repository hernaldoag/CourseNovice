package utilities;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateUtility {

    public static String getDateFromEpoch(Double epoch, String format){
        long timestamp = Math.round(epoch);
        Date date = new Date(timestamp);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        return simpleDateFormat.format(date);
    }

    public static String getCurrentDate(){
        Date date = new Date();
        return date.toString();
    }

    public static String getCurrentDate(String format){
        DateFormat dateFormat = new SimpleDateFormat(format);
        Date date = new Date();
        return dateFormat.format(date);
    }

    public static String getCurrentDateTS(String format){
        String timeStamp = new SimpleDateFormat(format, Locale.US).format(new Date());
        // DateFormat dateFormat = new SimpleDateFormat(format);
        //Date date = new Date();
        return timeStamp;
    }

    public static String getAfterDate(String format, int days){
        DateFormat dateFormat = new SimpleDateFormat(format);
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, days);
        return dateFormat.format(calendar.getTime());
    }

    public static String getYear(String format, String date){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        Calendar calendar = null;
        try {
            Date newDate = simpleDateFormat.parse(date);
            calendar = Calendar.getInstance();
            calendar.setTime(newDate);
            return String.valueOf(calendar.get(Calendar.YEAR));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
