package com.genas.components.manager;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * The Class CacheMap. The class is designed for organizations caching models.
 * 
 * @param <T>
 *            This is the heir of the BaseCacheModel, which will be cached.
 */
public class CacheMap<T extends BaseCacheModel> {

	/** The storage of BaseCacheModel with String keys. */
	private HashMap<String, T> map;

	/** The storage of sorted String keys. */
	private List<String> keys;

	/** The reserved size of storage. */
	private int realSize;

	/** The size of storage. */
	private int reservedSize;

	/** The expiration time of storage. */
	private Long expiration;

	/**
	 * Instantiates a new cache map.
	 * 
	 * @param pSize
	 *            the storage size
	 * @param pExpiration
	 *            the expiration for caching models
	 */
	public CacheMap(final int pSize, final Long pExpiration) {
		super();
		this.reservedSize = pSize;
		this.expiration = pExpiration;
		map = new HashMap<String, T>();
		keys = new ArrayList<String>();
	}

	/**
	 * 
	 * Put model to storage.
	 * 
	 * @param key
	 *            The key for caching
	 * @param t
	 *            The object for caching
	 */
	public void put(final String key, final T t) {

		if (keys.contains(key)) {
			remove(key, map.get(key));
		}
		System.out.println("1----------------" + realSize);
		System.out.println("2----------------" + reservedSize);
		System.out.println("------------------------------");
		for (int i = 0; i < keys.size(); i++) {
			if (realSize > reservedSize) {
				String val = keys.get(i);
				remove(val, map.get(val));
			} else {
				break;
			}
		}
		add(key, t);
	}

	/**
	 * Adding model to storage and add calculate size.
	 * 
	 * @param key
	 *            the key
	 * @param t
	 *            the model
	 */
	private void add(final String key, final T t) {
		Integer size = t.getSize();
		int length = key.getBytes().length;
		realSize += size;
		realSize += length;
		keys.add(key);
		map.put(key, t);
	}

	/**
	 * 
	 * Getting object from storage. If object in storage not valid, removing
	 * object and return null.
	 * 
	 * @param key
	 *            Key to select from storage
	 * @return The object is obtained from the storage to a key
	 */
	public T get(final String key) {
		T t = map.get(key);
		if (t != null && !isValid(t)) {
			remove(key, t);
			return null;
		}
		return t;
	}

	/**
	 * Remove item from storage and calculate size.
	 * 
	 * @param key
	 *            the key
	 * @param t
	 *            the model
	 */
	protected T remove(final String key, final T t) {
		realSize -= (map.get(key).getSize() + key.getBytes().length);
		keys.remove(key);
		return map.remove(key);
	}

	/**
	 * Check validate with expiration.
	 * 
	 * @param o
	 *            the object for validation
	 * @return boolean true - validate, false - invalidate.
	 */
	public Boolean isValid(final T o) {
		Long difference = (new Date()).getTime() - o.getSaveDate();
		boolean res = difference < expiration;
		return res;
	}

	/**
	 * 
	 * Getting the realSize.
	 * 
	 * @return the realSize
	 */
	public int getRealSize() {
		return realSize;
	}

	public synchronized void clear(int remainder) {
		for (int i = 0, count = keys.size() - remainder; i < count; i++) {
			BaseCacheModel entry = map.remove(keys.remove(0));
			entry.dispose();
		}
	}
}
