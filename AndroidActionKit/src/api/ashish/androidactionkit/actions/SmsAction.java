package api.ashish.androidactionkit.actions;

import java.util.Map;

import android.content.Context;
import android.telephony.SmsManager;

/**
 * Action to Send an SMS to a given Number automatically
 * 
 * <code>
 * 	<ul>	
 *		SmsAction action = new SmsAction(context);
 *		Map<String, Object> data = new Map<String, Object>();
 *		data.put("message", "SMS MESSAGE");
 *		data.put("number", "SMS NUMBER");
 * 		<br>action.perform(data);
 * 	</ul>
 * </code>
 * 
 * <br>
 * <li>
 * USES-PERMISSION: android.permission.SEND_SMS
 * </li>
 * <br>
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

	/**
	 * Gets SMSManager services.
	 * @param context
	 */
	public SmsAction(Context context)
	{
		this.context = context;
		this.smsmgr = SmsManager.getDefault();
	}

	/**
	 * Perform the Sms Send action with given message to given number.
	 * @param ms
	 */
	public void perform(Map<String, Object> smsData)
	{
		String action = (String)smsData.get("message");
		String mNumber = (String)smsData.get("number");
		
		this.smsmgr.sendTextMessage(mNumber, null, action, null, null);
	}

	/**
	 * Destroy the SmsManager object.
	 */
	public void onDestroy()
	{
		this.smsmgr = null;
	}

}
