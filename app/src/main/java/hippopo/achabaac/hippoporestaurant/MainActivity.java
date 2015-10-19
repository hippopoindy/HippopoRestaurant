package hippopo.achabaac.hippoporestaurant;

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
        testerAdd();


    } // นี่คือ main Method

    private void testerAdd(){
        objUserTABLE.addNewUser("testUser", "testPassword","ทดสอบภาษาไทย");
        objFoodTABLE.addNewFood("ชื่ออาหาร", "testSource","123");
    }



    private void createAndConnected() {

        objUserTABLE = new UserTABLE(this); // this เรียกใช้ UserTABLE อัตโนมัติ
        objFoodTABLE = new FoodTABLE(this);

    }
}   //นี่คือ Main Class
