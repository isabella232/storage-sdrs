/*
 * Copyright 2019 Google LLC. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the “License”);
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an “AS IS” BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and limitations under the License.
 *
 * Any software provided by Google hereunder is distributed “AS IS”,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, and is not intended for production use.
 */

package com.google.cloudy.retention.filter;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;

import static com.google.cloudy.retention.filter.ContainerContextProperties.CORRELATION_UUID;

/** Includes the correlation-uuid in the response headers. */
@Provider
public class CorrelationResponseFilter implements ContainerResponseFilter {

  /** Adds the correlation-uuid to the ResponseContext headers object */
  @Override
  public void filter(
      ContainerRequestContext requestContext, ContainerResponseContext responseContext) {
    String correlationUuid = (String) requestContext.getProperty(CORRELATION_UUID.toString());
    responseContext.getHeaders().add("correlation-uuid", correlationUuid);
  }
}
