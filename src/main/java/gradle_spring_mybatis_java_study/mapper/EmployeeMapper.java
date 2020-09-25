package gradle_spring_mybatis_java_study.mapper;

import gradle_spring_mybatis_java_study.dto.Employee;

public interface EmployeeMapper {
    int insertEmployee(Employee employee);
    int deleteEmployee(Employee employee);
}
