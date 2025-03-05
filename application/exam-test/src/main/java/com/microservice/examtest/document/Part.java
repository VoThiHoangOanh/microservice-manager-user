package com.microservice.examtest.document;

import com.microservice.examtest.document.sub.PartType;
import com.microservice.sharedmodel.core.utils.WordUtils;
import com.microservice.sharedmodel.editingdocument.document.EditableDocument;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@Document(value = "part")
public class Part extends EditableDocument<Part> {
    private String partName;
    private String nameNoAccent;
    private PartType partType;
    private Set<String> questionIds;
    private int usedCount;
    private boolean deleted;

    public void replaceName() {
        this.nameNoAccent = WordUtils.toNonVietnamese(this.partName);
    }

}

