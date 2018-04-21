package org.openmap4j.common;

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

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;

 
public abstract class NestedBuilder<T, V> implements NestedBuildable<T, V> {
	
	private static final Logger LOGGER = Logger.getLogger( NestedBuilder.class.getName());

	private T parent;
	private String parentMethodName = null;

	protected NestedBuilder(T parent, String parentMethodName) {
		this();
		this.parent = parent;
		this.parentMethodName = parentMethodName;
	}

	protected NestedBuilder() {
		super();
	}

	/**
	 * To get the parent builder
	 *
	 * @return T the instance of the parent builder
	 */
	@SuppressWarnings("unchecked")
	public T build() {
		V build = this.buildNested();
		if (this.parent == null) {
			return (T) build;
		} else {
			Class<?> parentClass = parent.getClass();
			try {
				Method method = parentClass.getDeclaredMethod(parentMethodName, build.getClass());
				method.invoke(parent, build);
			} catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
				LOGGER.log(Level.SEVERE, "Unable to find parent method ", e);
			}
			return parent;
		}
	}

	protected abstract V buildNested();

}
