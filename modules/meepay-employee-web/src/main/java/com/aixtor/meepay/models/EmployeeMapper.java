package com.aixtor.meepay.models;

import com.aixtor.meepay.model.Branch;
import com.aixtor.meepay.model.Department;
import com.aixtor.meepay.model.Designation;

import java.util.HashMap;
import java.util.List;

public class EmployeeMapper {
	public static HashMap<Long, String>branchMap = new HashMap<Long, String>();
	public static HashMap<Long, String>departmentMap = new HashMap<Long,String>();
	public static HashMap<Long, String> designationMap = new HashMap<Long,String>();
	
	public EmployeeMapper(List<Branch> branchList,List<Department> departmentList,List<Designation> designationList){
		for (Branch branch : branchList)
			branchMap.put(branch.getBranchId(), branch.getName());
		
		for (Department department : departmentList)
			departmentMap.put(department.getDepartmentId(), department.getName());

		for (Designation designation : designationList)
			designationMap.put(designation.getDesignationId(), designation.getName());

	}
	
}
