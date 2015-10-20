package hippopo.achabaac.hippoporestaurant;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    //Explicit ประกาศตัวแปร
    private UserTABLE objUserTABLE;
    private FoodTABLE objFoodTABLE; //ตัวแปรสีเทา (ยังไม่ใช้งาน) สีม่วง (ใช้งวานแล้ว)


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //create & connected Database
        createAndConnected();    //Method ที่ทำหน้าที่แค่ Create และ Connected Database

        //Tester Add New Value
        //testerAdd();

        //Delete All SQLite
        deleteAllSQLite();


    } // นี่คือ main Method

    private void deleteAllSQLite() {
        SQLiteDatabase objSqLiteDatabase = openOrCreateDatabase("BAAC.db", MODE_PRIVATE, null); //MODE_PRIVATE ลบ data เฉยๆ ตารางคงไว้
        objSqLiteDatabase.delete("userTABLE", null, null);
        objSqLiteDatabase.delete("foodTABLE", null, null);
    }

    private void testerAdd(){
        objUserTABLE.addNewUser("testUser", "testPassword","ทดสอบภาษาไทย");
        objFoodTABLE.addNewFood("ชื่ออาหาร", "testSource","123");
    } // method ไว้ใช้ test เพิ่มข้อมูลเข้า DB



    private void createAndConnected() {

        objUserTABLE = new UserTABLE(this); // this เรียกใช้ UserTABLE อัตโนมัติ
        objFoodTABLE = new FoodTABLE(this);

    }
}   //นี่คือ Main Class
