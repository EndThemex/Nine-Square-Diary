package com.endtheme.ninesquarediary;

import java.util.HashMap;
import java.util.Map;

import com.endtheme.ninesquarediary.model.User;


public class AppContext {

    private static ThreadLocal<AppContext> appContextMap = new ThreadLocal<AppContext>();
    private Map<String, Object> objects = new HashMap<String, Object>();
    private static String contextPath;


    public static String getContextPath() {
        return contextPath;
    }

    public static void setContextPath(String contextPath) {
        if (AppContext.contextPath == null) {
            AppContext.contextPath = contextPath;
        }
    }
    public Map<String, Object> getObjects() {
        return objects;
    }

    public void setObjects(Map<String, Object> objects) {
        if (objects == null) {
            objects = new HashMap<String, Object>();
        }
        this.objects = objects;
    }

    public void addObjects(String key, Object object) {
        this.objects.put(key, object);
    }

    public Object getObject(String key) {
        return objects.get(key);
    }

    public void clear() {
        AppContext context = appContextMap.get();
        if (context != null) {
            context.objects.clear();
        }
        context = null;
    }

    private AppContext() {}

    public static AppContext getAppContext() {
        AppContext appContext = appContextMap.get();
        if (appContext == null) {
            appContext = new AppContext();
            appContextMap.set(appContext);
        }

        return appContextMap.get();
    }

    public void removeObject(String string) {
        objects.remove(string);
    }

    public User getUser() {
        return (User) objects.get("user");
    }

    public String getUserName() {
        String userName = "";
        User user = (User) objects.get("user");
        if (user != null) {
            userName = user.getUserName();
        }

        return userName;
    }

    public int getUserId() {
        int userId = 0;
        User user = (User) objects.get("user");
        if (user != null) {
            userId = user.getId();
        }

        return userId;
    }

}
