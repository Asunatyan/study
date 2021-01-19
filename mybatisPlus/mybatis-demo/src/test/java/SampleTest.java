import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dqk.test.MybatisPlusTestApplication;
import com.dqk.test.entity.Userinfo;
import com.dqk.test.mapper.UserinfoMapper;
import com.dqk.test.service.IUserinfoService;
import com.github.pagehelper.PageHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MybatisPlusTestApplication.class)//这里是spring启动类的class  要不然什么都会报错
public class SampleTest {

    @Autowired
    private UserinfoMapper userinfoMapper;
    @Autowired
    private IUserinfoService userinfoService;

    @Test
    public void testSelect() {
        /*System.out.println(("----- selectAll method test ------"));
        QueryWrapper<Userinfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.gt("id", "90");
        //PageHelper.startPage(1, 2);
        List<Userinfo> userList = userinfoMapper.selectList(queryWrapper);*/
        List<Userinfo> userinfoList = userinfoMapper.selectFromUser();
        System.out.println(userinfoList.toString());


        //userList.forEach(System.out::println);
        /*PageHelper.startPage(0, 2);
        List<Userinfo> userList = userinfoMapper.selectList123545();

        */

        /*List<Userinfo> bathUserInfor = new ArrayList<>();
        for (int i = 30; i < 100; i++) {
            Userinfo e = new Userinfo();
            e.setId(i);
            e.setAge(i);
            e.setName(i + "");
            e.setPhone(i + "");
            e.setRemark("" + i);
            bathUserInfor.add(e);
        }
        userinfoService.saveBatch(bathUserInfor);*/


    }

}