package api.ashish.androidactionkit.actions;

import android.content.Context;
import android.os.Vibrator;

/**
 * Action to Send an SMS to a given Number automatically
 * 
 * <code>
 * 	<ul>	
 * 		    SmsAction action = new SmsAction();
 * 		<br> Map smsdata = new HashMap();
 * 		<br> data.put("action","type_of_action");
 * 		<br> data.put("number","phone_number");
 * 	 	<br> action.perform(data);
 * 	</ul>
 * </code>
 * 
 * @author "Ashish Kalbhor"<ashish.kalbhor@gmail.com>
 * 
 */
public class VibrateAction
{

	/**
	 * Android Application Context
	 */
	private Context context = null;

	/**
	 * Android Vibrator Service
	 */
	private Vibrator vibrator;


	/**
	 * Gets Vibrate System Service to Vibrator object.
	 * @param context
	 */
	public void onCreate(Context context)
	{
		this.context = context;
		vibrator = (Vibrator)context.getSystemService(context.VIBRATOR_SERVICE);
	}

	/**
	 * Perform the Vibration for given milliseconds
	 * @param ms
	 */
	public void perform(long ms)
	{
		if ( null != vibrator )
		{
			vibrator.vibrate(ms);
		}
	}

	/**
	 * Destroy the Vibrator object.
	 */
	public void onDestroy()
	{
		vibrator = null;
	}

}
