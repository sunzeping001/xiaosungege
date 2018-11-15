package com.szp.sdb;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.szp.sdb.db.DBControl;
import com.szp.sdb.entity.Student;
import java.util.List;
import rx.Observable;
import rx.Observer;
import rx.Scheduler;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class DBMainActivity extends Activity {

  Button btn_insert;
  Button btn_delet;
  Button btn_update;
  Button btn_search;
  EditText edt_id;
  TextView tv_show;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    btn_insert = (Button) findViewById(R.id.btn_insert);
    btn_delet = (Button) findViewById(R.id.btn_delet);
    btn_update = (Button) findViewById(R.id.btn_update);
    btn_search = (Button) findViewById(R.id.btn_search);
    edt_id = (EditText) findViewById(R.id.edt_id);
    tv_show = (TextView) findViewById(R.id.tv_show);
    tv_show.setMovementMethod(ScrollingMovementMethod.getInstance());
    btn_insert.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        tv_show.append("开始插入数据：\n");
        Log.e("szp", "start-------------------------->");
        insert();
        Log.e("szp", "end-------------------------->");
        tv_show.append("插入数据结束：\n");
      }
    });

    btn_search.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        tv_show.append("开始查询数据：\n");
        Log.e("szp", "start-------------------------->");
        getAllStudents();
        Log.e("szp", "end-------------------------->");
        tv_show.append("查询数据结束：\n");
      }
    });

    btn_delet.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        tv_show.append("开始删除数据：\n");
        Log.e("szp", "start-------------------------->");
        long id = TextUtils.isEmpty(edt_id.getText().toString()) ? 0
            : Long.parseLong(edt_id.getText().toString());
        deleteStudent(id);
        Log.e("szp", "end-------------------------->");
      }
    });
  }

  /**
   * tainaji
   */
  private void insert() {
    Student student = new Student();
    student.setName("szp");
    student.setAge("23");
    student.setSex("man");

    DBControl.insertStudent(student)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Subscriber<Student>() {
          @Override public void onCompleted() {
            Log.e("szp", "finished");
          }

          @Override public void onError(Throwable e) {
            Log.e("szp", e == null ? "error" : e.getLocalizedMessage());
          }

          @Override public void onNext(Student student) {
            tv_show.append("数据：name = " + student.getId() + "\n");
            tv_show.append("数据：name = " + student.getName() + "\n");
            tv_show.append("数据：name = " + student.getAge() + "\n");
            tv_show.append("数据：name = " + student.getSex() + "\n");
          }
        });
  }

  /**
   * search
   */
  private void getAllStudents() {

    DBControl.getStudents()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Subscriber<List<Student>>() {
          @Override public void onCompleted() {
            Log.e("szp", "finished");
          }

          @Override public void onError(Throwable e) {
            Log.e("szp", e == null ? "error" : e.getLocalizedMessage());
          }

          @Override public void onNext(List<Student> students) {
            for (Student student : students) {
              tv_show.append("查询数据结束：id =" + student.getId() + "\n");
              tv_show.append("查询数据结束：name =" + student.getName() + "\n");
              tv_show.append("查询数据结束：sex =" + student.getSex() + "\n");
              tv_show.append("查询数据结束：age =" + student.getAge() + "\n");
            }
          }
        });
  }

  /**
   * delete
   */
  private void deleteStudent(long id) {
    DBControl.deleteByKey(id)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Subscriber<Void>() {
          @Override public void onCompleted() {
            Log.e("szp", "finished");
          }

          @Override public void onError(Throwable e) {
            Log.e("szp", e == null ? "" : e.getLocalizedMessage());
          }

          @Override public void onNext(Void aVoid) {
            tv_show.append("删除数据结束：\n");
          }
        });
  }
}
