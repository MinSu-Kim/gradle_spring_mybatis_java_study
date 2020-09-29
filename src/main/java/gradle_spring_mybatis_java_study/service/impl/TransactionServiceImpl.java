package gradle_spring_mybatis_java_study.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gradle_spring_mybatis_java_study.dto.Department;
import gradle_spring_mybatis_java_study.dto.Employee;
import gradle_spring_mybatis_java_study.mapper.DepartmentMapper;
import gradle_spring_mybatis_java_study.mapper.EmployeeMapper;
import gradle_spring_mybatis_java_study.service.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService {
    @Autowired
    private DepartmentMapper deptMapper;

    @Autowired
    private EmployeeMapper empMapper;

    @Override
    /* @Transactional */
    public void registerTransaction(Department department, Employee employee) {
        int res = deptMapper.insertDepartment(department);
        res += empMapper.insertEmployee(employee);
        if (res != 2) throw new RuntimeException();
    }

    @Override
    /* @Transactional(rollbackFor = SQLException.class) */
    public void unRegisterTransaction(Department department, Employee employee) {
        int res = empMapper.deleteEmployee(employee);
        res += deptMapper.deleteDepartment(department);
        if (res != 2) throw new RuntimeException();
    }


}
