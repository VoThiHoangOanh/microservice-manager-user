package com.microservice.examtest.predicatebuilder;

import com.microservice.examtest.document.QFullTest;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.BooleanExpression;

import java.util.Optional;
import java.util.Set;


public class FullTestPredicateBuilder {
    private static final QFullTest Q_TABLE= QFullTest.fullTest;

    public  static Predicate byId(String id){
        return Q_TABLE.id.eq(id).and(Q_TABLE.deleted.isFalse());

    }
    public  static Predicate byIds(Set< String> ids){
        return Q_TABLE.id.in(ids).and(Q_TABLE.deleted.isFalse());

    }

    public static Predicate getNotTrue(){
        return Q_TABLE.deleted.isTrue().not();
    }

    public  static Predicate getPaged(String search){
        final BooleanExpression[] expression={Q_TABLE.deleted.isTrue().not()};
        Optional.ofNullable(search).ifPresent(value->expression[0] = expression[0].and(Q_TABLE.nameNoAccent.containsIgnoreCase(value)));
        return  expression[0];
    }

}
