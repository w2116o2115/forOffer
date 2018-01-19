package com.xiaobn.test.dal;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface DalInterface {
	public interface FieldJavaClass {
		enum FieldJavaType { Email, Text, Location, };
		public boolean validate(); // validate the data.
	};
	
	public abstract class Name implements FieldJavaClass {
		String firstName;
		String lastName;
	};
	
	public class Field implements Serializable {
		public FieldJavaClass javaObj;  // the Java object in the field.
	};
	
	public class Record implements Serializable {
		// Object : collection(ref of the same object) *
		// ref: point to a record
		// types of collections: childRelation, refRelation
		class RelationList {
			String objectId;
			List<String> recIds;
		};
		
		long version;
		String ownerId;
		String objectId;
		String RecId;

		Map<String, Serializable> fields;
		
		// Relations
		boolean isRelationsLoaded;
		Map<String, RelationList> childRelationLists;
		Map<String, RelationList> refRelationLists;
	};
	
	public class FieldMutation {
		public enum MutationType { ADD, REMOVE, };
		MutationType type;
		Serializable field;
	};

	public class RelationMutation {
		public enum MutationType { ADD, REMOVE, };
		MutationType type;
		String recId;
	};
	
	public class RecordMutation {
		String recId;
		long baseVersion;  // Compare to the current version of the record in DB. And abort mutation if mismatch
		Map<String, FieldMutation> fieldMutations;
		Map<String, Set<RelationMutation>> childRelationList;
		Map<String, Set<RelationMutation>> refRelationList;
	};
	
	
	// Initialize common DAL for multitenancy server
	public static void Init() throws Exception {};
	
	// Get a DAL instance for a specific tenant and a specific user.
	// This static function needs to be implemented by DAL's implementation class.
	public static DalInterface getDal(String tenantId) { return null; }
	
	// Following are used for object and field customization.
	
	// Use to create a new custom object or customize an existing object.
	// Only new fields can be added to customize an existing object.
	// objDef is the XML or JSon definition of the custom object.
	// TODO: define the format of objDef 
	public String createCustomObject(String objDef, String userId) throws Exception;
	public void customizeObject(String objDef, String userId) throws Exception;
	
	// All records will be gone after deleting the object.
	public void deleteCustomObject(String objId, String userId) throws Exception;
	
	// Following are for record access
	
	// Get the current snapshot of a record from storage
	public Record lookupRecord(String userId, String objId, String recId);
	
	// Query DAL. Needs to at least support single table filtering, such as:
	// Select * from ObjectId where f1>1 AND (f2="dfd" OR f2="fd").
	// This interface may also need to support streaming of results.
	public ArrayList<Record> queryRecords(String userId, DalQuery query);
	
	// Assuming caller starts transaction 
	public void updateRecord(String userId, RecordMutation recMut, boolean externalTransaction);

	// returns recordId
	public String createRecord(String userId, Record rec, boolean externalTransaction);
	
	public void deleteRecord(String userId, String objId, String recId, boolean externalTransaction);
}
