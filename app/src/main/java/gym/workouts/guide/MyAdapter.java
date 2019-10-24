package gym.workouts.guide;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class MyAdapter extends ArrayAdapter<String> {

    private final Activity context;
    private List<String> content;
    private  List<String> image;
    private  List<String> heading;

     MyAdapter(Activity context, List<String> heading, List<String> imageId,List<String> content) {
        super(context, R.layout.fragment_diet_last,heading);

        this.context = context;
        this.heading = heading;
        this.image = imageId;
        this.content = content;


    }

    @SuppressLint({"ViewHolder", "InflateParams"})
    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.fragment_diet_last, null, true);
        TextView headtxt = rowView.findViewById(R.id.headtxt);
        TextView conttxt = rowView.findViewById(R.id.conttxt);
        ImageView imageView = rowView.findViewById(R.id.imagetxt);
        headtxt.setText(heading.get(position));
        conttxt.setText(content.get(position));
        Glide.with(context).load(image.get(position)).thumbnail( Glide.with(context).load(R.drawable.loading)).into(imageView);
        return rowView;
    }

}
