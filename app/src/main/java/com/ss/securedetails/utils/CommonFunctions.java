package com.ss.securedetails.utils;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

/**This class is used to add functions that are used at mutiple places in the code
 * @author Vishal
 *
 */
public class CommonFunctions {

	private static final String TAG = CommonFunctions.class.getSimpleName();
	public static String m_ISO8601Local = "yyyy-MM-dd'T'HH:mm:ss.sss'Z'";

	public static String Date_yyyymmdd = "yyyy-MM-dd";
	public static String Date_yyyymmddhhmmss = "yyyy-MM-dd HH:mm:ss";
	public static String Date_hh_mm_a= "h:mm a";
	public static String Date_EEE_MMM_dd_yyyy = "EEE',' MMM dd yyyy";
	public static String Date_dd_MMM_h_mm_a = "dd MMM',' h:mm a";

	public static int randInt(int min, int max) {
		// NOTE: Usually this should be a field rather than a method
		// variable so that it is not re-seeded every call.
		Random rand = new Random();
		// nextInt is normally exclusive of the top value,
		// so add 1 to make it inclusive
		int randomNum = rand.nextInt((max - min) + 1) + min;

		return randomNum;
	}

	/**
	 * @param value Value to round up
	 * @param places Upto decimal places Should be non zero
	 * @return Rounded Value
	 */
	public static double MakeRound(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();

	    BigDecimal bd = new BigDecimal(value);
	    bd = bd.setScale(places, RoundingMode.HALF_UP);
	    return bd.doubleValue();
	}
	  
	/**formateDateFromstring(String inputFormat, String outputFormat, String inputDate)
	 * @param inputFormat specifies input format of date
	 * @param outputFormat format of the output
	 * @param inputDate	current value of date with input format
	 * @return date in output format
	 */
	public static String formateDateFromstring(String inputFormat, String outputFormat, String inputDate){

        Date parsed = null;
        String outputDate = "";

        SimpleDateFormat df_input = new SimpleDateFormat(inputFormat, Locale.getDefault());
        SimpleDateFormat df_output = new SimpleDateFormat(outputFormat, Locale.getDefault());

        try {
            parsed = df_input.parse(inputDate);
            outputDate = df_output.format(parsed);

        } catch (ParseException e) {
            MyLog.e("TAG", "ParseException - dateFormat");
            outputDate = inputDate;
        } 

        return outputDate;
    }
	
