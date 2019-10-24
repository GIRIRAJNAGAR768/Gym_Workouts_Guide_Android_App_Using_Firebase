package gym.workouts.guide;

import android.app.ProgressDialog;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Daily_Quotes extends AppCompatActivity {
    RelativeLayout rr;
    private ImageView imageView;
    Date date = new Date();
    String sdate = date.toString();
    String[] time = sdate.split( " " );
    DatabaseReference databaseReference;
    List<String> image = new ArrayList<>();

    ProgressDialog pd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_daily_quotes );
        setRequestedOrientation( ActivityInfo.SCREEN_ORIENTATION_PORTRAIT );
        pd = new ProgressDialog(this);
        pd.setMessage("Loading...");
        pd.show();

        imageView = findViewById( R.id.image );
        rr=findViewById(R.id.rr);


       AdView adView=findViewById(R.id.adView);
        AdRequest adRequest=new AdRequest.Builder().build();
        adView.loadAd(adRequest);


        databaseReference = FirebaseDatabase.getInstance().getReference().child( "GymQuotes" );

        databaseReference.addValueEventListener( new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                rr.setBackgroundColor( Color.parseColor( "#203c60" ) );
                image.clear();
                for (DataSnapshot data : dataSnapshot.getChildren()) {
                    image.add( data.child( "Img" ).getValue().toString() );
                }


                setImage();

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

                Toast.makeText( Daily_Quotes.this, databaseError.getMessage(), Toast.LENGTH_SHORT ).show();
            }
        } );


    }

    public void setImage() {

        if(!image.isEmpty()) {
            pd.dismiss();
            switch (time[2]) {
                case "1":
                case "11":
                case "21":
                    Glide.with(this).load(image.get(0)).thumbnail(Glide.with(this).load(R.drawable.loading)).into(imageView);
                    break;
                case "2":
                case "12":
                case "22":
                    Glide.with(this).load(image.get(1)).thumbnail(Glide.with(this).load(R.drawable.loading)).into(imageView);

                    break;
                case "3":
                case "13":
                case "23":
                    Glide.with(this).load(image.get(2)).thumbnail(Glide.with(this).load(R.drawable.loading)).into(imageView);

                    break;
                case "4":
                case "14":
                case "24":

                    Glide.with(this).load(image.get(3)).thumbnail(Glide.with(this).load(R.drawable.loading)).into(imageView);

                    break;
                case "5":
                case "15":
                case "25":
                    Glide.with(this).load(image.get(4)).thumbnail(Glide.with(this).load(R.drawable.loading)).into(imageView);

                    break;
                case "6":
                case "16":
                case "26":
                    Glide.with(this).load(image.get(5)).thumbnail(Glide.with(this).load(R.drawable.loading)).into(imageView);

                    break;
                case "7":
                case "17":
                case "27":
                    Glide.with(this).load(image.get(6)).thumbnail(Glide.with(this).load(R.drawable.loading)).into(imageView);

                    break;
                case "8":
                case "18":
                case "28":
                    Glide.with(this).load(image.get(7)).thumbnail(Glide.with(this).load(R.drawable.loading)).into(imageView);

                    break;
                case "9":
                case "19":
                case "29":
                    Glide.with(this).load(image.get(8)).thumbnail(Glide.with(this).load(R.drawable.loading)).into(imageView);

                    break;
                case "10":
                case "20":
                case "30":
                    Glide.with(this).load(image.get(9)).thumbnail(Glide.with(this).load(R.drawable.loading)).into(imageView);

                    break;
                default:
                    Glide.with(this).load(image.get(5)).thumbnail(Glide.with(this).load(R.drawable.loading)).into(imageView);

            }
        }
        else
        {
            pd.setMessage("Error Loading data...");
            pd.show();
        }
    }

}