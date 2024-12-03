package com.huijia.workflow.controller;

import cn.dev33.satoken.annotation.SaCheckPermission;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import com.huijia.common.core.domain.R;
import com.huijia.common.core.validate.AddGroup;
import com.huijia.common.core.validate.EditGroup;
import com.huijia.common.excel.utils.ExcelUtil;
import com.huijia.common.idempotent.annotation.RepeatSubmit;
import com.huijia.common.log.annotation.Log;
import com.huijia.common.log.enums.BusinessType;
import com.huijia.common.mybatis.core.page.PageQuery;
import com.huijia.common.mybatis.core.page.TableDataInfo;
import com.huijia.common.web.core.BaseController;
import com.huijia.workflow.domain.bo.TestLeaveBo;
import com.huijia.workflow.domain.vo.TestLeaveVo;
import com.huijia.workflow.service.ITestLeaveService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 请假
 *
 * @author may
 * @date 2023-07-21
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/workflow/leave")
public class TestLeaveController extends BaseController {

    private final ITestLeaveService testLeaveService;

    /**
     * 查询请假列表
     */
    @SaCheckPermission("workflow:leave:list")
    @GetMapping("/list")
    public TableDataInfo<TestLeaveVo> list(TestLeaveBo bo, PageQuery pageQuery) {
        return testLeaveService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出请假列表
     */
    @SaCheckPermission("workflow:leave:export")
    @Log(title = "请假", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(TestLeaveBo bo, HttpServletResponse response) {
        List<TestLeaveVo> list = testLeaveService.queryList(bo);
        ExcelUtil.exportExcel(list, "请假", TestLeaveVo.class, response);
    }

    /**
     * 获取请假详细信息
     *
     * @param id 主键
     */
    @SaCheckPermission("workflow:leave:query")
    @GetMapping("/{id}")
    public R<TestLeaveVo> getInfo(@NotNull(message = "主键不能为空")
                                  @PathVariable Long id) {
        return R.ok(testLeaveService.queryById(id));
    }

    /**
     * 新增请假
     */
    @SaCheckPermission("workflow:leave:add")
    @Log(title = "请假", businessType = BusinessType.INSERT)
    @RepeatSubmit()
    @PostMapping()
    public R<TestLeaveVo> add(@Validated(AddGroup.class) @RequestBody TestLeaveBo bo) {
        return R.ok(testLeaveService.insertByBo(bo));
    }

    /**
     * 修改请假
     */
    @SaCheckPermission("workflow:leave:edit")
    @Log(title = "请假", businessType = BusinessType.UPDATE)
    @RepeatSubmit()
    @PutMapping()
    public R<TestLeaveVo> edit(@Validated(EditGroup.class) @RequestBody TestLeaveBo bo) {
        return R.ok(testLeaveService.updateByBo(bo));
    }

    /**
     * 删除请假
     *
     * @param ids 主键串
     */
    @SaCheckPermission("workflow:leave:remove")
    @Log(title = "请假", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public R<Void> remove(@NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(testLeaveService.deleteWithValidByIds(List.of(ids)));
    }
}