package com.szp.sdb;

import android.app.Application;
import android.util.Log;
import com.szp.sbase.ISApplication;
import com.szp.sdb.greendao.DaoMaster;
import com.szp.sdb.greendao.DaoSession;

public class SDBApplication implements ISApplication {

  public static final boolean ENCRYPTED = false;

  private final String DBNAME = "sunzeping";

  private static DaoSession daoSession;

  private final String PASSWORD = "123456";

  @Override public void init(Application application) {
    Log.e("szp", "SDBApplication");
    DaoMaster.DevOpenHelper helper =
        new DaoMaster.DevOpenHelper(application.getApplicationContext(), DBNAME);
    if (ENCRYPTED) {
      daoSession = new DaoMaster(helper.getEncryptedWritableDb(PASSWORD)).newSession();
    } else {
      daoSession = new DaoMaster(helper.getWritableDb()).newSession();
    }
  }



  public static DaoSession getDaoSession() {
    return daoSession;
  }
}
