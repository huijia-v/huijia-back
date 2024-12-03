package com.huijia.workflow.domain.bo;

import io.github.linpeilie.annotations.AutoMapper;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import com.huijia.common.core.validate.AddGroup;
import com.huijia.common.core.validate.EditGroup;
import com.huijia.common.mybatis.core.domain.BaseEntity;
import com.huijia.workflow.domain.WfFormManage;

/**
 * 表单管理业务对象 wf_form_manage
 *
 * @author may
 * @date 2024-03-29
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = WfFormManage.class, reverseConvertGenerate = false)
public class WfFormManageBo extends BaseEntity {

    /**
     * 主键
     */
    @NotNull(message = "主键不能为空", groups = { EditGroup.class })
    private Long id;

    /**
     * 表单名称
     */
    @NotBlank(message = "表单名称不能为空", groups = { AddGroup.class, EditGroup.class })
    private String formName;

    /**
     * 表单类型
     */
    @NotBlank(message = "表单类型不能为空", groups = { AddGroup.class, EditGroup.class })
    private String formType;
    /**
     * 路由地址/表单ID
     */
    @NotBlank(message = "路由地址/表单ID不能为空", groups = { AddGroup.class, EditGroup.class })
    private String router;


    /**
     * 备注
     */
    private String remark;


}
