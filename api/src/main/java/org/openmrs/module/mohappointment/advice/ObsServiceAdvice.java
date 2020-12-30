/**
 * 
 */
package org.openmrs.module.mohappointment.advice;

import java.lang.reflect.Method;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.aop.AfterReturningAdvice;

/**
 * @author Kamonyo Mugabo
 * 
 */
public class ObsServiceAdvice implements AfterReturningAdvice {

	private Log log = LogFactory.getLog(this.getClass());
	private static int obsId = 0;
	@Override
	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
		// TODO Auto-generated method stub
		
	}

	

}
