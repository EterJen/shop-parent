package pers.eter.service;

import org.springframework.stereotype.Service;
import pers.eter.core.exeception.ParamException;
import pers.eter.core.model.Navigation;
import pers.eter.dao.NavigationDao;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Eter on 17-6-8.
 */
@Service
public class NavigationService {
    /*	@Autowired
    private NavigationDao navigationDao;

	 * 查询顶部导航
	 * @return
    public List<Navigation> find(Integer position) {
        // 非空判断
        if (position == null) {
            throw new ParamException("请输入导航位置");
        }
        List<Navigation> navigations = navigationDao.find(position);
        return navigations;
    }
*/
    @Resource
    private NavigationDao navigationDao;

    public List<Navigation> find(Integer position) {
        if (null == position) {
            throw new ParamException("请输入导航位置");
        }

        List<Navigation> navigations = navigationDao.find(position);
        return navigations;
    }
}
