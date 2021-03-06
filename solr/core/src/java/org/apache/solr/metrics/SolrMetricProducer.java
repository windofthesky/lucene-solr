/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.solr.metrics;

/**
 * Used by objects that expose metrics through {@link SolrCoreMetricManager}.
 */
public interface SolrMetricProducer {

  /**
   * Initializes metrics specific to this producer
   * @param manager an instance of {@link SolrMetricManager}
   * @param registry registry name where metrics are registered
   * @param tag a symbolic tag that represents this instance of the producer,
   * or a group of related instances that have the same life-cycle. This tag is
   * used when managing life-cycle of some metrics and is set when
   * {@link #initializeMetrics(SolrMetricManager, String, String, String)} is called.
   * @param scope scope of the metrics (eg. handler name) to separate metrics of
   */
  void initializeMetrics(SolrMetricManager manager, String registry, String tag, String scope);
}
