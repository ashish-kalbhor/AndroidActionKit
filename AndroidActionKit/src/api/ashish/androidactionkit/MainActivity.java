package api.ashish.androidactionkit;

import java.util.HashMap;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import api.ashish.androidactionkit.actions.SmsAction;
import api.ashish.androidactionkit.actions.VibrateAction;

public class MainActivity extends Activity
{
	Context context = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		context = getApplicationContext();
		
		Button test = (Button)findViewById(R.id.testButton);	
		
		// testVibrate(test, context);
		testSms(test, context);
		
	}
	
	/**
	 * Create Test Vibrate Action
	 * @param b
	 * @param context
	 */
	public void testVibrate(Button b, Context context)
	{
		final VibrateAction vibe = new VibrateAction(context);
				
		b.setOnClickListener(new OnClickListener() 
		{			
			@Override
			public void onClick(View v) 
			{
				vibe.perform(200);
			}
		});
		//vibe.onDestroy();
	}
	
	/**
	 * Create Test Sms Action
	 * @param b
	 * @param context
	 */
	public void testSms(Button b, Context context)
	{
		final SmsAction vibe = new SmsAction(context);
				
		b.setOnClickListener(new OnClickListener() 
		{			
			@Override
			public void onClick(View v) 
			{
				HashMap<String, Object> smsData = new HashMap<String, Object>();
				smsData.put("message", "Testing Library");
				smsData.put("number", "6176526740");
				vibe.perform(smsData);
			}
		});
	}
	
}
