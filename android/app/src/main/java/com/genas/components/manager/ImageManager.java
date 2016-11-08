package com.genas.components.manager;

import java.util.HashMap;
import java.util.Iterator;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

import com.genas.R;
import com.genas.components.list.SimpleAdapter;


/**
 * This class manages network image download requests. It's also responsible for 
 * showing and hiding image loading indicator. 
 */
public final class ImageManager {

	/** The constant logging tag. */
	public static final String TAG = ImageManager.class.getName();

	/** The singleton instance. */
	private static ImageManager instance;

	/** Active download tasks . */
	private HashMap<String, DownloadTask> tasks;

	/** Image cache implementation. */
	private ImageCacheMap cache;

	/**
	 * Instantiates a new image manager.
	 */
	private ImageManager() {
		tasks = new HashMap<String, DownloadTask>();
		Context context = ContextHolder.getInstance().getContext();
		Resources resources = context.getResources();
		String expiration = resources.getString(R.string.cacheImageExpirationTime);
		String sizeImage = resources.getString(R.string.cacheImageSize);
		Integer cacheImageSize = Integer.valueOf(sizeImage);
		cache = new ImageCacheMap(cacheImageSize, Long.valueOf(expiration));
	}

	/**
	 * Gets the single instance of ImageManager.
	 * 
	 * @return single instance of ImageManager
	 */
	public static synchronized ImageManager getInstance() {
		if (instance == null) {
			instance = new ImageManager();
		}
		return instance;
	}

	/**
	 * Adds the task to queue.
	 * 
	 * @param consumer
	 *            image receiver
	 * @param url
	 *            image url
	 */
	private synchronized void addTask(final DownloadConsumer consumer, 
									  final String url, 
									  final boolean doCache, final View view) {
		if (!tasks.containsKey(url)) {
			DownloadTask task = new DownloadTask(this, consumer, doCache, view, url);
			task.start();
			tasks.put(url, task);
		} else {
			tasks.get(url).addConsumer(consumer);
		}
	}

	/**
	 * Cancels all download tasks.
	 */
	public synchronized void cancel() {
		Iterator<String> it = tasks.keySet().iterator();
		while (it.hasNext()) {
			DownloadTask task = tasks.get(it.next());
			task.cancel();
			task.interrupt();
		}
		tasks.clear();
	}

	/**
	 * Completes given task and caches result.
	 * 
	 * @param url
	 *            image url
	 * @param result
	 *            downloaded image
	 */
	public synchronized void complete(final Object result, final String url, final boolean doCache, final View view) {
		tasks.remove(url);
		if (result != null && doCache) {
			if ((view!=null) && (view.getTag(R.id.tagImageViewWidth)!=null)) {
				Bitmap res = (Bitmap) result;
				int width = Integer.parseInt(view.getTag(R.id.tagImageViewWidth).toString());
				int scaledHeight =  res.getHeight()*width/res.getWidth();
				Bitmap resizedbitmap=Bitmap.createScaledBitmap(res, 
						width, 
						scaledHeight, true);
				cache.put(url, new CacheImage(resizedbitmap));
			} else {
				if ("https://spot4books.imgix.net/images/bookcovers/9789038893846.jpg".equals(url)) {
					System.out.println("==========PUT " + url );
				}


				cache.put(url, new CacheImage((Bitmap) result));
			}
		}
	}

	/**
	 * Retrieves image from cache (if cached already) or  
	 * starts download task for image with specified URL and starts loading indication as well. 
	 * As a result view gets image set. 
	 * 
	 * @param url
	 *            image url
	 * @param view
	 *            image receiver
	 * @param adapter
	 *            view's parent adapter
	 */
	public void setImage(final String url, final ImageView view, final SimpleAdapter adapter) {
		if (cache.get(url) != null) {
			adapter.setBitmap(url, cache.get(url).getBitmap(), view);
		} else {
			// Prevent scale type override from loading indicator if fast view switch
			// (without waiting for prevoius one fully loaded) is performed.
			hideLoading(view);
			
			showLoading(view);
			
			addTask(new DownloadConsumer() {

				@Override
				public void consume(final Object object) {
					Bitmap bmp = (Bitmap) object;
					 if (bmp!=null && view.getTag(R.id.tagImageViewWidth)!=null) {
						int width = Integer.parseInt(view.getTag(R.id.tagImageViewWidth).toString());
						int scaledHeight =  bmp.getHeight()*width/bmp.getWidth();
						Bitmap resizedbitmap=Bitmap.createScaledBitmap(bmp, width, scaledHeight, true);
						adapter.setBitmap(url, resizedbitmap, view);
					 } else {
						adapter.setBitmap(url, bmp, view);
					 }
				}

				public int getType() {
					return BITMAP;
				}
			}, url, true, view);
		}
	}


	/**
	 * Shows loading indication in image waiting view.
	 * This method is used by WebImageView or implemetation of ArrayAdapter and
	 * should be invoked on UI thread.
	 *
	 *
	 * @param view
	 *            image waiting view
	 */

    public static void showLoading(final ImageView view) {
		Drawable background = view.getBackground();
		if (background != null) {
			view.setBackgroundDrawable(null);
		}

		view.setTag(R.id.tagBackground, background);
		view.setTag(R.id.tagScaleType, view.getScaleType());
		view.setImageResource(R.drawable.progress);
		view.setScaleType(ScaleType.CENTER);

		Context ctx = ContextHolder.getInstance().getContext();
		Animation rotation = AnimationUtils.loadAnimation(ctx, R.anim.rotate);
		view.startAnimation(rotation);

	}

	/**
	 * Hides loading indication in image waiting view.
	 * This method is used by WebImageView or implemetations of ArrayAdapter and
	 * should be invoked on UI thread.
	 *
	 * @param view
	 *            image waiting view
	 */

    public static void hideLoading(final ImageView view) {
		if (view!=null) {
			view.setAnimation(null);
			Drawable background = (Drawable) view.getTag(R.id.tagBackground);
			if (background != null) {
				view.setBackgroundDrawable(background);
			}
			ScaleType st = (ScaleType) view.getTag(R.id.tagScaleType);
			if (st != null) {
				view.setScaleType(st);
			}
		}
	}


	public void clearImageCache(int remainder){
		cache.clear(remainder);
	}
}
