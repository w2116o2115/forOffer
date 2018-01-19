/**
 * 
 */
package com.xiaobn.test.dal;

import java.util.List;

/**
 * @author miclei
 *
 */
public class DalQuery {
	// Select list<recId> from Object where whereClause
	static class WhereClause {
		enum ChildOp { AND, OR };
		enum Op { GT, LT, EQ };
		ChildOp co;
		List<WhereClause> children;
		String fieldId;
		Field val;
		Op op;
	};
	
	WhereClause wc;
	String objId;
}
