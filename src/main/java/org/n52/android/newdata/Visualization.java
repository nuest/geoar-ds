/**
 * Copyright 2012 52�North Initiative for Geospatial Open Source Software GmbH
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
package org.n52.android.newdata;

import org.n52.android.newdata.gl.primitives.DataSourceRenderable;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;

public interface Visualization {

	interface FeatureVisualization {
		String getTitle(SpatialEntity entity);

		String getDescription(SpatialEntity entity);

		View getFeatureView(SpatialEntity entity, View convertView,
				ViewGroup parentView);
	}

	public interface MapVisualization extends Visualization {

		public interface ItemVisualization extends MapVisualization,
				FeatureVisualization {
			Drawable getDrawableForEntity(SpatialEntity entity);
			// TODO change to geographic feature stuff

		}

		public interface RasterVisualization extends MapVisualization {
			// TODO
		}
	}

	public interface ARVisualization extends Visualization {
		public interface ItemVisualization extends ARVisualization,
				FeatureVisualization {
			DataSourceRenderable getEntityVisualization(SpatialEntity entity,
					RenderingFactory fac);

		}

		public interface RasterVisualization extends ARVisualization {
			// TODO
		}

	}

}
