package api.ashish.androidactionkit.actions;

import java.util.Map;

import android.content.Context;
import android.content.Intent;

public class EmailAction 
{
	/**
	 * Android Application Context
	 */
	private Context context = null;

	/**
	 * Gets the context of application.
	 * @param context
	 */
	public EmailAction(Context context)
	{
		this.context = context;
	}

	/**
	 * Returns the Intent that will be started to send the email.
	 * <br>
	 * Usage:
	 * <br>
	 * <code>
	 * 	startActivity(Intent.createChooser(emailIntent, "Choose an Email client :"));
	 * </code>
	 * @param emailData
	 */
	public Intent perform(Map<String, Object> emailData)
	{
		String emailId = (String)emailData.get("id");
		String subject = (String)emailData.get("subject");
		String content = (String)emailData.get("content");
		
		Intent emailIntent = new Intent(Intent.ACTION_SEND);
		emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{ emailId});
		emailIntent.putExtra(Intent.EXTRA_SUBJECT, subject);
		emailIntent.putExtra(Intent.EXTRA_TEXT, content);
		//need this to prompts email client only
		emailIntent.setType("message/rfc822");
	  
		return emailIntent;
	}

	/**
	 * Do Nothing in destroy.
	 */
	public void onDestroy()
	{
		// Do nothing
	}
}
