package gym.workouts.guide;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.MobileAds;
import com.google.firebase.FirebaseApp;


public class HomeActivity extends AppCompatActivity {

    GridView Grid;
    String[] name = {
            "WORKOUT\nMACHINES",
            "DAILY\nWORKOUTS",
            "DAILY DIET\nPLANNING",
            "DAILY GYM\nQUOTE"};

    Integer[] image={
            R.drawable.gm7,
            R.drawable.les,
            R.drawable.diet1,
            R.drawable.logoround2
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home );
      // MobileAds.initialize(this, "ca-app-pub-9573752427598111~5780299359");
        FirebaseApp.initializeApp(this);

       MobileAds.initialize(this,"ca-app-pub-3303054497534652~5723229699");



      /*  if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O)
        {
            NotificationChannel channel = new NotificationChannel("MyNotifications","MyNotifications", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }


        FirebaseMessaging.getInstance().subscribeToTopic("general")
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        String msg = "Successful";
                        if (!task.isSuccessful()) {
                            msg = "Failed";
                        }
                        //Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
                    }
                });*/


        Grid = findViewById(R.id.dietgrid);
        Grid.setAdapter(new HomeActivity.MyAdapter(HomeActivity.this, name,image));

        Grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View v, int pos, long arg3) {


                if(pos==0){
                        startActivity( new Intent(HomeActivity.this,GymMachinesActivity.class));}
                    else if(pos==1) {
                    startActivity( new Intent( HomeActivity.this, Grid_Activity.class ) );}
                    else if(pos==2)
                        startActivity( new Intent(HomeActivity.this,ActivityDiet.class ));
                    else{
                        startActivity( new Intent(HomeActivity.this,Daily_Quotes.class ));

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
            txtTitle.setTextSize(18);

            imageView.setImageResource(imageId[position]);
            return rowView;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.items, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        switch(item.getItemId()){

            case R.id.exit:

                new AlertDialog.Builder(this)
                        .setMessage("Are you sure you want to exit?")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                HomeActivity.this.finish();

                            }
                        })
                        .setNegativeButton("No", null)
                        .show();
                break;
            case R.id.update:
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData( Uri.parse("https://play.google.com/store/apps/details?id=gym.workouts.guide&hl=en"));
                startActivity(intent);
                break;

            case R.id.share:
                Intent share=new Intent( Intent.ACTION_SEND);
                share.putExtra(Intent.EXTRA_TEXT,"Best Guidance app for GYM lover and beginner. click on the below link and download this app.\n" +
                        " https://play.google.com/store/apps/details?id=gym.workouts.guide");
                share.setType("text/plain");
                startActivity( share );
                break;


            case R.id.about:

                new AlertDialog.Builder(this)
                        .setMessage("This app is created by Giriraj Nagar(Giri Softs) ")
                        .setCancelable(false)
                        .setPositiveButton("Contact", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                Intent in=new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto","mailtomr.giri@gmail.com",null));
                                in.putExtra(Intent.EXTRA_SUBJECT,"Supported Mail for Gym Guide App");
                                startActivity(Intent.createChooser(in,"use service"));

                            }
                        })
                        .setNegativeButton("OK", null)
                        .show();



                break;


        }
        return true;

    }


}

