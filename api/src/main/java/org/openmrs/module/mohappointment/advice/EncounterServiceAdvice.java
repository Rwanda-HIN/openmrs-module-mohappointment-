/**
 * The contents of this file are subject to the OpenMRS Public License
 * Version 1.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 * http://license.openmrs.org
 *
 * Software distributed under the License is distributed on an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * License for the specific language governing rights and limitations
 * under the License.
 *
 * Copyright (C) OpenMRS, LLC.  All Rights Reserved.
 */
package org.openmrs.module.mohappointment.advice;

import java.lang.reflect.Method;

import org.directwebremoting.guice.RequestScoped;
import org.springframework.aop.AfterReturningAdvice;

/**
 * @author Kamonyo
 * 
 *         AOP class used to insert an appointment when the EncounterService
 *         methods saves an Encounter
 */
@RequestScoped
public class EncounterServiceAdvice implements AfterReturningAdvice {

	@Override
	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
		// TODO Auto-generated method stub
		
	}


}
