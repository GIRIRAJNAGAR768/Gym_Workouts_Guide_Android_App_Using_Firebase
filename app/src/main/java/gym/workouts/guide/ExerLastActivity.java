package gym.workouts.guide;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;



public class ExerLastActivity extends AppCompatActivity{
   

    TextView headingtxt,contenttxt;
    ImageView image;
    String[] headings,contents;
    int LAST,LIST;

    AdView adView;
    AdRequest adRequest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_exer_last);

        Bundle extras=getIntent().getExtras();
        LAST=(int)extras.get("LAST");
        LIST=(int)extras.get("LIST");

        adView=findViewById(R.id.adView);
        adRequest =new AdRequest.Builder().build();
        adView.loadAd(adRequest);

   

        headingtxt=findViewById(R.id.heading);
        contenttxt=findViewById(R.id.content);
        image=findViewById(R.id.image);

        switch(LIST)
        {
            case 1:
                headings=getResources().getStringArray(R.array.chest_head);
                contents=getResources().getStringArray( R.array.chest_content );
                switch(LAST)
                {

                    case 1:
                       // interstitialAd.loadAd(adRequest);
                        
                        headingtxt.setText(headings[0]);
                        contenttxt.setText(contents[0]);
                        image.setImageResource(R.drawable.chest1);
                        break;
                    case 2:

                        headingtxt.setText(headings[1]);
                        contenttxt.setText(contents[1]);
                        image.setImageResource(R.drawable.chest2);
                        break;
                    case 3:

                        headingtxt.setText(headings[2]);
                        contenttxt.setText(contents[2]);
                        image.setImageResource(R.drawable.chest3);
                        break;
                    case 4:
                        
                        headingtxt.setText(headings[3]);
                        contenttxt.setText(contents[3]);
                        image.setImageResource(R.drawable.chest4);
                        break;
                    case 5:
                        
                        headingtxt.setText(headings[4]);
                        contenttxt.setText(contents[4]);
                        image.setImageResource(R.drawable.chest5);
                        break;
                    case 6:

                        headingtxt.setText(headings[5]);
                        contenttxt.setText(contents[5]);
                        image.setImageResource(R.drawable.chest6);
                        break;
                    case 7:

                        
                        headingtxt.setText(headings[6]);
                        contenttxt.setText(contents[6]);
                        image.setImageResource(R.drawable.chest7);
                        break;
                    case 8:

                        headingtxt.setText(headings[7]);
                        contenttxt.setText(contents[7]);
                        image.setImageResource(R.drawable.chest8);
                        break;
                    case 9:
                        
                        headingtxt.setText(headings[8]);
                        contenttxt.setText(contents[8]);
                        image.setImageResource(R.drawable.chest9);
                        break;
                    case 10:

                        headingtxt.setText(headings[9]);
                        contenttxt.setText(contents[9]);
                        image.setImageResource(R.drawable.chest10);
                        break;
                    case 11:

                        headingtxt.setText(headings[10]);
                        contenttxt.setText(contents[10]);
                        image.setImageResource(R.drawable.chest11);
                        break;
                    case 12:
                        
                        headingtxt.setText(headings[11]);
                        contenttxt.setText(contents[11]);
                        image.setImageResource(R.drawable.chest12);
                        break;
                    default:

                        
                        headingtxt.setText(headings[12]);
                        contenttxt.setText(contents[12]);
                        image.setImageResource(R.drawable.chest13);

                }
                 break;


            case 2://///for biceps
                headings=getResources().getStringArray(R.array.biceps_head);
                contents=getResources().getStringArray( R.array.biceps_content );
                switch(LAST)
                {

                    case 1:

                        headingtxt.setText(headings[0]);
                        contenttxt.setText(contents[0]);
                        image.setImageResource(R.drawable.bi1);
                        break;
                    case 2:

                        
                        headingtxt.setText(headings[1]);
                        contenttxt.setText(contents[1]);
                        image.setImageResource(R.drawable.bi2);
                        break;
                    case 3:

                        headingtxt.setText(headings[2]);
                        contenttxt.setText(contents[2]);
                        image.setImageResource(R.drawable.bi3);
                        break;
                    case 4:

                        headingtxt.setText(headings[3]);
                        contenttxt.setText(contents[3]);
                        image.setImageResource(R.drawable.bi4);
                        break;
                    case 5:

                        
                        headingtxt.setText(headings[4]);
                        contenttxt.setText(contents[4]);
                        image.setImageResource(R.drawable.bi5);
                        break;
                    case 6:
                       
                        headingtxt.setText(headings[5]);
                        contenttxt.setText(contents[5]);
                        image.setImageResource(R.drawable.bi6);
                        break;
                    case 7:

                        headingtxt.setText(headings[6]);
                        contenttxt.setText(contents[6]);
                        image.setImageResource(R.drawable.bi7);
                        break;
                    case 8:
                        
                        headingtxt.setText(headings[7]);
                        contenttxt.setText(contents[7]);
                        image.setImageResource(R.drawable.bi8);
                        break;


                    default:
                       
                        headingtxt.setText(headings[8]);
                        contenttxt.setText(contents[8]);
                        image.setImageResource(R.drawable.bi9);

                }
                break;


            case 3://///for backs
                headings=getResources().getStringArray(R.array.back_head);
                contents=getResources().getStringArray( R.array.back_content );
                switch(LAST)
                {

                    case 1:
                        
                        headingtxt.setText(headings[0]);
                        contenttxt.setText(contents[0]);
                        image.setImageResource(R.drawable.back1);
                        break;
                    case 2:

                        headingtxt.setText(headings[1]);
                        contenttxt.setText(contents[1]);
                        image.setImageResource(R.drawable.back2);
                        break;
                    case 3:

                        headingtxt.setText(headings[2]);
                        contenttxt.setText(contents[2]);
                        image.setImageResource(R.drawable.back3);
                        break;
                    case 4:

                        headingtxt.setText(headings[3]);
                        contenttxt.setText(contents[3]);
                        image.setImageResource(R.drawable.back4);
                        break;
                    case 5:
                        
                        headingtxt.setText(headings[4]);
                        contenttxt.setText(contents[4]);
                        image.setImageResource(R.drawable.back5);
                        break;
                    case 6:

                        headingtxt.setText(headings[5]);
                        contenttxt.setText(contents[5]);
                        image.setImageResource(R.drawable.back6);
                        break;
                    case 7:

                       
                        headingtxt.setText(headings[6]);
                        contenttxt.setText(contents[6]);
                        image.setImageResource(R.drawable.back7);
                        break;
                    case 8:

                        headingtxt.setText(headings[7]);
                        contenttxt.setText(contents[7]);
                        image.setImageResource(R.drawable.back8);
                        break;


                    default:
                       
                        headingtxt.setText(headings[8]);
                        contenttxt.setText(contents[8]);
                        image.setImageResource(R.drawable.back9);

                }
                break;



            case 4://///for triceps
                headings=getResources().getStringArray(R.array.triceps_head);
                contents=getResources().getStringArray( R.array.triceps_content );
                switch(LAST)
                {

                    case 1:
                        
                        headingtxt.setText(headings[0]);
                        contenttxt.setText(contents[0]);
                        image.setImageResource(R.drawable.tri1);
                        break;
                    case 2:
                        headingtxt.setText(headings[1]);
                        contenttxt.setText(contents[1]);
                        image.setImageResource(R.drawable.tri2single);
                        break;
                    case 3:

                        headingtxt.setText(headings[2]);
                        contenttxt.setText(contents[2]);
                        image.setImageResource(R.drawable.tri3overhead);
                        break;
                    case 4:

                        headingtxt.setText(headings[3]);
                        contenttxt.setText(contents[3]);
                        image.setImageResource(R.drawable.tri4);
                        break;
                    case 5:
                        
                        headingtxt.setText(headings[4]);
                        contenttxt.setText(contents[4]);
                        image.setImageResource(R.drawable.tri5);
                        break;
                    case 6:

                        headingtxt.setText(headings[5]);
                        contenttxt.setText(contents[5]);
                        image.setImageResource(R.drawable.tri6);
                        break;
                    case 7:

                        headingtxt.setText(headings[6]);
                        contenttxt.setText(contents[6]);
                        image.setImageResource(R.drawable.tri8);
                        break;
                    case 8:
                        headingtxt.setText(headings[7]);
                        contenttxt.setText(contents[7]);
                        image.setImageResource(R.drawable.tri9);
                        break;


                    default:

                        headingtxt.setText(headings[8]);
                        contenttxt.setText(contents[8]);
                        image.setImageResource(R.drawable.tri10);

                }
                break;


            case 5://for shoulders
                headings=getResources().getStringArray(R.array.shoulders_head);
                contents=getResources().getStringArray( R.array.shoulders_content );
                switch(LAST)
                {

                    case 1:
                        
                        headingtxt.setText(headings[0]);
                        contenttxt.setText(contents[0]);
                        image.setImageResource(R.drawable.sh1);
                        break;
                    case 2:

                        headingtxt.setText(headings[1]);
                        contenttxt.setText(contents[1]);
                        image.setImageResource(R.drawable.sh2);
                        break;
                    case 3:

                        headingtxt.setText(headings[2]);
                        contenttxt.setText(contents[2]);
                        image.setImageResource(R.drawable.sh3);
                        break;
                    case 4:

                        headingtxt.setText(headings[3]);
                        contenttxt.setText(contents[3]);
                        image.setImageResource(R.drawable.sh4);
                        break;
                    case 5:
                        
                        headingtxt.setText(headings[4]);
                        contenttxt.setText(contents[4]);
                        image.setImageResource(R.drawable.sh5);
                        break;
                    case 6:

                        headingtxt.setText(headings[5]);
                        contenttxt.setText(contents[5]);
                        image.setImageResource(R.drawable.sh6);
                        break;
                    case 7:

                        
                        headingtxt.setText(headings[6]);
                        contenttxt.setText(contents[6]);
                        image.setImageResource(R.drawable.sh7);
                        break;
                    case 8:

                        headingtxt.setText(headings[7]);
                        contenttxt.setText(contents[7]);
                        image.setImageResource(R.drawable.sh8);
                        break;
                    case 9:
                        
                        headingtxt.setText(headings[8]);
                        contenttxt.setText(contents[8]);
                        image.setImageResource(R.drawable.sh10);
                        break;
                    case 10:

                        headingtxt.setText(headings[9]);
                        contenttxt.setText(contents[9]);
                        image.setImageResource(R.drawable.sh11);
                        break;
                    case 11:

                        headingtxt.setText(headings[10]);
                        contenttxt.setText(contents[10]);
                        image.setImageResource(R.drawable.sh12);
                        break;
                    default:
                        headingtxt.setText(headings[11]);
                        contenttxt.setText(contents[11]);
                        image.setImageResource(R.drawable.sh13);

                }
                break;



            default://for legs
                headings=getResources().getStringArray(R.array.legs_head);
                contents=getResources().getStringArray( R.array.legs_content);
                switch(LAST)
                {

                    case 1:
                        headingtxt.setText(headings[0]);
                        contenttxt.setText(contents[0]);
                        image.setImageResource(R.drawable.leg1);
                        break;
                    case 2:
                        headingtxt.setText(headings[1]);
                        contenttxt.setText(contents[1]);
                        image.setImageResource(R.drawable.leg2);
                        break;
                    case 3:
                       
                        headingtxt.setText(headings[2]);
                        contenttxt.setText(contents[2]);
                        image.setImageResource(R.drawable.leg3);
                        break;
                    case 4:

                        headingtxt.setText(headings[3]);
                        contenttxt.setText(contents[3]);
                        image.setImageResource(R.drawable.leg4);
                        break;
                    case 5:

                        headingtxt.setText(headings[4]);
                        contenttxt.setText(contents[4]);
                        image.setImageResource(R.drawable.leg5);
                        break;
                    case 6:

                        headingtxt.setText(headings[5]);
                        contenttxt.setText(contents[5]);
                        image.setImageResource(R.drawable.leg6);
                        break;
                    case 7:
                       
                        headingtxt.setText(headings[6]);
                        contenttxt.setText(contents[6]);
                        image.setImageResource(R.drawable.leg7);
                        break;
                    case 8:
                        headingtxt.setText(headings[7]);
                        contenttxt.setText(contents[7]);
                        image.setImageResource(R.drawable.leg8);
                        break;
                    case 9:

                        headingtxt.setText(headings[8]);
                        contenttxt.setText(contents[8]);
                        image.setImageResource(R.drawable.leg10);
                        break;
                    case 10:

                        headingtxt.setText(headings[9]);
                        contenttxt.setText(contents[9]);
                        image.setImageResource(R.drawable.leg11);
                        break;

                    default:
                        headingtxt.setText(headings[10]);
                        contenttxt.setText(contents[10]);
                        image.setImageResource(R.drawable.leg12);


                }
                break;







        }//switch of list of end

    }

    public void onBackPressed()
    {
        Intent in=new Intent(ExerLastActivity.this,ExerListActivity.class);
        in.putExtra("LIST",LIST);
        startActivity(in);
        finish();

    }



}
