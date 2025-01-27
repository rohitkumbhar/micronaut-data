/*
 * Copyright 2017-2022 original authors
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
package io.micronaut.data.cosmos.serde;

import io.micronaut.core.type.Argument;
import io.micronaut.data.document.serde.IdDeserializer;
import io.micronaut.serde.Deserializer;
import io.micronaut.serde.exceptions.SerdeException;
import io.micronaut.serde.util.CustomizableDeserializer;
import jakarta.inject.Singleton;

/**
 * Default {@link io.micronaut.data.document.serde.IdDeserializer} implementation.
 *
 * @author radovanradic
 * @since 3.9.0
 */
@Singleton
final class DefaultIdDeserializer implements IdDeserializer, CustomizableDeserializer<Object> {

    @Override
    public Deserializer<Object> createSpecific(DecoderContext context, Argument<? super Object> type) throws SerdeException {
        Deserializer<? extends Object> deserializer = context.findDeserializer(type);
        return (Deserializer<Object>) deserializer.createSpecific(context, type);
    }
}
