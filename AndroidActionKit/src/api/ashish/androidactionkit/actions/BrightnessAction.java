package api.ashish.androidactionkit.actions;

import java.util.Map;

import android.content.Context;

public class BrightnessAction 
{
	/**
	 *  Android Context
	 */
	private Context context = null;

	/**
	 * Save the context onCreate
	 * @param context
	 */
	public void onCreate(Context context)
	{
		this.context = context;
	}

	/**
	 * Perform the Brightness action based on incoming data.
	 * 
	 * @param brightnessData
	 */
	public void perform(String brightnessData)
	{
		// TODO Add different levels of Brightness. Gradient.
		// Change the Brightness
		//String action = (String)brightnessData.get("action");
		if ( "HIGH".equals(brightnessData) )
		{
			android.provider.Settings.System.putInt(this.context.getContentResolver(),
					android.provider.Settings.System.SCREEN_BRIGHTNESS, 100);
		}
		else if ( "LOW".equals(brightnessData) )
		{
			android.provider.Settings.System.putInt(this.context.getContentResolver(),
					android.provider.Settings.System.SCREEN_BRIGHTNESS, 10);
		}
	}

	/**
	 * Events to be done on Destroy.
	 */
	public void onDestroy()
	{
		// Do nothing for now.
	}
}
