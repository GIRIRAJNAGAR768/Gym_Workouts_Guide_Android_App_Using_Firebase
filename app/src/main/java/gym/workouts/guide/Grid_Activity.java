package gym.workouts.guide;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;


public class Grid_Activity extends AppCompatActivity {
    GridView Grid;
    String[] name={
            "Chest",
            "Biceps",
            "Back",
            "Triceps",
            "Shoulders",
            "Legs"
    };

    Integer[] image={
            R.drawable.chest,
            R.drawable.gymtipsgrid,
            R.drawable.back,
            R.drawable.tri2single,
            R.drawable.shoulders,
            R.drawable.les

    };

    InterstitialAd interstitialAd;
    AdRequest adRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);
        setRequestedOrientation( ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);


        interstitialAd = new InterstitialAd(this);
        interstitialAd.setAdUnitId(getResources().getString(R.string.inter));
        adRequest = new AdRequest.Builder().build();


        Grid = findViewById(R.id.grid);
            Grid.setAdapter(new Grid_Activity.MyAdapter(Grid_Activity.this, name,image));


            Grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> arg0, View v, int pos, long arg3) {


                    if(pos==1 || pos==3 || pos==5)
                    {
                        interstitialAd.loadAd(adRequest);
                        ShowInter();
                    }


                        switch (pos) {

                            case 0:

                                startActivity(new Intent(Grid_Activity.this, ExerListActivity.class).putExtra("LIST",1));
                                break;
                            case 1:
                                startActivity(new Intent(Grid_Activity.this, ExerListActivity.class).putExtra("LIST",2));
                                break;
                            case 2:
                                startActivity(new Intent(Grid_Activity.this, ExerListActivity.class).putExtra("LIST",3));
                                break;
                            case 3:
                                startActivity(new Intent(Grid_Activity.this, ExerListActivity.class).putExtra("LIST",4));
                                break;
                            case 4:
                                startActivity(new Intent(Grid_Activity.this, ExerListActivity.class).putExtra("LIST",5));
                                break;
                            default:
                                startActivity(new Intent(Grid_Activity.this, ExerListActivity.class).putExtra("LIST",6));


                        }

                }
            });

    }

    public class MyAdapter extends ArrayAdapter<String> {

        private final Activity context;
        private final String[] web;
        private final Integer[] imageId;
        public MyAdapter(Activity context,
                         String[] web, Integer[] imageId) {
            super(context, R.layout.fragment_home, web);
            this.context = context;
            this.web = web;
            this.imageId = imageId;

        }
        @SuppressLint({ "ViewHolder", "InflateParams" }) @Override
        public View getView(int position, View view, ViewGroup parent) {
            LayoutInflater inflater = context.getLayoutInflater();
            View rowView= inflater.inflate(R.layout.fragment_home, null, true);
            TextView txtTitle =rowView.findViewById(R.id.txt);

            ImageView imageView = rowView.findViewById(R.id.img);
            txtTitle.setText(web[position]);

            imageView.setImageResource(imageId[position]);
            return rowView;
        }
    }

    public void ShowInter()
    {
        interstitialAd.setAdListener(new AdListener(){
            @Override
            public void onAdLoaded() {
                if(interstitialAd.isLoaded())
                    interstitialAd.show();
            }
        });

    }


}

