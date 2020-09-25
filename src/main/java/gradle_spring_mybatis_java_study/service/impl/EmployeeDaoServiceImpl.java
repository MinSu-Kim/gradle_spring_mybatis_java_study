package gradle_spring_mybatis_java_study.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gradle_spring_mybatis_java_study.dto.Employee;
import gradle_spring_mybatis_java_study.mapper.EmployeeMapper;
import gradle_spring_mybatis_java_study.service.IEmployeeService;

@Service
public class EmployeeDaoServiceImpl implements IEmployeeService{
    @Autowired
    private EmployeeMapper mapper;
    
    public int addEmployee(Employee employee) {
        return mapper.insertEmployee(employee);
    }
    
    public int delEmployee(Employee employee) {
        return mapper.deleteEmployee(employee);
    }
}
