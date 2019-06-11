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
package io.micronaut.data.processor.mappers.jpa;

import edu.umd.cs.findbugs.annotations.NonNull;
import edu.umd.cs.findbugs.annotations.Nullable;
import io.micronaut.core.annotation.AnnotationValue;
import io.micronaut.data.annotation.Persisted;
import io.micronaut.inject.annotation.NamedAnnotationMapper;
import io.micronaut.inject.visitor.VisitorContext;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;

/**
 * Maps JPA column annotation to {@link Persisted}.
 *
 * @author graemerocher
 * @since 1.0.0
 */
public final class ColumnAnnotationMapper implements NamedAnnotationMapper {

    @NonNull
    @Override
    public String getName() {
        return "javax.persistence.Column";
    }

    @Override
    public List<AnnotationValue<?>> map(AnnotationValue<Annotation> annotation, VisitorContext visitorContext) {
        final String name = annotation.get("name", String.class).orElse(null);
        final boolean nullable = annotation.get("nullable", boolean.class).orElse(false);
        AnnotationValue<Persisted> persistedAnnotationValue;
        List<AnnotationValue<?>> values = new ArrayList<>(2);
        if (name != null) {
            persistedAnnotationValue = AnnotationValue.builder(Persisted.class)
                    .value(name)
                    .build();

            values.add(persistedAnnotationValue);
        }

        if (nullable) {
            values.add(AnnotationValue.builder(Nullable.class).build());
        }

        return values;
    }

}
