package org.weex.plugin.alipush;

import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.bridge.JSCallback;
import com.taobao.weex.common.WXModule;

import org.weex.plugin.receiver.MyAliPushReceiver;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liumeng
 * 阿里推送功能集成
 */

public class AlipushModule extends WXModule {

    /**
     * 收到通知
     * @param jsCallback
     */
    @JSMethod(uiThread = true)
    public void receiveNotification(JSCallback jsCallback){
        MyAliPushReceiver.myJsCallback1 = jsCallback;
    }

    /**
     * 收到消息
     * @param jsCallback
     */
    @JSMethod(uiThread = true)
    public void receiveAlimessage(JSCallback jsCallback){
        MyAliPushReceiver.myJsCallback2 = jsCallback;

    }

    /**
     * 通知点击
     * @param jsCallback
     */
    @JSMethod(uiThread = true)
    public void notifacationClick(JSCallback jsCallback){
        MyAliPushReceiver.myJsCallback3 = jsCallback;

    }

    @JSMethod(uiThread = true)
    public void getDeviceId(JSCallback jsCallback){
        Map<String,Object> params = new HashMap<>();
        params.put("deviceId",AliPushConstant.deviceId);
        jsCallback.invoke(params);

    }
}
