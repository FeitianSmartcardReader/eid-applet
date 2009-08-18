/*
 * eID Applet Project.
 * Copyright (C) 2008-2009 FedICT.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License version
 * 3.0 as published by the Free Software Foundation.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, see 
 * http://www.gnu.org/licenses/.
 */

package be.fedict.eid.applet.service.signer;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import javax.security.jacc.PolicyContext;
import javax.security.jacc.PolicyContextException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Implementation of a temporary data storage using the HTTP session as
 * temporary repository.
 * 
 * @author fcorneli
 * 
 */
public class HttpSessionTemporaryDataStorage implements TemporaryDataStorage {

	private static final Log LOG = LogFactory
			.getLog(HttpSessionTemporaryDataStorage.class);

	public static final String TEMP_OUTPUT_STREAM_ATTRIBUTE = HttpSessionTemporaryDataStorage.class
			.getName()
			+ ".tempData";

	public InputStream getTempInputStream() {
		LOG.debug("get temp input stream");
		HttpSession httpSession = getHttpSession();
		ByteArrayOutputStream tempOutputStream = (ByteArrayOutputStream) httpSession
				.getAttribute(TEMP_OUTPUT_STREAM_ATTRIBUTE);
		if (null == tempOutputStream) {
			LOG.warn("missing temp output stream");
			return null;
		}
		byte[] tempData = tempOutputStream.toByteArray();
		ByteArrayInputStream tempInputStream = new ByteArrayInputStream(
				tempData);
		return tempInputStream;
	}

	public OutputStream getTempOutputStream() {
		LOG.debug("get temp output stream");
		HttpSession httpSession = getHttpSession();
		ByteArrayOutputStream tempOutputStream = new ByteArrayOutputStream();
		httpSession
				.setAttribute(TEMP_OUTPUT_STREAM_ATTRIBUTE, tempOutputStream);
		return tempOutputStream;
	}

	/**
	 * Gives back the current HTTP session using JACC.
	 * 
	 * @return
	 */
	public static HttpSession getHttpSession() {
		HttpServletRequest httpServletRequest;
		try {
			httpServletRequest = (HttpServletRequest) PolicyContext
					.getContext("javax.servlet.http.HttpServletRequest");
		} catch (PolicyContextException e) {
			throw new RuntimeException("JACC error: " + e.getMessage());
		}

		HttpSession httpSession = httpServletRequest.getSession();
		return httpSession;
	}
}