package api.ashish.androidactionkit.actions;

import java.util.Map;

import android.content.Context;

public class BrightnessAction 
{
	private Context context = null;


	public void onCreate(Context context)
	{
		this.context = context;
	}

	public void perform(Map<String, Object> brightnessData)
	{

		// Change the Brightness
		String action = (String)brightnessData.get("action");
		if ( "HIGH".equals(action) )
		{
			android.provider.Settings.System.putInt(this.context.getContentResolver(),
					android.provider.Settings.System.SCREEN_BRIGHTNESS, 100);
		}
		else if ( "LOW".equals(action) )
		{
			android.provider.Settings.System.putInt(this.context.getContentResolver(),
					android.provider.Settings.System.SCREEN_BRIGHTNESS, 10);
		}
	}

	public void onDestroy()
	{
	}
}
