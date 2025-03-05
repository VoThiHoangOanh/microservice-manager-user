package com.microservice.user.predicatebuilder;

import com.microservice.sharedmodel.core.utils.WordUtils;
import com.microservice.user.document.QUser;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.BooleanExpression;
import java.util.Optional;

public class UserPredicateBuilder {
    private static final QUser Q_TABLE = QUser.user;

    public static Predicate byId(String id) {
        return Q_TABLE.id.eq(id);
    }
    public static Predicate byUserId(String id) {
        return Q_TABLE.userId.eq(id);
    }

    public static Predicate getNotTrue() {
        return Q_TABLE.deleted.isTrue().not();
    }

    public static Predicate getPaged(String search) {
        BooleanExpression[] booleanExpression = {Q_TABLE.deleted.isTrue().not()};
        Optional.ofNullable(search)
                .ifPresent(name -> booleanExpression[0] = booleanExpression[0]
                .and(Q_TABLE.nameNoAccent.containsIgnoreCase(WordUtils.toNonVietnamese(name))));
        return booleanExpression[0];
    }
}
