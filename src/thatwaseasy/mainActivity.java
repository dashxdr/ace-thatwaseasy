package ace.thatwaseasy;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.app.Activity;
import android.util.DisplayMetrics;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Display;
import android.graphics.Point;
import java.lang.System;
import java.util.Properties;
import java.util.Set;
import java.util.Iterator;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.net.Uri;

public class mainActivity extends Activity
{
	private rtest myrtest;
	private static final String TAG = "MyLog";
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		if(false)
		{
			Properties props = System.getProperties();
			Set set = props.stringPropertyNames();
			Iterator it = set.iterator();
			while(it.hasNext())
			{
				Object v = it.next();
				Log.d(TAG, "something: " + v + "=" + System.getProperty(v.toString()));
			}
		}
//Log.d(TAG, "

//		myrtest = (rtest) findViewById(R.id.r_test);
DisplayMetrics metrics = new DisplayMetrics();
Display d = getWindowManager().getDefaultDisplay();
d.getMetrics(metrics);
Log.d(TAG, "density=" + metrics.density);
Log.d(TAG, "densityDpi=" + metrics.densityDpi);
Log.d(TAG, "widthPixels=" + metrics.widthPixels);
Log.d(TAG, "heightPixels=" + metrics.heightPixels);
Log.d(TAG, "scaledDensity=" + metrics.scaledDensity);
Log.d(TAG, "xdpi=" + metrics.xdpi);
Log.d(TAG, "ydpi=" + metrics.ydpi);

Point p = new Point();
d.getSize(p);
Log.d(TAG, "p.x = " + p.x);
Log.d(TAG, "p.y = " + p.y);
Log.d(TAG, "refreshrate = " + d.getRefreshRate());

	}

	private static final int ITEM_TEST_0 = 0;
	private static final int ITEM_TEST_1 = 1;
@Override
	 public boolean onCreateOptionsMenu(Menu menu) {
		menu.add(Menu.NONE, ITEM_TEST_0, 0, "Help");
		menu.add(Menu.NONE, ITEM_TEST_1, 0, "About");
//		menu.add(Menu.NONE, ITEM_VISIT_IMDB, 0,
//			getString(R.string.visit_imdb)).setIcon(android.R.drawable.ic_menu_set_as);
//		menu.add(Menu.NONE, ITEM_VIEW_FULL_IMAGE, 0,
//			getString(R.string.view_full_image)).setIcon(android.R.drawable.ic_menu_zoom);
		return super.onCreateOptionsMenu(menu);
	 }

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
			case ITEM_TEST_0:
				Log.d(TAG, "menu 0 pressed");
				return true;
			case ITEM_TEST_1:
				Log.d(TAG, "menu 1 pressed");
				String abouturl = "http://www.xdr.com/acedash";
				Intent aboutintent = new Intent(Intent.ACTION_VIEW, Uri.parse(abouturl));
				startActivity(aboutintent);
				return true;
		}
		return false;
	}


}
