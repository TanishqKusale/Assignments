package com.validate;

import com.exp.ArrayExp;

public interface ValidateK {

	public static int validateKValue(int k,int size) throws ArrayExp
	{
		if(k>size)
		{
			throw new ArrayExp("K should be greater than size of an array!");
		}
		return k;
	}
}
