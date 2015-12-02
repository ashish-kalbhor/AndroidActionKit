package api.ashish.androidactionkit.actions;

import java.util.Map;

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


	/*
	 * (non-Javadoc)
	 * @see org.punegdg.kinosense.actions.BaseAction#onCreate(android.content.Context )
	 */
	public void onCreate(Context context)
	{
		this.context = context;
		vibrator = (Vibrator)context.getSystemService(context.VIBRATOR_SERVICE);
	}


	/*
	 * (non-Javadoc)
	 * @see org.punegdg.kinosense.actions.BaseAction#perform(java.lang.String, java.lang.String)
	 */
	public void perform(Map<String, Object> data)
	{
		if ( null != vibrator )
		{
			vibrator.vibrate(2000);

		}
	}


	/*
	 * (non-Javadoc)
	 * @see org.punegdg.kinosense.actions.BaseAction#onDestroy()
	 */
	public void onDestroy()
	{
		vibrator = null;

	}

}
