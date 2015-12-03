package api.ashish.androidactionkit.actions;

import java.util.Map;

import android.content.Context;
import android.os.Vibrator;

/**
 * Action to Vibrate the Device
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


	
	public void onCreate(Context context)
	{
		this.context = context;
		vibrator = (Vibrator)context.getSystemService(context.VIBRATOR_SERVICE);
	}


	
	public void perform(Map<String, Object> data)
	{
		if ( null != vibrator )
		{
			vibrator.vibrate(2000);

		}
	}


	
	public void onDestroy()
	{
		vibrator = null;

	}

}
