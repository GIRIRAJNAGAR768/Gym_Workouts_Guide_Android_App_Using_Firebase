package gym.workouts.guide;

import android.app.ProgressDialog;
import android.content.pm.ActivityInfo;
import android.os.Bundle;

import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class GymMachinesActivity extends AppCompatActivity {
    DatabaseReference databaseReference;
    List<String> heading = new ArrayList<>();
    List<String> content = new ArrayList<>();
    List<String>  image = new ArrayList<>();
    ListView listView;
    TextView title;
   AdView adView;
   ProgressDialog pd;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView(R.layout.activity_diet_last);
        setRequestedOrientation( ActivityInfo.SCREEN_ORIENTATION_PORTRAIT );
        databaseReference = FirebaseDatabase.getInstance().getReference( "GymMachines" );
        title=findViewById(R.id.heading);
        title.setText("GYM MACHINES");

        pd = new ProgressDialog(this);
        pd.setMessage("Loading...");
        pd.show();



        adView=findViewById(R.id.adView);
        AdRequest adRequest=new AdRequest.Builder().build();
        adView.loadAd(adRequest);


        listView = findViewById( R.id.list );
        databaseReference.addValueEventListener( new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                content.clear();
                heading.clear();
                image.clear();


                for (DataSnapshot data : dataSnapshot.getChildren()) {
                    content.add( data.child( "Cont" ).getValue().toString() );
                    heading.add( data.child( "Head" ).getValue().toString() );
                    image.add( data.child( "Img" ).getValue().toString() );
                }

                showData();

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText( GymMachinesActivity.this, databaseError.getMessage(), Toast.LENGTH_SHORT ).show();

            }
        } );

    }

    public void showData()
    {
        if(!heading.isEmpty())
        {
            pd.dismiss();
            listView.setAdapter( new MyAdapter( GymMachinesActivity.this, heading, image, content ) );
        }
        else
        {
            pd.setMessage("Error Loading data...");
            pd.show();
        }
    }



}
