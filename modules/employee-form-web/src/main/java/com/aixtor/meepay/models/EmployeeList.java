package com.aixtor.meepay.models;

import com.aixtor.meepay.model.Branch;
import com.aixtor.meepay.model.Department;
import com.aixtor.meepay.model.Designation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//global list to store all employees
public class EmployeeList {

	public static final ArrayList<EmployeeWebModel> EMPLOYEE_LIST=  new ArrayList<EmployeeWebModel>();
	public static final ArrayList<Designation> DESIGNATION_LIST =  new ArrayList<Designation>();
//	public static final ArrayList<Employee> EMPLOYEE_LIST=  new ArrayList<Employee>();
//	public static final ArrayList<Employee> EMPLOYEE_LIST=  new ArrayList<Employee>();
	
	
	public static HashMap<Long, String>branchMap = new HashMap<Long, String>();
	public static HashMap<Long, String>departmentMap = new HashMap<Long,String>();
	public static HashMap<Long, String> designationMap = new HashMap<Long,String>();
	
	public EmployeeList(List<Branch> branchList,List<Department> departmentList,List<Designation> designationList){
		for (Branch branch : branchList)
			branchMap.put(branch.getBranchId(), branch.getName());
		
		for (Department department : departmentList)
			departmentMap.put(department.getDepartmentId(), department.getName());

		for (Designation designation : designationList)
			designationMap.put(designation.getDesignationId(), designation.getName());

	}
	
}
