package com.szp.xiaosungege;

import android.app.Application;
import com.szp.sbase.ISApplication;

public class BaseApplication extends Application {

  private static BaseApplication sBaseApplication;

  private static final String[] MODULESLIST = {
      "com.szp.sdb.SDBApplication"
  };

  @Override public void onCreate() {
    super.onCreate();
    //init all module application
    modulesApplicationInit();
  }



  public static BaseApplication getInstance(){
    if(sBaseApplication == null){
      sBaseApplication = new BaseApplication();
    }
    return sBaseApplication;
  }

  private void modulesApplicationInit() {
    for (String moduleImpl : MODULESLIST) {
      try {
        Class<?> clazz = Class.forName(moduleImpl);
        Object obj = clazz.newInstance();
        if (obj instanceof ISApplication) {
          ((ISApplication) obj).init(BaseApplication.this);
        }
      } catch (ClassNotFoundException e) {
        e.printStackTrace();
      } catch (IllegalAccessException e) {
        e.printStackTrace();
      } catch (InstantiationException e) {
        e.printStackTrace();
      }
    }
  }
}
