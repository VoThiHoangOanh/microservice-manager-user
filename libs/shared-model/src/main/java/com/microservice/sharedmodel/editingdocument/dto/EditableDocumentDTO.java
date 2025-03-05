package com.microservice.sharedmodel.editingdocument.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import com.microservice.sharedmodel.core.dto.BaseDTO;
import com.microservice.sharedmodel.editingdocument.DocumentStatus;

@SuperBuilder
@Getter
@NoArgsConstructor
public abstract class EditableDocumentDTO<D extends BaseDTO> extends BaseDTO {

    protected D editingDocument;
    protected DocumentStatus documentStatus;
}
