import com.lin.dao.UserMapper;

import com.lin.pojo.User;
import com.lin.service.LoginUser;
import com.lin.utils.MybatisConfig;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.servlet.handler.UserRoleAuthorizationInterceptor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyTest {
    @Test
    public void test(){
        Map<String,Object> map = new HashMap<>();
        map.put("id",1);
        User user = LoginUser.getLoginUser(map);
        System.out.println(user);
    }
}
