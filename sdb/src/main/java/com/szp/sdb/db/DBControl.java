package com.szp.sdb.db;

import com.szp.sdb.SDBApplication;
import com.szp.sdb.entity.Student;
import com.szp.sdb.greendao.StudentDao;
import java.util.List;
import java.util.Observer;
import org.greenrobot.greendao.query.QueryBuilder;
import org.greenrobot.greendao.rx.RxQuery;
import rx.Observable;

public class DBControl {

  /**
   * 添加student
   * @param student
   * @return
   */
  public static Observable<Student> insertStudent(Student student){
    return SDBApplication.getDaoSession().getStudentDao().rx().insert(student);
  }

  /**
   * 查找所有的students
   * @return
   */
  public static Observable<List<Student>> getStudents(){
    return SDBApplication.getDaoSession().getStudentDao().rx().loadAll();
  }

  public static Observable<Student> getStudentByKey(long id){
    return SDBApplication.getDaoSession().getStudentDao().rx().load(id);
  }

  public static Observable<Void> deleteByKey(Long key) {
    return SDBApplication.getDaoSession().getStudentDao().rx().deleteByKey(key);
  }

  ///**
  // *
  // * @param condition
  // * @return
  // */
  //public static Observable<Student> getStusentByCondition(String... condition){
  //  SDBApplication.getDaoSession().getStudentDao().queryBuilder().where(
  //      StudentDao.Properties.Name.eq(condition[0]));
  //  return ;
  //}


}
