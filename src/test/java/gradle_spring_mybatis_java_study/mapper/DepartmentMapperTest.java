package gradle_spring_mybatis_java_study.mapper;

import java.util.List;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.junit.After;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import gradle_spring_mybatis_java_study.config.ContextRoot;
import gradle_spring_mybatis_java_study.dto.Department;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ContextRoot.class} )
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DepartmentMapperTest {
    private static final Log log = LogFactory.getLog(DepartmentMapperTest.class);

    @After
    public void tearDown() throws Exception {
        System.out.println();
    }
    
    @Autowired
    private DepartmentMapper dao;

    @Test
    public void test01SelectDepartmentByAll() {
        log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
        List<Department> list = dao.selectDepartmentByAll();
        Assert.notNull(list, "The class must not be null");
        for (Department d : list)
            log.trace(d.toString());
    }

    @Test
    public void test02SelectDepartmentByNo() {
        log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
        Department department = dao.selectDepartmentByNo(new Department(1));
        Assert.notNull(department, "The class must not be null");
        log.trace(department.toString());
    }

    @Test
    public void test03InsertDepartment() {
        log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
        Department department = new Department(5, "개발", 10);
        int res = dao.insertDepartment(department);
        Assert.isTrue(res > -1, "The value must be greater than zero");
    }

    @Test
    public void test04UpdateDepartment() {
        log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
        Department department = new Department(5, "개발2", 20);
        int res = dao.updateDepartment(department);
        Assert.isTrue(res > -1, "The value must be greater than zero");
    }

    @Test
    public void test05DeleteDepartment() {
        log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
        Department department = new Department(5);
        int res = dao.deleteDepartment(department);
        Assert.isTrue(res > -1, "The value must be greater than zero");
    }

}
