package asia.lhweb.IntelligentCard.service.impl;


import asia.lhweb.IntelligentCard.common.Result;
import asia.lhweb.IntelligentCard.constant.LhIntelligentCardConstant;
import asia.lhweb.IntelligentCard.mapper.CyAdminMapper;
import asia.lhweb.IntelligentCard.model.PageResult;
import asia.lhweb.IntelligentCard.model.dto.CyAdminDTO;
import asia.lhweb.IntelligentCard.model.pojo.CyAdmin;
import asia.lhweb.IntelligentCard.model.vo.CyAdminVO;
import asia.lhweb.IntelligentCard.service.CyAdminService;
import asia.lhweb.IntelligentCard.utils.JwtUtil;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author Administrator
 * @description 针对表【Cy_Admin】的数据库操作Service
 * @createDate 2024-04-03 12:56:32
 */
@Service
public class CyAdminServiceImpl implements CyAdminService {
    @Resource
    private CyAdminMapper cyAdminMapper;

    @Resource
    private RedisTemplate<String, String> redisTemplate;

    public Result selectByCyAdminDTO(CyAdminDTO cyAdminDTO) {

        return null;
    }

    /**
     * 登录
     *
     * @param account  账户
     * @param password 密码
     * @param request
     * @return {@link Result}<{@link CyAdminVO}>
     */
    @Override
    public Result login(String account, String password, HttpServletRequest request) {
        // 根据用户名判断 用户是否存在 不存存在就返回提示信息
        // 2 加密 import org.springframework.util.DigestUtils;
        String encryptPassword = DigestUtils.md5DigestAsHex((LhIntelligentCardConstant.SALT + password).getBytes());
        CyAdminVO cyAdminVO = cyAdminMapper.login(account, encryptPassword);
        if (cyAdminVO == null) {
            return Result.error("登录失败，账户或者密码错误");
        }
        //cyAdminVO存Map;
        HashMap<String, Object> objectObjectHashMap = new HashMap<>();
        objectObjectHashMap.put("adminId", cyAdminVO.getAdminId());
        objectObjectHashMap.put("adminAccount", cyAdminVO.getAdminAccount());

        String token = JwtUtil.createJWT(1000*60*60*24, objectObjectHashMap);
        System.out.println("生成的token："+token);

        redisTemplate.opsForValue().set(cyAdminVO.getAdminAccount(), token,1, TimeUnit.DAYS);

        // 构建新的对象，合并cyAdminVO和token
        JSONObject resultData = new JSONObject();
        resultData.put("data", cyAdminVO);
        resultData.put("token", token);
        return Result.success(resultData, "登录成功");
    }

    /**
     * 获取管理员列表
     *
     * @return {@link Result}
     */
    @Override
    public Result list() {
        // 查询所有管理员
        List<CyAdmin> cyAdminList = cyAdminMapper.list();
        if (cyAdminList.size() == 0) {
            return Result.error("管理员列表为空");
        }
        return Result.success(cyAdminList, "管理员列表获取成功");
    }

    /**
     * 更新
     *
     * @param cyAdmin cy管理
     * @return {@link Result}
     */
    @Override
    public Result update(CyAdmin cyAdmin) {
        int i = cyAdminMapper.update(cyAdmin);
        if (i == 1) {
            return Result.success("更新成功");
        } else {
            return Result.error("更新失败");
        }

    }

    /**
     * 分页
     *
     * @param cyAdmin  cy管理
     * @param pageSize 页面大小
     * @param pageNo   页面没有
     * @return {@link Result}
     */
    @Override
    public Result page(CyAdmin cyAdmin, Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        // 紧跟着的第一个select方法会被分页
        Page<CyAdmin> adminPage = cyAdminMapper.selectAllIf(cyAdmin);

        PageResult<CyAdmin> pageResult = new PageResult<>();
        pageResult.setPageNo(pageNo);
        pageResult.setPageSize(pageSize);
        pageResult.setTotalRow((int) adminPage.getTotal());
        pageResult.setItems(adminPage.getResult());
        pageResult.setPageTotalCount(adminPage.getPages());
        if (adminPage.getResult().size() == 0) {
            return Result.error("管理员列表为空");
        }
        return Result.success(pageResult, "查询分页成功");
    }

    @Override
    public Result deletesById(List<Integer> ids) {
        int res=cyAdminMapper.deletesById(ids);
        if (res>=1){
            return Result.success(res,"删除成功");
        }
        return Result.error("删除失败");
    }
}
