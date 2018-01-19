package com.xiaobn.test.accesscontrol;

import java.util.Map;
import java.util.Set;

public class Ace {
	// an ACE defines what operation a user or a role can perform on object or a record of an object.
	// We have 3 types of ACEs:
	// ObjectAce, 
	// 
	public enum Op {
		Own, // represent the ownership relationship between a user and a rec. Not exactly an operation.
		OwnByRH,  // Own thru Role-hierarchy
		All, // read, write, create
		Write,  // read, write only
		Read, // read only
	};
	
	public enum ObjAccessType {
		PublicAll, PublicRead, PublicWrite, Private,
	};
	
	// Maps user to roles
	public class UserRoles {
		String userId;
	};
	
	// ObjectAce specifies user's access on an object. It is a prerequisite 
	// for the user to access the object's records.
	// Example:
	// {obj1, user1, All, [*]}: user1 can read/update/create all fields of obj1
	// {objId, userId|roleId} uniquely identify such ObjectAce
	public class ObjectAce {
		// Keyed on {objId, userId|roleId}
		String objId;
		// Either userId or roleId
		String userId;
		String roleId;
		
		Map<Op, Set<String>> opToFields;
	
		public boolean isAccessAllowedByUser(Op op, Set<String> fields) {
			// TODO: Go thru opToFields to make sure every pair of {op, field} is allowed.
			return false;
		}
	};
	
	// ObjectAccess specifies accesses allowed on the object's records.
	// For example:
	// An object with publicAll access allows any one to do any op on every
	// record of the object as long as the user is allowed thru an ObjectAce.
	public class ObjectAccess {
		String objId; // primary key
		ObjAccessType objAccessType;
		
		public boolean isAccessAllowedByObject(Op op) {
			if (objAccessType == ObjAccessType.PublicAll) {
				return true;
			} else if (objAccessType == ObjAccessType.PublicWrite) {
				if (op == Op.Write || op == Op.Read) return true;
			} else if (objAccessType == ObjAccessType.PublicRead) {
				if (op == Op.Read) return true;
			}
			return false;
		}
	};

	// RecordAce specifies whether a user or a role can access a specific record.
	// {objId, recId, userId|roleId} uniquely identify such RecordAce
	public class RecordAce {
		// the following 4 is the primary key
		String objId;
		String recId;
		String userId;
		String roleId;
		
		Op op;
		// No need to support granularity at field level yet.
		// Set<String> allowedFieldIds;
		
		public boolean isAcccessAllowedByRec(Op op) {
			// TODO: check whether this.op exceeds op
			return false;
		}
	};
	
	
	// How ACE is used to authorize record access:
	// Given an access request: {objId, recId, userId, op, fields},
	// if there exists an ObjectACE objAce for {objId, userId} &&
	//   objAce.isAccessAllowedByUser(op, fields)
	//   get the ObjectAccess objAccess of the objId
	//   if objAccess.isAccessAllowedByObject(op)
	//     return true
	//   else
	//     if there exists a RecordAce recAce for {objId, recId, userId} &&
	//       recAce.isAccessAllowedByRec(op, fields)
	//       return true
	//   return false
	// Then try each role this userId has: {objId, recid, roleId, op, fields}
	// ....
	//
}
