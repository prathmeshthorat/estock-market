package com.estockmarket.cqrscore.queries;

import java.util.List;

import com.estockmarket.cqrscore.domain.BaseEntity;

@FunctionalInterface
public interface QueryHandlerMethod<T extends BaseQuery> {
	List<BaseEntity> handle(T query);
}
