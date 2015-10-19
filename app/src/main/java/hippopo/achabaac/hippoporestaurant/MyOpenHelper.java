package hippopo.achabaac.hippoporestaurant;

import android.content.Context;

/**
 * Created by BAAC on 10/19/2015.
 */
public class MyOpenHelper {

    // Explicit การประกาศตัวแปร
    // public นอกคลาสเรียกใช้ได้
    // private ในคลาส เท่านั้น เรียกใช้ได้
    // -- static ประกาศค่าคงที่ (final แก้ไขไม่ได้)
    // -- ตัวแปรที่ใช้ติดต่อ DB ใช้ตัวพิมพ์ใหญ่ เช่น DATABASE_NAME

    private static final String DATABASE_NAME = "BAAC.db";
    private static final int DATABASE_VERSION = 1;   // completment key : SHIFT+CTRL+ENTER



    public MyOpenHelper(Context context) {
        // เมื่อ constructor ทำงาน จะต่อท่อ (context) ไปยัง class หลัก
    }   // Constructor คือ Method ที่มีชื่อเดียวกับ Class

}   // Main Class นี่คือคลาสหลัก นะแจร้ะ
