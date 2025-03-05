package com.microservice.examtest.document;

import com.microservice.examtest.enums.DoTestStatus;
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
@Document(value="fulltest")
public class FullTest extends EditableDocument<FullTest> {
    private String testName;
    private Set<String> partIds;
    private int totalPart;
    private String nameNoAccent;
    private int totalQuestion;
    private long testDuration;
    private int usedCount ;
    private DoTestStatus doTestStatus;
    private boolean deleted;
    public void replaceName() {
        this.nameNoAccent = WordUtils.toNonVietnamese(this.testName);
    }

}
