/*
 * Copyright 2017-2019 original authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.micronaut.data.intercept.reactive;

import io.micronaut.data.intercept.PredatorInterceptor;

/**
 * An interceptor that executes an find by id reactively.
 *
 * @param <T> The declaring type
 * @param <R> The result type
 * @author graemerocher
 * @since 1.0.0
 */
public interface FindByIdReactiveInterceptor<T, R> extends PredatorInterceptor<T, R> {
}

