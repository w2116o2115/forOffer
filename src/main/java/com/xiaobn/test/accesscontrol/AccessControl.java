package com.xiaobn.test.accesscontrol;

import java.util.Map;
import java.util.Set;

public abstract class AccessControl {
	public static AccessControl getInstance(String tenantId) {
		// TODO: get AccessControl handle for a tenant.
		return null;
	}
	
	// Handle to access the role hierarchy of the tenant.
	RolesInterface roles;	
	
	// If isRole, userId is a roleId
	protected abstract Ace.ObjectAce getObjectAce(String userId, boolean isRole, String objId);
	
	protected abstract Ace.ObjectAccess getObjectAccess(String objId);
	
	protected abstract Ace.RecordAce getRecordAce(String userId, boolean isRole, String objId, String recId);
	
	private boolean isObjectAccessAuthorized(String userId, boolean isRole, String objId, Ace.Op op, Set<String> fields) {
		Ace.ObjectAce objAce = getObjectAce(userId, isRole, objId);
		if (objAce != null && objAce.isAccessAllowedByUser(op, fields)) return true;
		return false;
	}
	
	private boolean isRecordAccessAuthorized(String userId, boolean isRole, String objId, String recId,
			Ace.Op op, Set<String> fields) {
		if (!isObjectAccessAuthorized(userId, isRole, objId, op, fields)) return false;
		Ace.ObjectAccess objAccess = getObjectAccess(objId);
		if (objAccess != null && objAccess.isAccessAllowedByObject(op)) return true;
		
		Ace.RecordAce recAce = getRecordAce(userId, isRole, objId, recId);
		if (recAce != null && recAce.isAcccessAllowedByRec(op)) return true;
		return false;		
	}
	
	public boolean authorizeObjectAccess(String userId, String objId, Ace.Op op, Set<String> fields) {
		if (isObjectAccessAuthorized(userId, false, objId, op, fields)) return true;
		for (String roleId : roles.getUserRoles(userId)) {
			if (isObjectAccessAuthorized(userId, true, objId, op, fields)) return true;
		}
		return false;
	}
	
	public boolean authorizeRecordAccess(String userId, String objId, String recId,
			Ace.Op op, Set<String> fields) {
		if (!authorizeObjectAccess(userId, objId, op, fields)) return false;
		if (isRecordAccessAuthorized(userId, false, objId, recId, op, fields)) return true;
		for (String roleId : roles.getUserRoles(userId)) {
			if (isRecordAccessAuthorized(userId, true, objId, recId, op, fields)) return true;
		}
		return false;
	}
	
	
	// Change a user's role will result in ACE changes.
	public abstract void addUserRole(String userId, String roleId);
	public abstract void removeUserRole(String userId, String roleId);
	
	// Change reporting relationship will result in ACE changes
	public abstract void removeReporting(String roleId, String reportToRoleId);
	public abstract void addReporting(String roleId, String reportToRoleId);
	
	// Update ACEs
	public static class AceMutation {
		public enum MutationType { ADD, REMOVE };
		Set<Map<Ace.ObjectAce, MutationType>> objAceMuts;
		Set<Map<Ace.ObjectAccess, MutationType>> objAccessMuts;
		Set<Map<Ace.RecordAce, MutationType>> recAceMuts;
	};
	
	public abstract void updateAces(AceMutation am);
}
