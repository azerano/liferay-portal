/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.portalweb.portal.dbupgrade.sampledata6012.stagingorganization.webcontentdisplay;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class SelectWebContentTest extends BaseTestCase {
	public void testSelectWebContent() throws Exception {
		selenium.open("/web/staging-organization-wcd/");

		for (int second = 0;; second++) {
			if (second >= 90) {
				fail("timeout");
			}

			try {
				if (selenium.isVisible(
							"link=Page Staging Organization Web Content Display")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		selenium.clickAt("link=Page Staging Organization Web Content Display",
			RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isElementPresent(
				"//body[@class='blue live-view controls-visible signed-in public-page dockbar-ready']"));
		assertTrue(selenium.isElementNotPresent(
				"//body[@class='blue staging controls-visible signed-in public-page dockbar-ready']"));
		selenium.clickAt("link=View Staged Page", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isElementNotPresent(
				"//body[@class='blue live-view controls-visible signed-in public-page dockbar-ready']"));
		assertTrue(selenium.isElementPresent(
				"//body[@class='blue staging controls-visible signed-in public-page dockbar-ready']"));
		selenium.clickAt("//img[@alt='Select Web Content']",
			RuntimeVariables.replace(""));

		for (int second = 0;; second++) {
			if (second >= 90) {
				fail("timeout");
			}

			try {
				if (selenium.isVisible("//td[1]/a")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		assertTrue(selenium.isElementPresent("//td[1]/a"));
		assertEquals(RuntimeVariables.replace("WC Web Content Name"),
			selenium.getText("//td[2]/a"));
		assertTrue(selenium.isElementPresent("//td[3]/a"));
		assertTrue(selenium.isElementPresent("//td[4]/a"));
		assertEquals(RuntimeVariables.replace("Joe Bloggs"),
			selenium.getText("//td[5]/a"));
		selenium.clickAt("//td[2]/a",
			RuntimeVariables.replace("WC Web Content Name"));

		for (int second = 0;; second++) {
			if (second >= 90) {
				fail("timeout");
			}

			try {
				if (selenium.isPartialText("//form[@id='_86_fm1']/div",
							"Displaying Content:")) {
					break;
				}
			}
			catch (Exception e) {
			}

			Thread.sleep(1000);
		}

		assertTrue(selenium.isPartialText("//form[@id='_86_fm1']/div",
				"Displaying Content:"));
		selenium.clickAt("//input[@value='Save']", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		assertEquals(RuntimeVariables.replace(
				"You have successfully updated the setup."),
			selenium.getText("//div[@class='portlet-msg-success']"));
	}
}