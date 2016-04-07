/*-
 * Copyright © 2016 Diamond Light Source Ltd.
 *
 * This file is part of GDA.
 *
 * GDA is free software: you can redistribute it and/or modify it under the
 * terms of the GNU General Public License version 3 as published by the Free
 * Software Foundation.
 *
 * GDA is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 *
 * You should have received a copy of the GNU General Public License along
 * with GDA. If not, see <http://www.gnu.org/licenses/>.
 */

package org.eclipse.richbeans.generator.example;

import org.metawidget.inspector.annotation.UiLarge;
import org.metawidget.inspector.annotation.UiReadOnly;

public class SimpleExample extends GuiGeneratorRunnerBase {

	public static void main(String[] args) {
		new SimpleExample().run();
	}

	@Override
	protected Object createTestObject() {
		SimpleBean testBean = new SimpleBean();
		testBean.setName("Simple test bean");
		testBean.setDescription("Editable multi-line description");
		return testBean;
	}
}

class SimpleBean {
	private String name;
	private String description;
	private int count;
	private double x;
	private double y;

	@UiReadOnly
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@UiLarge
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
}
