package api.ashish.androidactionkit.actions;

import java.util.Calendar;

import android.R;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import api.ashish.androidactionkit.MainActivity;

/**
 * 
 * Action which shows notification after each new trigger.
 * 
 *  @author "Ashish Kalbhor" <ashish.kalbhor@gmail.com>
 */

public class NotificationAction
{

	private Context context = null;

	NotificationManager notifymgr = null;


	public void onCreate(Context context)
	{
		this.context = context;
		this.notifymgr = (NotificationManager)this.context.getSystemService(Context.NOTIFICATION_SERVICE);
	}

	public void perform(String NotifyData)
	{
		String message = NotifyData;
		
		Intent resultIntent = new Intent(this.context, MainActivity.class);
		PendingIntent resultPendingIntent = PendingIntent.getActivity(this.context, 0, resultIntent,
				Intent.FLAG_ACTIVITY_NEW_TASK);

		int smallIcon = R.drawable.alert_dark_frame;

		NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this.context);
		mBuilder.setContentTitle("Notification Action")
		             .setContentText(message)
    	             .setSmallIcon(smallIcon)
		              .setLights(0xFFFF0000, 500, 500) ;
		
		mBuilder.setContentIntent(resultPendingIntent);
		
	         mBuilder.setAutoCancel(true);  //for clearing notification automatically
         
		this.notifymgr.notify((int)Calendar.getInstance().getTimeInMillis(), mBuilder.getNotification());

	}


	public void onDestroy()
	{
		this.notifymgr = null;
	}

}
