package com.genas.components.manager;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.View;


/**
 */
public class DownloadTask extends Thread {

	/** The constant logging tag. */
	private static final String TAG = DownloadTask.class.getName();

	/** The constant keep alive header. */
	private static final String KEEP_ALIVE = "Keep-Alive";

	/** The constant connection header. */
	private static final String CONNECTION = "Connection";

	/** The http connection. */
	private HttpURLConnection conn;
	
	private BufferedInputStream stream;

	/** The download consumers wating for data. */
	private List<DownloadConsumer> consumers;

	/** The task life-cycle manager. */
	private ImageManager manager;

	/** The download url. */
	private String url;

	private boolean cache;

	private View view;

	private boolean isCanceled = false;

	public static final int DEFAULT_BUFFER_SIZE = 8192;
	
	
	/**
	 * Instantiates a new download task.
	 * 
	 * @param pManager
	 *            task life-cycle manager
	 * @param pConsumer
	 *            download consumer wating for data
	 */
	public DownloadTask(final ImageManager pManager, final DownloadConsumer pConsumer, boolean cache, View view, String url) {
		super();
		this.consumers = new ArrayList<DownloadConsumer>();
		this.cache = cache;
		this.consumers.add(pConsumer);
		this.manager = pManager;
		this.view = view; 
		this.url = url;
	}

	@Override
	public void run() {
		Object result = null;
		try {
		switch (consumers.get(0).getType()) {
		case DownloadConsumer.BITMAP:
			result = downloadBitmap(url);
			break;
		default:
			break;
		}
		if ( result != null &&  !isCanceled) {
			for (DownloadConsumer consumer : consumers) {
				consumer.consume(result);
			}
		}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			manager.complete(result, url, cache, view);
		}
	}


	/**
	 * Downloads bitmap from network.
	 * 
	 * @param pUrl
	 *            bitmap URL
	 * @return downloaded bitmap
	 */
	private Bitmap downloadBitmap(final String pUrl) {
		Bitmap bitmap = null;
		InputStream stream = null;
		try {
			stream = download(pUrl);
			bitmap = BitmapFactory.decodeStream(stream);
		} catch (OutOfMemoryError e) {
			Log.d(TAG, Log.getStackTraceString(e));
		} finally {
			if (stream != null) {
				try {
					stream.close();
				} catch (IOException ex) {
				}
				stream = null;
			}
		}
		return bitmap;
	}

	/**
	 * Establishes connection with given url and retrieves bytes as stream.
	 * 
	 * @param spec
	 *            download url
	 * @return stream of bytes
	 */
	private BufferedInputStream download(final String spec) {
		try {
			URL specUrl = new URL(spec);
			conn = (HttpURLConnection) specUrl.openConnection();
			conn.setDoInput(true);
			conn.setRequestProperty(CONNECTION, KEEP_ALIVE);
			conn.connect();
			stream = new BufferedInputStream(conn.getInputStream(),	DEFAULT_BUFFER_SIZE);
		} catch (MalformedURLException e) {
			Log.d(TAG, Log.getStackTraceString(e));
		} catch (IOException e) {

		} catch (OutOfMemoryError e) {
			Log.d(TAG, Log.getStackTraceString(e));
		} catch (IllegalStateException e) {
			Log.d(TAG, Log.getStackTraceString(e));
		}

		return stream;
	}

	@Override
	public void interrupt() {
		super.interrupt();
		if (stream!=null) {
			try {
				stream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if (conn != null) {
			conn.disconnect();
			conn = null;
		}
	}


	public void cancel() {
		isCanceled = true;
	}
	
	
	/**
	 * Add consumer.
	 * 
	 * @param consumer
	 *            the consumer
	 */
	public final void addConsumer(DownloadConsumer consumer) {
		if (!consumers.contains(consumer)) {
			consumers.add(consumer);
		}
	}

}
