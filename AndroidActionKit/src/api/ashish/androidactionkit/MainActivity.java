package api.ashish.androidactionkit;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
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
		
		testVibrate(test, context);
		
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
	
}
