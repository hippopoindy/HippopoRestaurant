package hippopo.achabaac.hippoporestaurant;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by BAAC on 10/19/2015.
 */
public class MyOpenHelper extends SQLiteOpenHelper{

    // Explicit การประกาศตัวแปร
    // public นอกคลาสเรียกใช้ได้
    // private ในคลาส เท่านั้น เรียกใช้ได้
    // -- static ประกาศค่าคงที่ (final แก้ไขไม่ได้)
    // -- ตัวแปรที่ใช้ติดต่อ DB ใช้ตัวพิมพ์ใหญ่ เช่น DATABASE_NAME

    private static final String DATABASE_NAME = "BAAC.db";
    private static final int DATABASE_VERSION = 1;   // completment key : SHIFT+CTRL+ENTER
    private static final String CREATE_USER_TABLE = "create table userTABLE (_id integer primary key, User text, Password text, Name text);"; // SQLite คอลัมภ์แรกต้องเป็น _id เท่านั้น
    private static final String CREATE_FOOD_TABLE = "create table foodTABLE (_id integer primary key, Food text, Source text, Price text);";


    public MyOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);  //super คำสั่งจะทำงานให้อัตโนมัติ โดยเข้าไปเช็คใน DB

    }   // Constructor คือ Method ที่มีชื่อเดียวกับ Class
        // เมื่อ constructor ทำงาน จะต่อท่อ (context) ไปยัง class หลัก

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_USER_TABLE);  //สร้างตารางไว้รอ
        sqLiteDatabase.execSQL(CREATE_FOOD_TABLE);


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}   // Main Class นี่คือคลาสหลัก นะแจร้ะ
