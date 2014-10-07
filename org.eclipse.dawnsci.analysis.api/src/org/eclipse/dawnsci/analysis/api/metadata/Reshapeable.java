/*
 * Copyright (c) 2014 Diamond Light Source Ltd.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */

package org.eclipse.dawnsci.analysis.api.metadata;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * This is an annotation for any field that can be reshaped or squeezed. These include lazy datasets,
 * arrays and lists of lazy datasets, and maps where the values are lazy datasets.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(value = ElementType.FIELD)
public @interface Reshapeable {
}
