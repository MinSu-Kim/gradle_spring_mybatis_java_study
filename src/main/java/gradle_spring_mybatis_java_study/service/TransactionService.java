package gradle_spring_mybatis_java_study.service;

import gradle_spring_mybatis_java_study.dto.Department;
import gradle_spring_mybatis_java_study.dto.Employee;

public interface TransactionService {
    void registerTransaction(Department department, Employee employee);
    void unRegisterTransaction(Department department, Employee employee);
}
