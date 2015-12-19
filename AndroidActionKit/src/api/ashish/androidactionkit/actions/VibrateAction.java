package api.ashish.androidactionkit.actions;

import android.content.Context;
import android.os.Vibrator;

/**
 * Action to Vibrate the device for a particular period.
 * 
 *  
 * <code>
 * 	<ul>	
 *		VibrateAction action = new VibrateAction(context);
 * 		<br>action.perform(2000);
 * 	</ul>
 * </code>
 * 
 * <br>
 * <li>
 * USES-PERMISSION: android.permission.VIBRATE
 * </li>
 * <br>
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
	public VibrateAction(Context context)
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
