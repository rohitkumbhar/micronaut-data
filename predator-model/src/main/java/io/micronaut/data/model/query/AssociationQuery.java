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
package io.micronaut.data.model.query;

import io.micronaut.data.model.Association;
import edu.umd.cs.findbugs.annotations.NonNull;

/**
 * Extends a query and allows querying an association.
 *
 * @author graemerocher
 * @since 1.0
 */
public class AssociationQuery extends DefaultQuery implements QueryModel.Criterion {

    private final Association association;

    /**
     * Default constructor.
     * @param association The association.
     */
    public AssociationQuery(@NonNull Association association) {
        super(association.getAssociatedEntity());
        this.association = association;
    }

    /**
     * @return The association to be queried.
     */
    public Association getAssociation() {
        return association;
    }
}
