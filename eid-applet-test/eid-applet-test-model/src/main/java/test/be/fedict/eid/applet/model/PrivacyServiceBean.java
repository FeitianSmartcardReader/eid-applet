/*
 * eID Applet Project.
 * Copyright (C) 2009 FedICT.
 * Copyright (C) 2014 e-Contract.be BVBA.
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

package test.be.fedict.eid.applet.model;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@Stateless
@EJB(name = "java:global/test/PrivacyServiceBean", beanInterface = PrivacyService.class)
public class PrivacyServiceBean implements PrivacyService {

	private static final Log LOG = LogFactory.getLog(PrivacyServiceBean.class);

	public String getIdentityDataUsage(String language) {
		LOG.debug("getIdentityDataUsage for language: " + language);
		return "Identity Data Usage message from the server.";
	}
}
