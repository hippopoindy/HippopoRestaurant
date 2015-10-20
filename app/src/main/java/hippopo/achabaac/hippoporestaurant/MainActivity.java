package hippopo.achabaac.hippoporestaurant;

import android.database.sqlite.SQLiteDatabase;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Switch;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

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


        // synchronize JSON to SQLite
       synJSONtoSQLite();


    } // นี่คือ main Method

    private void synJSONtoSQLite() {
        //0. Change Policy
        // เปิด Policy ทุกตัวให้สามารถใช้งานได้หมด
        StrictMode.ThreadPolicy myPolicy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(myPolicy);   //ฉันสมารถเชื่อมต่อกับ Protocol ได้แล้ว


        int intTime = 0;
        while (intTime <= 1) {

            InputStream objInputStream = null; // โหลดไปทำงานไป
            String strJSON = null;
            String strUserURL = "http://swiftcodingthai.com/baac/php_get_data_master.php";
            String strFoodURL = "http://swiftcodingthai.com/baac/php_get_food.php";
            HttpPost objHttpPost;       // build tool version 22.0.1 (Project Structure)


            //1. Create InputStream
            // JSON Array
            try {

                HttpClient objHttpClient = new DefaultHttpClient();

                switch(intTime){
                    case 0:
                        objHttpPost = new HttpPost(strUserURL); // case 0 ดึง User
                        break;
                    case 1:
                        objHttpPost = new HttpPost(strFoodURL); // case 1 ดึง Food
                        break;
                    default:
                        objHttpPost = new HttpPost(strUserURL); // บังคับค่า default เมื่อ case ไม่เท่ากับ 0 หรือ 1
                        break;
                }   //Switch

                HttpResponse objHttpResponse = objHttpClient.execute(objHttpPost);
                HttpEntity objHttpEntity = objHttpResponse.getEntity();
                objInputStream = objHttpEntity.getContent();


            } catch (Exception e) {
                Log.d("BAAC", "InputStream ==> " + e.toString());

            }

            //2. create JSON String
            try {

                BufferedReader objBufferedReader = new BufferedReader(new InputStreamReader(objInputStream, "UTF-8"));
                StringBuilder objStringBuilder = new StringBuilder();
                String strLine = null;

                while ((strLine = objBufferedReader.readLine()) != null ) {

                    objStringBuilder.append(strLine);

                }   //while

                objInputStream.close();
                strJSON = objStringBuilder.toString();

            }catch (Exception e) {
                Log.d("BAAC", "StrJSON ==>" + e.toString());
            }

            //3. Update SQlite
            try {

                JSONArray objJsonArray = new JSONArray(strJSON);

                for (int i = 0; i < objJsonArray.length(); i++) {

                    JSONObject object = objJsonArray.getJSONObject(i);

                    switch (intTime) {
                        case 0:
                            // For UserTABLE
                            String strUser = object.getString("User");
                            String strPassword = object.getString("Password");
                            String strName = object.getString("Name");
                            objUserTABLE.addNewUser(strUser, strPassword, strName);

                            break;
                        case 1:
                            // For FoodTABLE
                            String strFood = object.getString("Food");
                            String strSource = object.getString("Source");
                            String strPrice = object.getString("Price");
                            objFoodTABLE.addNewFood(strFood, strSource, strPrice);

                            break;
                    }   //switch

                } //for

            } catch (Exception e) {
                Log.d("BAAC", "Update ==>" + e.toString());
            }

            intTime += 1;  //******

        } //while


    }   // method synJSONtoSQLite

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
