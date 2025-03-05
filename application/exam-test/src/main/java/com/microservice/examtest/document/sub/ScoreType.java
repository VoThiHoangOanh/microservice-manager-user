package com.microservice.examtest.document.sub;

import lombok.Getter;

@Getter
public enum ScoreType {
    Score025(0.25, " Mỗi câu đúng được 0.25 điểm"),
    Score05(0.5, " Mỗi câu đúng được 0.5 điểm");


    private final double score;
    private final String message;

    ScoreType(double score, String message) {
        this.score = score;
        this.message = message;
    }
}