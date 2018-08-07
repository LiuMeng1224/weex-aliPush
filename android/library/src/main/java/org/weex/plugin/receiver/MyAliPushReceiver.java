package org.weex.plugin.receiver;

import android.content.Context;
import android.util.Log;

import com.alibaba.sdk.android.push.MessageReceiver;
import com.alibaba.sdk.android.push.notification.CPushMessage;
import com.taobao.weex.bridge.JSCallback;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/10/20.
 * @author liumeng
 * 阿里推送
 * 继承自com.alibaba.sdk.android.push.MessageReceiver，并在对应回调中添加业务处理逻辑
 */

public class MyAliPushReceiver extends MessageReceiver {
    // 消息接收部分的LOG_TAG
    public static final String REC_TAG = "receiver";
    public static JSCallback myJsCallback1 = null;
    public static JSCallback myJsCallback2 = null;
    public static JSCallback myJsCallback3 = null;

    @Override
    public void onNotification(Context context, String title, String summary, Map<String, String> extraMap) {
        // TODO 处理推送通知

        Map<String,String> params = new HashMap<>();
        params.put("title",title);
        params.put("summary",summary);
        params.put("extraMap",extraMap.toString());
        if(myJsCallback1!=null){
            myJsCallback1.invoke(params);
        }
        Log.e("MyMessageReceiver", "Receive notification, title: " + title + ", summary: " + summary + ", extraMap: " + extraMap);
    }
    @Override
    public void onMessage(Context context, CPushMessage cPushMessage) {

        Map<String,String> params = new HashMap<>();
        params.put("messageId",cPushMessage.getMessageId());
        params.put("title",cPushMessage.getTitle());
        params.put("content",cPushMessage.getContent());
        if(myJsCallback2!=null){
            myJsCallback2.invoke(params);
        }
        Log.e("MyMessageReceiver", "onMessage, messageId: " + cPushMessage.getMessageId() + ", title: " + cPushMessage.getTitle() + ", content:" + cPushMessage.getContent());

    }
    @Override
    public void onNotificationOpened(Context context, String title, String summary, String extraMap) {
        Map<String,String> params = new HashMap<>();
        //params.put("messageId",cPushMessage.getMessageId());
        params.put("title",title);
        params.put("content",extraMap);
        if(myJsCallback3!=null){
            myJsCallback3.invoke(params);
        }
        Log.e("MyMessageReceiver", "onNotificationOpened, title: " + title + ", summary: " + summary + ", extraMap:" + extraMap);
    }
    @Override
    protected void onNotificationClickedWithNoAction(Context context, String title, String summary, String extraMap) {
        Log.e("MyMessageReceiver", "onNotificationClickedWithNoAction, title: " + title + ", summary: " + summary + ", extraMap:" + extraMap);
    }
    @Override
    protected void onNotificationReceivedInApp(Context context, String title, String summary, Map<String, String> extraMap, int openType, String openActivity, String openUrl) {
        Log.e("MyMessageReceiver", "onNotificationReceivedInApp, title: " + title + ", summary: " + summary + ", extraMap:" + extraMap + ", openType:" + openType + ", openActivity:" + openActivity + ", openUrl:" + openUrl);
    }
    @Override
    protected void onNotificationRemoved(Context context, String messageId) {
        Log.e("MyMessageReceiver", "onNotificationRemoved");
    }
}
