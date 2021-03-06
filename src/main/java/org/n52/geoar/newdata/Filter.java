/**
 * Copyright 2012 52°North Initiative for Geospatial Open Source Software GmbH
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.n52.geoar.newdata;

import java.io.Serializable;

import org.n52.geoar.utils.GeoLocationRect;

public abstract class Filter implements Serializable, Cloneable {
	
	private static final long serialVersionUID = 1L;
	private GeoLocationRect boundingBox;

	public Filter setBoundingBox(GeoLocationRect boundingBox) {
		this.boundingBox = boundingBox;
		return this;
	}

	public GeoLocationRect getBoundingBox() {
		return boundingBox;
	}
	
	public Filter clone() {
		try {
			return (Filter) super.clone();
		} catch (CloneNotSupportedException e) {
			return null;
		}
	}
	
	
	

}
