/**
 * openmap4u-core - Parent pom providing dependency and plugin management for applications
		built with Maven
 * Copyright © ${project.inceptionYear} Michael Hadrbolec (openmap4u@gmail.com)
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.openmap4j.builder.style;

/*-
 * #%L
 * openmap4u-core
 * %%
 * Copyright (C) 2014 - 2017 openMap4u
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Lesser Public License for more details.
 * 
 * You should have received a copy of the GNU General Lesser Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/lgpl-3.0.html>.
 * #L%
 */

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openmap4j.builder.style.OverrideStyleBuildable;
import org.openmap4j.builder.style.StyleBuilderFactory;
import org.openmap4j.style.Styleable;

public class OverrideStyleBuilderTest {
	
	
	OverrideStyleBuildable osb = null;
	
	@BeforeEach
	public void beforeEach() {
		osb = StyleBuilderFactory.getOverrideStyleBuilder();
	}
	
	@Test
	public void testLineStyle() {
		List<Optional<Styleable>> styles = osb.line().strokeWidth(4.3).strokeWidth(3).build().build();
		assertEquals(styles.size(),1);
	}
	
	@Test
	public void testAreaStyle() {
		List<Optional<Styleable>> styles = osb.area().strokeWidth(3).build().build();
		assertEquals(styles.size(),1);
	}
	
	@Test
	public void testTextStyle() {
		List<Optional<Styleable>> styles = osb.text().strokeWidth(3).build().build();
		assertEquals(styles.size(),1);
	}
	
	@Test
	public void testImageStyle() {
		List<Optional<Styleable>> styles = osb.imageStyle().alpha(.5).build().build();
		assertEquals(styles.size(),1);
	}
	
	@Test
	public void testDoNotOverrideStyle() {
		List<Optional<Styleable>> styles = osb.doNotOverride().build();
		assertEquals(styles.size(),1);
	}
	
	
	

}
