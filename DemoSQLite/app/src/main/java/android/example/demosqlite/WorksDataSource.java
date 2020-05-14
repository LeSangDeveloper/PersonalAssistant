package android.example.demosqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;

import androidx.viewpager.widget.PagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class WorksDataSource {

    private SQLiteDatabase db;
    private MySQLiteHelper dbHelper;
    private String[] ALL_COLUMNS = {MySQLiteHelper.COLUMN_ID, MySQLiteHelper.COLUMN_TITLE, MySQLiteHelper.COLUMN_DATE, MySQLiteHelper.COLUMN_TIME};

    public WorksDataSource(Context context)
    {
        dbHelper = new MySQLiteHelper(context);
    }

    public void open() throws SQLException
    {
        db = dbHelper.getWritableDatabase();
    }

    public void close()
    {
        dbHelper.close();
    }

    public Work createWork(String pTitle, String pDate, String pTime)
    {
        ContentValues values = new ContentValues();
        values.put(MySQLiteHelper.COLUMN_TITLE, pTitle);
        values.put(MySQLiteHelper.COLUMN_DATE, pDate);
        values.put(MySQLiteHelper.COLUMN_TIME, pTime);
        long insertId = db.insert(MySQLiteHelper.TABLE_WORK, null, values);

        Cursor cursor = db.query(MySQLiteHelper.TABLE_WORK, ALL_COLUMNS, MySQLiteHelper.COLUMN_ID + " = " + insertId, null, null, null, null);
        cursor.moveToFirst();
        Work newWork = cursorToWork(cursor);
        cursor.close();
        return newWork;
    }

    public void deleteWork(Work w) {
        long id = w.getId();
        Log.e("SQLite", "Person entry deleted with id: " + id);
        db.delete(MySQLiteHelper.TABLE_WORK, MySQLiteHelper.COLUMN_ID
                + " = " + id, null);
    }

    public List<Work> getAllWork() {
        List<Work> works = new ArrayList<Work>();

        Cursor cursor = db.query(MySQLiteHelper.TABLE_WORK,
                ALL_COLUMNS, null, null, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Work work = cursorToWork(cursor);
            works.add(work);
            cursor.moveToNext();
        }
        // đóng con trỏ lại nhé.
        cursor.close();
        return works;
    }

    private Work cursorToWork(Cursor cursor)
    {
        Work work = new Work();
        work.setId(cursor.getLong(0));
        work.setTitle(cursor.getString(1));
        work.setDate(cursor.getString(2));
        work.setTime(cursor.getString(3));
        return work;
    }

}
