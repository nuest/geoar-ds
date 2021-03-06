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

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.n52.geoar.alg.proj.MercatorProj;

public interface Annotations {

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.TYPE)
    public @interface DataSource {

        /**
         * The human readable name of a datasource
         * 
         * @return
         */
        Settings.Name name();

        /**
         * Describes a datasource
         * 
         * @return
         */
        String description() default "";

        /**
         * Gets the {@link MercatorProj} zoom to use for the spatial index of
         * the {@link MeasurementManager}
         * 
         * @return
         */
        byte cacheZoomLevel() default 12;

        /**
         * Minimum zoom level required to be used in the map view
         * 
         * @return
         */
        byte minZoomLevel() default 10;

        /**
         * Maximum zoom level to be used in the map view
         * 
         * @return
         */
        byte maxZoomLevel() default Byte.MAX_VALUE;

        /**
         * Gets the interval after which data has to get rerequested
         * 
         * @return
         */
        long minReloadInterval() default -1;
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.TYPE)
    public @interface SupportedVisualization {

        Class<? extends Visualization>[] visualizationClasses();
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.FIELD)
    public @interface SystemService {
        String value();
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.FIELD)
    public @interface SharedHttpClient {
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.FIELD)
    public @interface SharedGeometryFactory {
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.FIELD)
    public @interface PluginContext {
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    public @interface PostConstruct {
    }

    /**
     * Annotates a method to use to get the name of a data source at runtime.
     * This is relevant for multi-instance data sources.
     */
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    public @interface NameCallback {
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.FIELD)
    public @interface Setting {
    }

    /**
     * Indicates a method to be called after settings of an object got changed
     * by GeoAR
     */
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    public @interface PostSettingsChanged {
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.TYPE)
    public @interface DefaultInstances {
        DefaultSettingsSet[] value();
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.ANNOTATION_TYPE)
    public @interface DefaultSettingsSet {
        DefaultSetting[] value();
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.ANNOTATION_TYPE)
    public @interface DefaultSetting {
        String value();

        String name();
    }

    public interface Settings {
        @Retention(RetentionPolicy.RUNTIME)
        @Target(ElementType.FIELD)
        public @interface Name {
            /**
             * Name of the parameter
             * 
             * @return
             */
            String value() default "";

            int resId() default -1;
        }

        @Retention(RetentionPolicy.RUNTIME)
        @Target(ElementType.FIELD)
        public @interface Min {
            /**
             * Minimum value of the parameter
             * 
             * @return
             */
            String value();
        }

        @Retention(RetentionPolicy.RUNTIME)
        @Target(ElementType.FIELD)
        public @interface Max {
            /**
             * Maximum value of the parameter
             * 
             * @return
             */
            String value();
        }

        @Retention(RetentionPolicy.RUNTIME)
        @Target(ElementType.FIELD)
        public @interface NoValue {
            /**
             * Text to show for null value
             * 
             * @return
             */
            String value();
        }

        @Retention(RetentionPolicy.RUNTIME)
        @Target(ElementType.FIELD)
        public @interface NotNull {
        }

        @Retention(RetentionPolicy.RUNTIME)
        @Target(ElementType.FIELD)
        public @interface Temporal {

            public enum TemporalType {
                DATE, TIME, DATETIME
            };

            TemporalType value();
        }

        @Retention(RetentionPolicy.RUNTIME)
        @Target(ElementType.FIELD)
        public @interface Group {
            String value();
        }

    }

}
