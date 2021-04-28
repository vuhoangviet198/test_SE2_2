/**
 * 
 */
package vn.hanu.restaurant.manager.utils;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;

/**
 * @author Admin
 *
 */
public class DataTransformUtil {

	/**
	 * Constructor
	 */
	public DataTransformUtil() {
		// TODO Auto-generated constructor stub
	}

	public static void transform(Object source, Object destination) {
		if (destination == null) {
			return;
		}
		try {
			BeanUtils.copyProperties(destination, source);
		} catch (IllegalAccessException | InvocationTargetException e) {
			throw new RuntimeException(e);
		}
	}

	@SuppressWarnings("rawtypes")
	public static Object transform(Object source, Class targetType) {
		try {
			Object result = targetType.newInstance();

			transform(source, result);

			return result;
		} catch (InstantiationException | IllegalAccessException e) {
			throw new RuntimeException(e);
		}
	}

}
