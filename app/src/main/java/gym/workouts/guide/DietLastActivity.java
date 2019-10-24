package gym.workouts.guide;

import android.app.ProgressDialog;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

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


public class DietLastActivity extends AppCompatActivity {


    DatabaseReference databaseReference;
    List<String> heading = new ArrayList<>();
    List<String> content = new ArrayList<>();
    List<String>  image = new ArrayList<>();
    ListView listView;
    TextView title;
    int key;
     AdView adView;
     ProgressDialog pd;

     String dbChild;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_diet_last );
        setRequestedOrientation( ActivityInfo.SCREEN_ORIENTATION_PORTRAIT );
        databaseReference = FirebaseDatabase.getInstance().getReference( "Diet" );
        title=findViewById( R.id.heading);
        Bundle b = getIntent().getExtras();
        key = (int) b.get( "key" );

       adView=findViewById(R.id.adView);
        AdRequest adRequest=new AdRequest.Builder().build();
        adView.loadAd(adRequest);


        pd = new ProgressDialog(this);
        pd.setMessage("Loading...");
        pd.show();


        if(key==1)
        {
            title.setText("PRE WORKOUT DIET");
            dbChild = "Prework";
        }
        else if(key==2)
        {
            title.setText( "POST WORKOUT DIET" );
            dbChild = "Postwork";
        }
        else if(key==3)
        {
            title.setText("MUSCLE BUILDING");
            dbChild = "Muscle";
        }
        else
        {
            title.setText("SUPPLIMENTS POWDER");
            dbChild = "Suppli";
        }

        listView = findViewById( R.id.list );

        databaseReference.child(dbChild).addValueEventListener( new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    content.clear();
                    heading.clear();
                    image.clear();

                    for (DataSnapshot data : dataSnapshot.getChildren()) {
                        content.add( data.child( "Cont" ).getValue().toString() );
                        heading.add( data.child( "Head" ).getValue().toString() );
                        image.add( data.child( "Img" ).getValue().toString());
                    }
                    showData();
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                    Toast.makeText( DietLastActivity.this, "Error Loading data.", Toast.LENGTH_SHORT ).show();
                }
            } );

    }

    public void showData()
    {
        if(!heading.isEmpty())
        {
            pd.dismiss();

            listView.setAdapter( new MyAdapter( DietLastActivity.this, heading, image, content ) );
        }
        else
        {
            pd.setMessage("Error Loading data...");
            pd.show();
        }
    }


}
