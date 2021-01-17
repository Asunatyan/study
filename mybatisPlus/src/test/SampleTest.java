import com.dqk.test.entity.Userinfo;
import com.dqk.test.mapper.UserinfoMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SampleTest.class)
public class SampleTest {

    @Autowired
    private UserinfoMapper userinfoMapper;

    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<Userinfo> userList = userinfoMapper.selectList(null);
        Assert.assertEquals(5, userList.size());
        userList.forEach(System.out::println);
    }

}