package hippopo.achabaac.hippoporestaurant;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    //Explicit ประกาศตัวแปร
    private UserTABLE objUserTABLE;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //create & connected Database
        creatAndConnected();    //Method ที่ทำหน้าที่แค่ Create และ Connected Database

    } // นี่คือ main Method

    private void creatAndConnected() {

        objUserTABLE = new UserTABLE(this); // this เรียกใช้ UserTABLE อัตโนมัติ

    }
}   //นี่คือ Main Class
