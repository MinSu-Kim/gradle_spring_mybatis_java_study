package gradle_spring_mybatis_java_study.service;

import java.sql.SQLException;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.junit.After;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import gradle_spring_mybatis_java_study.config.ContextRoot;
import gradle_spring_mybatis_java_study.dto.Department;
import gradle_spring_mybatis_java_study.dto.Employee;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ContextRoot.class} )
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TransactionAOPServiceTest {
    private static final Log log = LogFactory.getLog(TransactionAOPServiceTest.class);

    @After
    public void tearDown() throws Exception {
        System.out.println();
    }

    @Autowired
    private TransactionAOPService service;

    @Test(expected = DuplicateKeyException.class)
    public void test1registerTransaction_Dept_Fail() throws SQLException {
        log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
        Department department = new Department(1, "태스크포스", 10); // DuplicateKeyException
        Employee employee = new Employee(1004, "박신혜", "과장", new Employee(4377), 4100000, department);

        service.trRegister(department, employee);
    }

    @Test(expected = DuplicateKeyException.class)
    public void test2registerTransaction_Emp_Fail() throws SQLException {
        log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
        Department department = new Department(6, "태스크포스", 10);
        Employee employee = new Employee(4377, "박신혜", "과장", new Employee(4377), 4100000, department); 

        service.trRegister(department, employee);
    }
    
    @Test
    public void test3registerTransaction_Success() throws SQLException {
        log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
        Department department = new Department(6, "태스크포스", 10);
        Employee employee = new Employee(1005, "박신혜", "과장", new Employee(4377), 4100000, department);

        service.trRegister(department, employee);
    }

    @Test(expected=RuntimeException.class)
    public void test4UnregisterTransaction_Fail_Dept() throws SQLException {
        log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
        Department department = new Department(100); // RuntimeException -> rollback
        Employee employee = new Employee(1005); // rollback 되므로 삭제되면 안됨

        service.trUnRegister(department, employee);
    }
    
    @Test (expected=RuntimeException.class)
    public void test5UnregisterTransaction_Fail_Emp() throws SQLException {
        log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
        Department department = new Department(6);// 정상삭제
        Employee employee = new Employee(9999);// RuntimeException -> rollback

        service.trUnRegister(department, employee);
    }

    @Test 
    public void test6UnregisterTransaction_Success() throws SQLException {
        log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
        Department department = new Department(6);
        Employee employee = new Employee(1005);

        service.trUnRegister(department, employee);
    }
}
