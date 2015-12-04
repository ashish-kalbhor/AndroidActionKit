package api.ashish.androidactionkit.actions;

import java.util.Map;

import android.content.Context;
import android.content.SharedPreferences;
import android.media.AudioManager;
import android.preference.PreferenceManager;

/**
 * 
 * Performs the action to turn device on Silent Mode.
 * @author Ashish
 *
 */
public class SilentAction 
{
	/**
	 * Android Application Context
	 */
	private Context context = null;
	/**
	 * Audio Manager used to change the ringer volume
	 */
	
	

	public void onCreate(Context context)
	{
		this.context = context;		
	}


	public void perform(Map<String, Object> data)
	{
		int lastVolume = 0; // Contains info of last volume		
		SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(context);
		SharedPreferences.Editor editor = pref.edit();		
		AudioManager audioManager =  (AudioManager)context.getSystemService(context.AUDIO_SERVICE);		
		String action = (String)data.get("action");
		if ( "Silence".equals(action) )
		{
			// Store device's volume level.
			lastVolume = audioManager.getStreamVolume(AudioManager.STREAM_RING);
			editor.putInt("volume", lastVolume);
            
			// Device's volume set to zero.
			audioManager.setStreamVolume(AudioManager.STREAM_RING, 0, AudioManager.FLAG_SHOW_UI
					+ AudioManager.FLAG_PLAY_SOUND);
			
			editor.commit();
		}
		else if ( "Restore".equals(action) )
		{
			// Device's volume restored.
			int currentVolume = pref.getInt("volume", 7);
			audioManager.setStreamVolume(AudioManager.STREAM_RING, currentVolume, AudioManager.FLAG_SHOW_UI
					+ AudioManager.FLAG_PLAY_SOUND);
		}	
	}


	public void onDestroy()
	{
		
	}
}
