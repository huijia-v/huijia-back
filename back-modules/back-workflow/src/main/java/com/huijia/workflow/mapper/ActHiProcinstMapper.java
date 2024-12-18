package com.huijia.workflow.mapper;

import com.baomidou.mybatisplus.annotation.InterceptorIgnore;
import com.huijia.common.mybatis.core.mapper.BaseMapperPlus;
import com.huijia.workflow.domain.ActHiProcinst;

/**
 * 流程实例Mapper接口
 *
 * @author may
 * @date 2023-07-22
 */
@InterceptorIgnore(tenantLine = "true")
public interface ActHiProcinstMapper extends BaseMapperPlus<ActHiProcinst, ActHiProcinst> {

}
