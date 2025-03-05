package com.microservice.sharedmodel.editingdocument.document;

import jakarta.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import com.microservice.sharedmodel.core.document.BaseDocument;
import com.microservice.sharedmodel.editingdocument.DocumentStatus;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@SuperBuilder
public abstract class EditableDocument<D extends BaseDocument> extends BaseDocument {
    @Nullable
    protected D editingDocument;
    @Nullable
    protected DocumentStatus documentStatus;
}
