package gradle_spring_mybatis_java_study.service;

import org.springframework.stereotype.Service;

import gradle_spring_mybatis_java_study.dto.Employee;

@Service
public interface EmployeeService {
    
    public int addEmployee(Employee employee);
    
    public int delEmployee(Employee employee);
}
