package hippopo.achabaac.hippoporestaurant;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by BAAC on 10/21/2015.
 */
public class MyAdapter extends BaseAdapter {

    //Explicit
    private Context objContext;   //Context ไว้ต่อท่อ
    private String[] sourceStrings, foodStrings, priceStrings;

    public MyAdapter(Context objContext, String[] sourceStrings, String[] foodStrings, String[] priceStrings) {
        this.objContext = objContext;
        this.sourceStrings = sourceStrings;
        this.foodStrings = foodStrings;
        this.priceStrings = priceStrings;
    }//constructor

    @Override
    public int getCount() {
        return foodStrings.length;  //นับจำนวนสินค้ามีเท่าไร
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        LayoutInflater objLayoutInflater = (LayoutInflater) objContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);    // ALT + Enter = Cast to
        View objView1 = objLayoutInflater.inflate(R.layout.food_listview, viewGroup, false); //

        //For Show Food (show string ชื่ออาหาร)
        TextView foodTextView = (TextView) objView1.findViewById(R.id.txtShowFood);
        foodTextView.setText(foodStrings[i]);

        //For Show Price
        TextView priceTextView = (TextView) objView1.findViewById(R.id.txtShowPrice);
        priceTextView.setText(priceStrings[i]);

        //For Icon
        ImageView iconImageView = (ImageView) objView1.findViewById(R.id.imvIcon);

        Picasso.with(objContext).load(sourceStrings[i]).resize(120, 120).into(iconImageView);




        return objView1;
    }
}//main class
