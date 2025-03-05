package com.microservice.examtest.document;


import com.microservice.examtest.document.sub.QuestionOption;
import com.microservice.examtest.document.sub.ScoreType;
import com.microservice.sharedmodel.core.utils.WordUtils;
import com.microservice.sharedmodel.editingdocument.document.EditableDocument;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Document(value = "question")
public class Question extends EditableDocument<Question> {
    private String questionName;
    private String nameNoAccent;
    private List<QuestionOption> options;
    private ScoreType scoreType;
    private int usedCount;
    private boolean deleted;

    public void replaceName() {
        this.nameNoAccent = WordUtils.toNonVietnamese(this.questionName);
    }


}


