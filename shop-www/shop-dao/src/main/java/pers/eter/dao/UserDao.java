package pers.eter.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import pers.eter.core.model.User;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Eter on 17-6-5.
 */
@Resource
public interface UserDao {
    @Insert("insert into xx_user (uname, pwd, nation, location) values (#{uname},#{pwd},#{nation},#{location})")
    @Options(keyProperty = "userId", useGeneratedKeys = true)
    int insert(User user);


/*    @Select("select user_id,uname,pwd,nation,location from xx_user where   uname like concat('%',#{uname},'%')")*/
    @Select("select user_id,uname,pwd,nation,location from xx_user where   uname like '%${uname}%'")
    List<User> find(@Param(value = "uname") String uname);
}
