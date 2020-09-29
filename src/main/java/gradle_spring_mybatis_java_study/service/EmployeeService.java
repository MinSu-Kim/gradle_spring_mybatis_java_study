package gradle_spring_mybatis_java_study.service;

import gradle_spring_mybatis_java_study.dto.Employee;

public interface EmployeeService {
    int addEmployee(Employee employee);
    int delEmployee(Employee employee);
}
