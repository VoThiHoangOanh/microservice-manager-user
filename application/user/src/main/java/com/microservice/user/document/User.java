package com.microservice.user.document;

import com.microservice.sharedmodel.core.document.BaseDocument;
import com.microservice.sharedmodel.core.utils.WordUtils;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("user")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class User extends BaseDocument {
    private String userId;
    private String name;
    private String nameNoAccent;
    private String picture;
    private String phone;
    private String email;
    private String password;
    private boolean deleted;

    public void replaceName(String name) {
        this.nameNoAccent = WordUtils.toNonVietnamese(name);
    }

}

