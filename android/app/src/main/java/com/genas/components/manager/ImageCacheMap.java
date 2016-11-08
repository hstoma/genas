package com.genas.components.manager;

/**
 * The Class ImageCacheMap. The class is designed for organizations caching
 * models. Extending of {@link CacheMap} for synchronized methods put and
 * remove.
 * 
 * @see CacheMap
 */
public class ImageCacheMap extends CacheMap<CacheImage> {

	/** The constant logging tag. */
	public static final String TAG = ImageCacheMap.class.getName();

	/**
	 * Instantiates a new image cache map.
	 * 
	 * @param pSize
	 *            the size of storage
	 * @param pExpiration
	 *            the expiration of storage item
	 */
	public ImageCacheMap(final int pSize, final Long pExpiration) {
		super(pSize, pExpiration);
	}

	@Override
	public final synchronized void put(final String key, final CacheImage t) {
		super.put(key, t);
	}

	@Override
	protected final synchronized CacheImage remove(final String key, final CacheImage t) {
		CacheImage cacheImage = super.remove(key, t);
		return cacheImage;
	}

}
