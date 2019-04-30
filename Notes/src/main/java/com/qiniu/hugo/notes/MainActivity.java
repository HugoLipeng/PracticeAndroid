package com.qiniu.hugo.notes;

import android.app.Activity;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by hugo on 2019/4/30.
 */

public class MainActivity extends Activity {

    private NotesDB notesDB;
    private SQLiteDatabase dbwriter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        notesDB = new NotesDB(this);
        dbwriter = notesDB.getWritableDatabase();
        addDB();
    }

    public void addDB(){
        ContentValues cv = new ContentValues();
        cv.put(NotesDB.CONTENT,"hello");
        cv.put(NotesDB.TIME,getTime());
        dbwriter.insert(NotesDB.TABLE_NAME,null,cv);
    }

    private String getTime() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        Date curDate = new Date();
        String str = format.format(curDate);
        return str;
    }


}
