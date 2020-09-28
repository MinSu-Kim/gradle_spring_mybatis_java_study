package gradle_spring_mybatis_java_study.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gradle_spring_mybatis_java_study.dto.Department;
import gradle_spring_mybatis_java_study.dto.Employee;
import gradle_spring_mybatis_java_study.mapper.DepartmentMapper;
import gradle_spring_mybatis_java_study.mapper.EmployeeMapper;
import gradle_spring_mybatis_java_study.service.TransactionAOPService;

@Service
public class TransactionAOPServiceImpl implements TransactionAOPService {
    @Autowired
    private DepartmentMapper deptMapper;

    @Autowired
    private EmployeeMapper empMapper;

    @Override
    public int trRegister(Department department, Employee employee) {
        int res = deptMapper.insertDepartment(department);
        res += empMapper.insertEmployee(employee);
        if (res !=2 ) throw new RuntimeException();
        return res;
    }

    @Override
    public int trUnRegister(Department department, Employee employee) {
        int res = empMapper.deleteEmployee(employee);
        res += deptMapper.deleteDepartment(department);
        if (res !=2 ) throw new RuntimeException();
        return res;
    }

}
