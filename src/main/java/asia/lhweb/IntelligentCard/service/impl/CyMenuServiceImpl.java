package asia.lhweb.IntelligentCard.service.impl;

import asia.lhweb.IntelligentCard.common.Result;
import asia.lhweb.IntelligentCard.mapper.CyMenuMapper;
import asia.lhweb.IntelligentCard.model.vo.CyMenuVO;
import asia.lhweb.IntelligentCard.service.CyMenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author :罗汉
 * @date : 2024/4/10
 */
@Service
public class CyMenuServiceImpl implements CyMenuService {

    @Resource
    private CyMenuMapper cyMenuMapper;


    /**
     * 根据管理员角色ID选择菜单树
     *
     * @param adminId 管理员的唯一标识符
     * @return 返回一个结果对象，其中包含权限菜单列表。如果管理员没有任何权限，将返回错误信息。
     */
    @Override
    public Result selectMenuTreeByAdminId(Integer adminId) {
        // 根据管理员id查询菜单树
        List<CyMenuVO> cyMenuVOS = cyMenuMapper.selectMenuTreeByAdminId(adminId);
        // 如果查询结果为空，表示该管理员没有权限，返回错误信息
        if (cyMenuVOS.size() == 0) {
            return Result.error("您的权限为0");
        }
        // 获取管理员的所有权限菜单（包括子权限）
        List<CyMenuVO> cyMenuVOSList = getChildPerms(cyMenuVOS, 0);
        // 返回成功结果，包含权限菜单列表
        return Result.success(cyMenuVOSList, "获取权限菜单成功");
    }



    /**
     * 根据父节点的ID获取所有子节点
     *
     * @param list     分类表
     * @param parentId 传入的父节点ID
     * @return String
     */
    public List<CyMenuVO> getChildPerms(List<CyMenuVO> list, int parentId) {
        List<CyMenuVO> returnList = new ArrayList<CyMenuVO>();
        for (Iterator<CyMenuVO> iterator = list.iterator(); iterator.hasNext(); ) {
            CyMenuVO t = iterator.next();
            // 一、根据传入的某个父节点ID,遍历该父节点的所有子节点
            if (t.getMenuParentId() == parentId) {
                recursionFn(list, t);
                returnList.add(t);
            }
        }
        return returnList;
    }

    /**
     * 递归列表
     *
     * @param list 分类表
     * @param t    子节点
     */
    private void recursionFn(List<CyMenuVO> list, CyMenuVO t) {
        // 得到子节点列表
        List<CyMenuVO> childList = getChildList(list, t);
        t.setCyMenuVOList(childList);
        for (CyMenuVO tChild : childList) {
            if (hasChild(list, tChild)) {
                recursionFn(list, tChild);
            }
        }
    }

    /**
     * 得到子节点列表
     */
    private List<CyMenuVO> getChildList(List<CyMenuVO> list, CyMenuVO t) {
        List<CyMenuVO> tlist = new ArrayList<CyMenuVO>();
        Iterator<CyMenuVO> it = list.iterator();
        while (it.hasNext()) {
            CyMenuVO n = (CyMenuVO) it.next();
            if (n.getMenuParentId().longValue() == t.getMenuId().longValue()) {
                tlist.add(n);
            }
        }
        return tlist;
    }

    /**
     * 判断是否有子节点
     */
    private boolean hasChild(List<CyMenuVO> list, CyMenuVO t) {
        return getChildList(list, t).size() > 0;
    }

}
