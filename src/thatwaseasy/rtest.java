package ace.thatwaseasy;

import android.view.View;
import android.view.MotionEvent;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.RadialGradient;
import android.util.AttributeSet;
import android.util.Log;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;

public class rtest extends View {
	private Paint paint;
	private int size;
	private int width, height;
	private static final String TAG = "MyLog";
	private Bitmap woodbm;
	private BitmapShader woodshader;
	private Bitmap easybm;
	private BitmapShader easyshader;
	private Context context_save;

	public rtest(Context context, AttributeSet attrs) {
		super(context, attrs);
		context_save = context;

		// Set up default Paint values
		paint = new Paint();
		paint.setAntiAlias(true);

		// Calculate geometry
		int w = getWidth();
		int h = getHeight();
		size = Math.min(w, h);
		width = w;
		height = h;
		woodbm = BitmapFactory.decodeResource(getResources(), R.drawable.wood);
		woodshader = new BitmapShader(woodbm,
				TileMode.REPEAT, TileMode.REPEAT);
		easybm = BitmapFactory.decodeResource(getResources(), R.drawable.easy);
		easyshader = new BitmapShader(easybm,
				TileMode.CLAMP, TileMode.CLAMP);



	}
	@Override
	protected void onSizeChanged(int w, int h, int oldw, int oldh) {
		super.onSizeChanged(w, h, oldw, oldh);

		width = w;
		height = h;
	}

	@Override
	public void onDraw(Canvas canvas) {
		float mUnit = 70.0f; //200.0f;

		paint.setShader(woodshader);
		canvas.drawPaint(paint);
		float x1, y1, x2, y2;
		Matrix tm = new Matrix();
		x2 = easybm.getWidth();
		y2 = easybm.getHeight();
		x1 = (width - x2) * 0.5f;
		y1 = (height - y2) * 0.5f;
		x2 += x1;
		y2 += y1;
		tm.setTranslate(x1, y1);
		easyshader.setLocalMatrix(tm);
		paint.setShader(easyshader);
		canvas.drawRect(x1, y1, x2, y2, paint);

	}
	@Override
	public boolean onTouchEvent(MotionEvent e) {
		int action = e.getAction();
		if(action == MotionEvent.ACTION_DOWN)
		{
			MediaPlayer mp = MediaPlayer.create(context_save, R.raw.thesound);   
			mp.start();
			mp.setOnCompletionListener(new OnCompletionListener() {

				@Override
				public void onCompletion(MediaPlayer mp) {
					// TODO Auto-generated method stub
					mp.release();
				}
			});
		}
		return true;
	}
}
