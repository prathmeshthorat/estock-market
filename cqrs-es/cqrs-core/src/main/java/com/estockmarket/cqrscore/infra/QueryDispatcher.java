package com.estockmarket.cqrscore.infra;

import java.util.List;

import com.estockmarket.cqrscore.domain.BaseEntity;
import com.estockmarket.cqrscore.queries.BaseQuery;
import com.estockmarket.cqrscore.queries.QueryHandlerMethod;

public interface QueryDispatcher {
	<T extends BaseQuery> void registerHandler(Class<T> type, QueryHandlerMethod<T> handler);
	<U extends BaseEntity> List<U> send(BaseQuery query);
}
