package api.ashish.androidactionkit.actions;

import java.util.Map;

import android.content.Context;
import android.telephony.SmsManager;

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

public class SmsAction
{

	/**
	 * Android Application Context
	 */
	private Context context = null;

	/**
	 * SmsManager to Send an SMS from device
	 */
	SmsManager smsmgr = null;


	public void onCreate(Context context)
	{
		this.context = context;
		this.smsmgr = SmsManager.getDefault();
	}


	public void perform(Map<String, Object> smsData)
	{

		/**
		 * Type of Action will decide the Text message to be sent
		 */
		String action = (String)smsData.get("message");
		String mNumber = (String)smsData.get("number");
		
		this.smsmgr.sendTextMessage(mNumber, null, action, null, null);
	}


	public void onDestroy()
	{
		this.smsmgr = null;
	}

}