	public static String capitaliseFirst(String name) {
		try {
			String[] test = name.split(" ");
			String result = "";
			String cap = "";
			for(int i=0;i<test.length;i++){
				cap =  test[i];
				result += cap.substring(0,1).toUpperCase(Locale.US) + cap.substring(1).toLowerCase(Locale.US)+" ";
			}

			return result;
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return name;
	}
	
	
	/**formateDateFromstring(String inputFormat, String outputFormat, String inputDate)
	 * @param outputFormat format of the output
	 * @param inputDate	current value of date with input format
	 * @return date in output format
	 */
	public static String formateDate(String outputFormat, Date inputDate){

        Date parsed = null;
        String outputDate = "";
        
        SimpleDateFormat df_output = new SimpleDateFormat(outputFormat, Locale.getDefault());

        try {
            parsed = inputDate;
            outputDate = df_output.format(parsed);

        } catch (Exception e) {
            MyLog.e("TAG", "ParseException - dateFormat");
        } 

        return outputDate;
    }
	
	/**This function is used to check if the time supplied has already occurred or not
	 * @param time Time to check against current time format yyyy-MM-dd HH:mm:ss
	 * @return true is already passed false if not occurred
	 */
	public static Boolean hasTimepassed(String time)
	{
		boolean hasPassed = false;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
		Date date;
		try {
			date 	= simpleDateFormat.parse(time);
			
			long check_time= date.getTime();
	        long current_time = new Date().getTime();
			
	        long difference	=	current_time-check_time;		//POSITIVE IF ALREADY OCCURED		
	        hasPassed = (difference>0);
	        
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return hasPassed;
	}


	/**This function is used to check if the time supplied has already occurred or not
	 * @param time Time to check against current time format yyyy-MM-dd HH:mm:ss
	 * @return true is already passed false if not occurred
	 */
	public static Boolean hasTimepassed(String time, String format)
	{
		boolean hasPassed = false;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format, Locale.getDefault());
		Date date;
		try {
			date 	= simpleDateFormat.parse(time);

			long check_time= date.getTime();
			long current_time = new Date().getTime();

			long difference	=	current_time-check_time;		//POSITIVE IF ALREADY OCCURED
			hasPassed = (difference>0);

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return hasPassed;
	}
	
	/**This function is used to check if the time supplied has already occurred or not
	 * @param time Time to check against current time format yyyy-MM-dd HH:mm:ss
	 * @return true is already passed false if not occurred
	 */
	public static Date GetDate(String time)
	{
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
		Date date = null;
		try {
			date 	= simpleDateFormat.parse(time);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return date;
	}

    /**This function is used to check if the time supplied has already occurred or not
     * @param time Time to check against current time format yyyy-MM-dd HH:mm:ss
     * @return true is already passed false if not occurred
     */
    public static Date GetDate(String time, String format)
    {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format, Locale.getDefault());
        Date date = null;
        try {
            date 	= simpleDateFormat.parse(time);
        } catch (ParseException e) {
            date = new Date();
            e.printStackTrace();
        }
        return date;
    }
	
	/**This function is used to check if the time supplied has already occurred or not
	 * @param time Time to check against current time format yyyy-MM-dd HH:mm:ss
	 * @return true is already passed false if not occurred
	 */
	public static Boolean hasTimepassed(Date time)
	{
		boolean hasPassed = false;	
		Date date;
		date = time;
		
		long check_time= date.getTime();
		long current_time = new Date().getTime();
		
		long difference	=	current_time-check_time;		//POSITIVE IF ALREADY OCCURED		
		hasPassed = (difference>0);		
		return hasPassed;
	}
	
	
	/**This function is used to check if the time is between from and to
	 * @param valid_from
	 * @param valid_to
	 * @param format format of to and from
	 */
	public static boolean NowBetween(String valid_from, String valid_to, String format) {
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format, Locale.getDefault());
		Date dateTo = null;
		Date dateFrom = null;
		 
		long current_time = new Date().getTime();
		long to,from;
		
		try {
			dateTo 		= simpleDateFormat.parse(valid_to);
			dateFrom 	= simpleDateFormat.parse(valid_from);
			
			to = dateTo.getTime();
			from = dateFrom.getTime();
			
			return ((from<=current_time)&&(current_time<=to));
			
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return false;
		
	}

	


	/**This function if d2 more than d1
	 * @param d1 start
	 * @param d2 end
	 * @param format chosen format
	 * @return
	 */
	public static boolean hasTimepassed(String d1, String d2, String format) {

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format, Locale.getDefault());
		Date date1 = null;
		Date date2 = null;
		boolean hasPassed = true;
		try {
			date1 	= simpleDateFormat.parse(d1);
			date2 	= simpleDateFormat.parse(d2);
			
			long check_time= date1.getTime();
	        long current_time =date2.getTime();
			
	        long difference	=	current_time-check_time;		//POSITIVE IF ALREADY OCCURED		
	        hasPassed = (difference>=0);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}			
		return hasPassed;
	}
	
	public static double calculateDistance(double lat1, double lon1, double lat2, double lon2) 
    {
          double theta = lon1 - lon2;
          double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
          dist = Math.acos(dist);
          dist = rad2deg(dist);
          dist = dist * 60 * 1.1515;         
          dist = dist * 1.609344;
          
          dist = dist*100;
          dist = Math.round(dist);
          dist = dist/100;
          
          return (dist);
    }
    
	public static void setListViewHeightBasedOnChildren(ListView listView) {
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null) {
            // pre-condition
            return;
        }

        int totalHeight = 10;
        for (int i = 0; i < listAdapter.getCount(); i++) {
            View listItem = listAdapter.getView(i, null, listView);
            listItem.measure(0, 0);
            totalHeight += listItem.getMeasuredHeight();
        }

        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);
    }
	
    private static double deg2rad(double deg) 
    {
      return (deg * Math.PI / 180.0);
    }
    
    private static double rad2deg(double rad)
    {
      return (rad * 180.0 / Math.PI);
    }


	/**
	 * @param input_time
	 * @param defaultTimeFormat
	 * @param requiredTimeFormat
	 */
	public static String ChangeTime(String input_time, String defaultTimeFormat, String requiredTimeFormat) {

        Date parsed = null;
        String outputDate = "";

        SimpleDateFormat df_input = new SimpleDateFormat(defaultTimeFormat, Locale.getDefault());
        SimpleDateFormat df_output = new SimpleDateFormat(requiredTimeFormat, Locale.getDefault());

        try {
            parsed = df_input.parse(input_time);
            outputDate = df_output.format(parsed);
            
			if(outputDate.contains("AM")) {
				outputDate = outputDate.replace("AM", "am");
			} else if(outputDate.contains("PM")) {
				outputDate = outputDate.replace("PM", "pm");
			}

            
        } catch (ParseException e) {
            MyLog.e("TAG", "ParseException - dateFormat");
        } 

        return outputDate;		
	}
	
	
	/**
	 * @param date	Date To check
	 * @param dateformat	Date Format
	 * @param valid_from	from Date
	 * @param valid_to	to Date
	 * @param validformat	format
	 * @return
	 */
	public static boolean TimeBetween(String date, String dateformat, String valid_from, String valid_to, String validformat) {

		SimpleDateFormat validDateFormat = new SimpleDateFormat(validformat, Locale.getDefault());
		SimpleDateFormat DateFormat = new SimpleDateFormat(dateformat, Locale.getDefault());
		
		Date dateTo = null;
		Date dateFrom = null;
		Date datenow = null;
		
		long current_time;
		long to,from;
		
		try {
			dateTo 		= validDateFormat.parse(valid_to);
			dateFrom 	= validDateFormat.parse(valid_from);
			datenow 	= DateFormat.parse(date);
			
			current_time = datenow.getTime();
			to = dateTo.getTime();
			from = dateFrom.getTime();
			
			return ((from<=current_time)&&(current_time<=to));
			
			
		} catch (ParseException e) {
			e.printStackTrace();
		}		
		return false;
		
	}

	/**
	 * @param date Date To check 
	 * @param format Format of Date
	 * @return
	 */
	public static boolean IsDateToday(String date, String format) {
		
		String DefaultFormat = "dd-MM-yyyy";
		
				
		Date currentDate = new Date();
		String Today = formateDate(DefaultFormat, currentDate);	//GOT TODAY DATE IN DefaultFormat
		String check = formateDateFromstring(format, DefaultFormat, date);//GOT CHECK DATE IN DefaultFormat
		
		Date dateCheck = null;
		Date datenow = null;
		
		long current_time;
		long check_time;
		
		SimpleDateFormat DateFormat = new SimpleDateFormat(DefaultFormat, Locale.getDefault());
		try {
			dateCheck 	= DateFormat.parse(check);
			datenow 	= DateFormat.parse(Today);
			
			current_time = datenow.getTime();
			check_time = dateCheck.getTime();
			
			return ((check_time==current_time));
			
			
		} catch (ParseException e) {
			e.printStackTrace();
		}		
		
		return false;
	}

	/**
	 * @param date1 Date To check
	 * @param date2 Date To check
	 * @param format Format of Date
	 * @return
	 */
	public static boolean IsDateSame(String date1, String date2, String format) {


		Date dateCheck = null;
		Date datenow = null;

		long current_time;
		long check_time;

		SimpleDateFormat DateFormat = new SimpleDateFormat(format, Locale.getDefault());
		try {
			dateCheck 	= DateFormat.parse(date1);
			datenow 	= DateFormat.parse(date2);

			current_time = datenow.getTime();
			check_time = dateCheck.getTime();

			return ((check_time==current_time));


		} catch (ParseException e) {
			e.printStackTrace();
		}

		return false;
	}

	public static String printTimeDifference(long different){

		//milliseconds

		long secondsInMilli = 1000;
		long minutesInMilli = secondsInMilli * 60;
		long hoursInMilli = minutesInMilli * 60;
		long daysInMilli = hoursInMilli * 24;

		long elapsedDays = different / daysInMilli;
		different = different % daysInMilli;

		long elapsedHours = different / hoursInMilli;
		different = different % hoursInMilli;

		long elapsedMinutes = different / minutesInMilli;
		different = different % minutesInMilli;

		long elapsedSeconds = different / secondsInMilli;

		String res = "";
		if(elapsedDays != 0) {
			res = String.format("%d d, %d h, %d m, %d s%n",
					elapsedDays, elapsedHours, elapsedMinutes, elapsedSeconds);
		}else if(elapsedHours != 0 ){
			res = String.format("%d h, %d m, %d s%n", elapsedHours, elapsedMinutes, elapsedSeconds);
		}else if(elapsedMinutes != 0 ){
			res = String.format("%d m, %d s%n", elapsedMinutes, elapsedSeconds);
		}else{
			res = String.format("%d s%n", elapsedSeconds);
		}

		/*System.out.printf(
				"%d days, %d hours, %d minutes, %d seconds%n",
				elapsedDays,
				elapsedHours, elapsedMinutes, elapsedSeconds);*/
		MyLog.e(TAG, "Final " + res);
		return res;
	}

	public static String printTimeDifference(long startDate, long endDate){

		//milliseconds
		long different = endDate - startDate;

		MyLog.e(TAG, "startDate : " + startDate);
		MyLog.e(TAG, "endDate : " + endDate);
		MyLog.e(TAG, "different : " + different);

		long secondsInMilli = 1000;
		long minutesInMilli = secondsInMilli * 60;
		long hoursInMilli = minutesInMilli * 60;
		long daysInMilli = hoursInMilli * 24;

		long elapsedDays = different / daysInMilli;
		different = different % daysInMilli;

		long elapsedHours = different / hoursInMilli;
		different = different % hoursInMilli;

		long elapsedMinutes = different / minutesInMilli;
		different = different % minutesInMilli;

		long elapsedSeconds = different / secondsInMilli;

		String res = String.format("%d days, %d hours, %d minutes, %d seconds%n",
				elapsedDays,
				elapsedHours, elapsedMinutes, elapsedSeconds);

		/*System.out.printf(
				"%d days, %d hours, %d minutes, %d seconds%n",
				elapsedDays,
				elapsedHours, elapsedMinutes, elapsedSeconds);*/
		MyLog.e(TAG, "Final " + res);
		return res;
	}

	public static long DateDiff(String event, String current) {

		SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		// format.setTimeZone(TimeZone.getTimeZone("IST"));

		Date d1 = null;
		Date d2 = null;

		long diff = 0;
		try {
			d1 = format.parse(event);
			d2 = format.parse(current);

			MyLog.e("dssp", "d1 " + d1);
			MyLog.e("dssp", "d2 " + d2);

			//in milliseconds
			diff = d1.getTime() - d2.getTime();
			if (diff > 0) {

				long diffSeconds = diff / 1000 % 60;
				long diffMinutes = diff / (60 * 1000) % 60;
				long diffHours = diff / (60 * 60 * 1000) % 24;
				long diffDays = diff / (24 * 60 * 60 * 1000);

				MyLog.e("diff", diffDays + " days, ");
				MyLog.e("diff", diffHours + " hours, ");
				MyLog.e("diff", diffMinutes + " minutes, ");
				MyLog.e("diff", diffSeconds + " seconds.");
			} else {


				MyLog.e("Times up", "times up");
			}

		} catch (Exception e) {
			e.printStackTrace();
			MyLog.e("dssp", "format" + e.getMessage());
		}
		return diff;


	}
		
}
