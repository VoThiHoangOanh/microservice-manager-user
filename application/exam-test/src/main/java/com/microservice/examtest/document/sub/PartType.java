package com.microservice.examtest.document.sub;

import lombok.Getter;

@Getter
public enum PartType {
    PART_1 (20, " Phần 1 có 20 câu hỏi"),
    PART_2 (10, " Phần 2 có 10 câu hỏi"),
    PART_3 (8, " Phần 3 có 8 câu hỏi"),
    PART_4 (7, " Phần 4 có 7 câu hỏi"),
    PART_5 (5, " Phần 5 có 5 câu hỏi");

    private final double number;
    private final String message;

    PartType(double number, String message) {
        this.number = number;
        this.message = message;
    }
}
