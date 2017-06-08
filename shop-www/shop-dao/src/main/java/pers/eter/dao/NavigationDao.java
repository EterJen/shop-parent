package pers.eter.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import pers.eter.core.model.Navigation;

import java.util.List;

/**
 * Created by Eter on 17-6-8.
 */

public interface NavigationDao {

    /*	@Select("select id, name, url, is_blank_target from xx_navigation where position = #{position} order by orders")
    List<Navigation> find(@Param(value="position") Integer position);*/

    @Select("select id, name, url ,is_blank_target from xx_navigation where position = #{position} order by orders")
    List<Navigation> find(@Param(value = "position")Integer position);
}
