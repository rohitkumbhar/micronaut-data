/*
 * Copyright 2017-2020 original authors
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
package io.micronaut.data.mongodb.annotation;

import io.micronaut.context.annotation.AliasFor;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Defines a custom MongoDB update query.
 *
 * @author Denis Stepanov
 * @since 3.3.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
@Inherited
public @interface MongoUpdateQuery {

    /**
     * The custom MongoDB filter.
     *
     * @return The update value
     */
    String update();

    /**
     * The custom MongoDB filter.
     *
     * @return The filter value
     */
    @AliasFor(member = "value", annotation = MongoFilter.class)
    String filter() default "";

    /**
     * The custom collation represented in JSON.
     *
     * @return The collation
     */
    @AliasFor(member = "value", annotation = MongoCollation.class)
    String collation() default "";
}
