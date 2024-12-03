package com.huijia.workflow.mapper;

import com.baomidou.mybatisplus.annotation.InterceptorIgnore;
import com.huijia.common.mybatis.core.mapper.BaseMapperPlus;
import com.huijia.workflow.domain.ActHiTaskinst;

/**
 * 流程历史任务Mapper接口
 *
 * @author may
 * @date 2024-03-02
 */
@InterceptorIgnore(tenantLine = "true")
public interface ActHiTaskinstMapper extends BaseMapperPlus<ActHiTaskinst, ActHiTaskinst> {

}
