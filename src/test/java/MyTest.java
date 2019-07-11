import com.woodwang.ClusterExample;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Title:MyTest
 * @Description:
 * @Comment:
 * @Company:ultrapower
 * @author:wang_ll
 * @date :2018-12-24
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:quartz.xml" })
public class MyTest {

    @Test
    public void testJdbcCluster(){
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("quartz.xml");
        SchedulerFactoryBean factoryBean = (SchedulerFactoryBean)context.getBean("schedulerMan");

        boolean clearJobs = false;
        boolean scheduleJobs = true;

        ClusterExample example = new ClusterExample(factoryBean);
        try {
            example.run(clearJobs, scheduleJobs);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}