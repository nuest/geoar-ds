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

import java.util.List;

/**
 * Interface describing a data source
 * 
 */
public interface DataSource<F extends Filter> {

	/**
	 * This method will receive a custom {@link Filter} instance and returns all
	 * spatial data which fits to this filter.
	 * 
	 * The implementation should not provide any results which do not pass the
	 * provided {@link Filter}, since the results are not validated to maximize
	 * performance. Results outside the spatial extent spanned by the
	 * {@link Filter} will result in visualization and caching problems.
	 * 
	 * If the data source is unable to request its data by bounding boxes, it is
	 * recommended to either cache and filter the results locally, or to set the
	 * {@link org.n52.android.newdata.Annotations.DataSource#cacheZoomLevel()}
	 * to 0 which results in single-tiled calls of this method.
	 * 
	 * @param filter
	 * @return
	 */
	public List<? extends SpatialEntity> getMeasurements(F filter);

	public boolean isAvailable();

}
