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
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExerListActivity extends AppCompatActivity implements RewardedVideoAdListener {

    TextView heading;
    public List<String> fileNameList = new ArrayList<>(  );
    List<Integer> image = new ArrayList<>( );
    AdView adView;
    ListView listView;
    Integer[] chest={R.drawable.chst1, R.drawable.chst2, R.drawable.chst3, R.drawable.chst4, R.drawable.chst5, R.drawable.chst6, R.drawable.chst7, R.drawable.chst8, R.drawable.chst9, R.drawable.chst10, R.drawable.chst11, R.drawable.chst12, R.drawable.chst13,};
    Integer[] biceps={R.drawable.bic1, R.drawable.bic2, R.drawable.bic3, R.drawable.bic4, R.drawable.bic5, R.drawable.bic6, R.drawable.bic7, R.drawable.bic8, R.drawable.bic9};
    Integer[] back={R.drawable.bck1, R.drawable.bck2, R.drawable.bck3, R.drawable.bck4, R.drawable.bck5, R.drawable.bck6, R.drawable.bck7, R.drawable.bck8, R.drawable.bck9};
    Integer[] triceps={R.drawable.tric1, R.drawable.tric2single, R.drawable.tric3overhead, R.drawable.tric4, R.drawable.tric5, R.drawable.tric6, R.drawable.tric8, R.drawable.tric9, R.drawable.tric10};
    Integer[] shoulders={R.drawable.sho1, R.drawable.sho2, R.drawable.sho3, R.drawable.sho4, R.drawable.sho5, R.drawable.sho6, R.drawable.sho7, R.drawable.sho8, R.drawable.sho10, R.drawable.sho11, R.drawable.sho12, R.drawable.sho13};
    Integer[] legs={R.drawable.lg1, R.drawable.lg2, R.drawable.lg3, R.drawable.lg4, R.drawable.lg5, R.drawable.lg6, R.drawable.lg7, R.drawable.lg8, R.drawable.lg10, R.drawable.lg11, R.drawable.lg12};
    int LIST;
    InterstitialAd interstitialAd;
    AdRequest adRequest;
    RewardedVideoAd rewardedVideoAd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_exer_list );
        setRequestedOrientation( ActivityInfo.SCREEN_ORIENTATION_PORTRAIT );
        listView = findViewById( R.id.list );

        heading=findViewById(R.id.heading);

        adView=findViewById(R.id.adView);
        adRequest=new AdRequest.Builder().build();
        adView.loadAd(adRequest);


        interstitialAd=new InterstitialAd(this);
        interstitialAd.setAdUnitId(getResources().getString(R.string.inter));


        rewardedVideoAd = MobileAds.getRewardedVideoAdInstance(this);
        rewardedVideoAd.setRewardedVideoAdListener(this);



        Bundle extras= getIntent().getExtras();
        LIST=(int)extras.get("LIST");

            switch(LIST)
        {
            case 1:

                fileNameList.addAll( Arrays.asList(getResources().getStringArray(R.array.chest_head )));
                image.addAll(Arrays.asList(chest));
                heading.setText("Chest Workouts");
                break;
            case 2:
                fileNameList.addAll( Arrays.asList(getResources().getStringArray(R.array.biceps_head )));
                image.addAll(Arrays.asList(biceps));
                heading.setText("Biceps Workouts");
                break;
            case 3:
                fileNameList.addAll( Arrays.asList(getResources().getStringArray(R.array.back_head )));
                image.addAll(Arrays.asList(back));
                heading.setText("Back Workouts");
                break;
            case 4:
                fileNameList.addAll( Arrays.asList(getResources().getStringArray(R.array.triceps_head )));
                image.addAll(Arrays.asList(triceps));
                heading.setText("Tricep Workouts");
                break;
            case 5:
                fileNameList.addAll( Arrays.asList(getResources().getStringArray(R.array.shoulders_head )));
                image.addAll(Arrays.asList(shoulders));
                heading.setText("Shoulder Workouts");
                break;
                default:
                    fileNameList.addAll( Arrays.asList(getResources().getStringArray(R.array.legs_head )));
                    image.addAll(Arrays.asList(legs));
                heading.setText("Leg Workouts");
                break;
            }


        listView.setAdapter( new MyAdapter(ExerListActivity.this,fileNameList,image) );
        listView.setOnItemClickListener( new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View v, int pos, long arg3) {

                pos=pos+1;

                 if(pos==3 || pos==9)
                 {
                     interstitialAd.loadAd(adRequest);
                     ShowInter();
                 }
                 if(pos==6 || pos==12)
                 {
                     loadRewardedVideo();
                 }


                Intent last=new Intent(ExerListActivity.this,ExerLastActivity.class);
                last.putExtra("LIST",LIST);
                last.putExtra("LAST",pos);
                finish();
                startActivity(last);

            }
        } );



    }


    public void loadRewardedVideo()
    {
        rewardedVideoAd.loadAd(getResources().getString(R.string.video),new AdRequest.Builder().build());
    }

    @Override
    public void onRewardedVideoAdLoaded() {
        rewardedVideoAd.show();
    }

    @Override
    public void onRewardedVideoAdOpened() {

    }

    @Override
    public void onRewardedVideoStarted() {

    }

    @Override
    public void onRewardedVideoAdClosed() {

    }

    @Override
    public void onRewarded(RewardItem rewardItem) {

    }

    @Override
    public void onRewardedVideoAdLeftApplication() {

    }

    @Override
    public void onRewardedVideoAdFailedToLoad(int i) {

    }

    @Override
    public void onRewardedVideoCompleted() {

    }


    public class MyAdapter extends ArrayAdapter<String> {
       Activity context;
       public List<String> name=new ArrayList<>();
       public List<Integer> images=new ArrayList<>();

       public MyAdapter(Activity context,List<String> name,List<Integer> images){
           super(context, R.layout.fragment_exer_list,name);

           this.context=context;
           this.name = name;
           this.images = images;



       }

        @SuppressLint({"ViewHolder", "InflateParams"})
        @Override
        public View getView(int position, View view, ViewGroup parent) {
            LayoutInflater inflater = context.getLayoutInflater();
            View rowView = inflater.inflate( R.layout.fragment_exer_list, null, true );
            TextView txtTitle = (TextView) rowView.findViewById( R.id.textlist );
            ImageView imageView = rowView.findViewById( R.id.imagelist );
            txtTitle.setText(name.get(position));
            imageView.setImageResource( image.get( position ) );
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
