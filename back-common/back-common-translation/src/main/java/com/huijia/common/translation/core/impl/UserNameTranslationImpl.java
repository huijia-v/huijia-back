package com.huijia.common.translation.core.impl;

import lombok.AllArgsConstructor;
import com.huijia.common.core.service.UserService;
import com.huijia.common.translation.annotation.TranslationType;
import com.huijia.common.translation.constant.TransConstant;
import com.huijia.common.translation.core.TranslationInterface;

/**
 * 用户名翻译实现
 *
 * @author Lion Li
 */
@AllArgsConstructor
@TranslationType(type = TransConstant.USER_ID_TO_NAME)
public class UserNameTranslationImpl implements TranslationInterface<String> {

    private final UserService userService;

    @Override
    public String translation(Object key, String other) {
        if (key instanceof Long id) {
            return userService.selectUserNameById(id);
        }
        return null;
    }
}
