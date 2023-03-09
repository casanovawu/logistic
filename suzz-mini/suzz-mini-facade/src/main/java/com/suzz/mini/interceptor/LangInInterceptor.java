package com.suzz.mini.interceptor;

import com.suzz.platform.constant.DubboConstants;
import com.suzz.platform.util.LangContent;
import org.apache.dubbo.common.extension.Activate;
import org.apache.dubbo.rpc.*;

/**
 * @author subo
 * @date 2022/5/20 0:53
 **/
@Activate(group = {DubboConstants.PROVIDER})
public class LangInInterceptor implements Filter {

    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        String lang = invocation.getAttachment("language");
        LangContent.setLang(lang);
        return invoker.invoke(invocation);
    }
}
