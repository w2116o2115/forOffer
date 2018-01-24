package com.xiaobn.test.accesscontrol;

import java.util.Set;

public interface RolesInterface {
	// Get a Roles instance for a specific tenant and a specific user.
	// This static function needs to be implemented by Roles's implementation class.
	//public static RolesInterface getRoles(String tenantId) { return null; }
	
	// Get all roleIds of userId
	public Set<String> getUserRoles(String userId);

	public class ReportingChain {
		String roleId;
		// All roleIds in the reporting chain up from the userRoleId.
		Set<String> reportedRoleIds;
	}
	
	// Get all reportingchains up from userId
	public Set<ReportingChain> getReportingChainsByRole(String roleId);
	public Set<ReportingChain> getReportingChains(String roleId);
}
