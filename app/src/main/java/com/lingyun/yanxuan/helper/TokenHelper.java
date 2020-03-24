package com.lingyun.yanxuan.helper;


import com.lingyun.yanxuan.base.BaseActivity;
import com.lingyun.yanxuan.utils.SharedPreferencesUtil;
import com.lingyun.yanxuan.utils.StringUtil;

public class TokenHelper {
    final static String mTokenKey = "mAccessTokenKey";

    public static String getToken() {
        return SharedPreferencesUtil.getPreferencesByKey(BaseActivity.mContext, mTokenKey);
    }

    public static  void setToken(String token) {
        if (StringUtil.isBlank(token)){
            return;
        }
        SharedPreferencesUtil.setPreferencesByKey(BaseActivity.mContext,mTokenKey,token);
    }
}


