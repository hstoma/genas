package com.genas.components.manager;

import android.graphics.Bitmap;

/**
 * 
 * Class CacheImage for caching images.
 * 
 */
public class CacheImage extends BaseCacheModel {

	/** The Used for calculate size image. */
	private static final int SIZE_IN_BYTE_FOR_ONE_PICSEL = 4;

	/**
	 * The bitmap.
	 */
	private Bitmap bitmap;

	/**
	 * Instantiates a new image cache.
	 * 
	 * @param pBitmap
	 *            the bitmap
	 */
	public CacheImage(final Bitmap pBitmap) {
		this.bitmap = pBitmap;
	}

	/**
	 * 
	 * Getting the bitmap.
	 * 
	 * @return the bitmap
	 */
	public Bitmap getBitmap() {
		return bitmap;
	}

	/**
	 * 
	 * Calculates bitmap memory allocation.
	 * 
	 * @return memory size
	 */
	private int calculateSize() {
		return bitmap.getWidth() * bitmap.getHeight() * SIZE_IN_BYTE_FOR_ONE_PICSEL;
	}

	@Override
	public Integer getSize() {
		return super.getSize() + calculateSize();
	}

	@Override
	public void dispose() {
		super.dispose();
		bitmap = null;
	}

}
