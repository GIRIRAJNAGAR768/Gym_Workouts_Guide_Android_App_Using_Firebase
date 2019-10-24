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


public class ActivityDiet extends AppCompatActivity implements RewardedVideoAdListener {


    AdView adView;
    ListView listView;
    String[] name = {
            "PRE WORKOUT\nDIET PLAN",
            "POST WORKOUT\nDIET PLAN",
            "MUSCLE\nBUILDING",
            "SUPPLIMENTS\nPOWDER"};

    InterstitialAd interstitialAd;
    AdRequest adRequest;
    RewardedVideoAd rewardedVideoAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diet);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

       adView=findViewById(R.id.adView);
       adRequest=new AdRequest.Builder().build();
       adView.loadAd(adRequest);

        interstitialAd = new InterstitialAd(this);
        interstitialAd.setAdUnitId(getResources().getString(R.string.inter));

        rewardedVideoAd = MobileAds.getRewardedVideoAdInstance(this);
        rewardedVideoAd.setRewardedVideoAdListener(this);


        listView = findViewById(R.id.list);
        listView.setAdapter(new ActivityDiet.MyAdapter(ActivityDiet.this, name));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View v, int pos, long arg3) {

                if(pos==1)
                {
                    interstitialAd.loadAd(adRequest);
                    ShowInter();
                }

                if(pos==3)
                {
                    loadRewardedVideo();
                }

                switch (pos) {
                    case 0:
                        startActivity(new Intent(ActivityDiet.this, DietLastActivity.class).putExtra("key",1));
                        break;
                    case 1:
                        startActivity(new Intent(ActivityDiet.this, DietLastActivity.class).putExtra("key",2));
                        break;
                    case 2:
                        startActivity(new Intent(ActivityDiet.this, DietLastActivity.class).putExtra("key",3));
                        break;
                    default:
                        startActivity(new Intent(ActivityDiet.this, DietLastActivity.class).putExtra("key",4));

                }

            }
        });
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

        private final Activity context;
        private final String[] web;

        private MyAdapter(Activity context,
                         String[] web) {
            super( context, R.layout.fragment_diet, web );
            this.context = context;
            this.web = web;
        }

        @SuppressLint({"ViewHolder", "InflateParams"})
        @Override
        public View getView(int position, View view, ViewGroup parent) {
            LayoutInflater inflater = context.getLayoutInflater();
            View rowView = inflater.inflate( R.layout.fragment_diet, null, true );
            TextView txtTitle = (TextView) rowView.findViewById( R.id.txt );
            txtTitle.setText( web[position] );
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