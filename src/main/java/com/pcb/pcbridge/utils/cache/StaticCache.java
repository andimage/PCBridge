/*
 * The MIT License
 *
 * Copyright 2016 Andy Saw
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.pcb.pcbridge.utils.cache;

import java.util.HashMap;
import java.util.Map;

/**
 * A basic Map-type cache. Forgets data if manually removed or
 * whenever the plugin is disabled
 *
 * @param <K>
 * @param <V>
 */
public class StaticCache<K, V> implements ICache<K, V> {

	private Map<K, V> _map = new HashMap<>();

	@Override
	public boolean ContainsKey(K key)
	{
		return _map.containsKey(key);
	}
	
	@Override
	public V Get(K key)
	{
		return _map.get(key);
	}

	public void Remember(K key, V value)
	{
		_map.put(key, value);		
	}

	@Override
	public void Forget(K key)
	{
		_map.remove(key);
	}
	
	@Override
	public void Clear()
	{
		_map.clear();
	}
	
	@Override
	public void Destroy()
	{
		Clear();
		_map = null;
	}
	
	@Override
	public int Size()
	{
		return _map.size();
	}
}
