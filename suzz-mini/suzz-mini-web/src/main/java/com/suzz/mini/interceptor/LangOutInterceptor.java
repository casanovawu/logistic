package com.suzz.mini.interceptor;


import com.suzz.platform.constant.DubboConstants;
import com.suzz.platform.util.LangContent;
import org.apache.dubbo.common.extension.Activate;
import org.apache.dubbo.rpc.*;

import java.util.Map;

/**
 * @author subo
 * @date 2022/5/20 0:50
 **/
@Activate(group = {DubboConstants.CONSUMER})
public class LangOutInterceptor implements Filter {

    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        Map<String, String> map = invocation.getAttachments();
        map.put("language", LangContent.getLang());
        return invoker.invoke(invocation);
    }
}
