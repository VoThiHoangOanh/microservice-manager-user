package com.microservice.examtest.dto.payload;

import com.microservice.examtest.document.sub.PartType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor

public class PartTestDTO {
    private String partId;
    private String partName;
    private PartType partType;
    private List<String> questionIds;
    private int usedCount;
    private boolean deleted;
    private String pastMessage;

}
