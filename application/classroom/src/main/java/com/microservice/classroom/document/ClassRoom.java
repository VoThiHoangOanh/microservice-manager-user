package com.microservice.classroom.document;

import com.microservice.sharedmodel.core.document.BaseDocument;
import com.microservice.sharedmodel.core.utils.WordUtils;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Document(value = "classroom")
public class ClassRoom extends BaseDocument {

    private String className;
    private Set<String> studentIds;
    private String teacherId;
    private int quantityMaxStudent;
    private String nameNoAccent;

    public void replaceName(String name) {
        this.nameNoAccent = WordUtils.toNonVietnamese(name);
    }

}
