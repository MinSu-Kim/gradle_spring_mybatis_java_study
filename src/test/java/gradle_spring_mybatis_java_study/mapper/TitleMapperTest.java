package gradle_spring_mybatis_java_study.mapper;

import static org.junit.Assert.fail;

import java.util.List;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import gradle_spring_mybatis_java_study.config.ContextRoot;
import gradle_spring_mybatis_java_study.dto.Title;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ContextRoot.class })
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TitleMapperTest {
    private static final Log log = LogFactory.getLog(TitleMapperTest.class);

    @After
    public void tearDown() throws Exception {
        System.out.println();
    }

    @Autowired
    private TitleMapper dao;

    @Test
    public void testDeleteTitle() {
        fail("Not yet implemented");
    }

    @Test
    public void testInsertTitle() {
        fail("Not yet implemented");
    }

    @Test
    public void testSelectTitleByNo() {
        fail("Not yet implemented");
    }

    @Test
    public void testSelectTitleByAll() {
        log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
        List<Title> list = dao.selectTitleByAll();
        Assert.assertNotNull(list);
        list.stream().forEach(System.out::println);
    }

    @Test
    public void testUpdateTitle() {
        fail("Not yet implemented");
    }

}
