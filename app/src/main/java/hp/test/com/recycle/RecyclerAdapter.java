package hp.test.com.recycle;

import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by latha on 09-09-2016.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private String[] titles ={"Chapter One", "Chapter two", "Chapter three", "Chapter four", "Chapter five", "Chapter six", "Chapter seven", "Chapter eight"};

    private String[] details={"Item one details", "Item two details", "Item three details", "Item four details", "Item five details","Item six details", "Item seven details", "Item eight details"};

    private int[] images = {R.drawable.Rose, R.drawable.Rose1,
                            R.drawable.Rose2, R.drawable.Rose3,
                            R.drawable.Rose4, R.drawable.Rose5,
                            R.drawable.Rose6, R.drawable.Rose7};


    class ViewHolder extends RecyclerView.ViewHolder{

        public int currentItem;
        public ImageView itemImage;
        public TextView itemTitle;
        public TextView itemDetail;

        public ViewHolder(View itemView){

            super(itemView);

            itemImage=(ImageView)itemView.findViewById(R.id.item_image);
            itemTitle=(TextView)itemView.findViewById(R.id.item_title);
            itemDetail=(TextView)itemView.findViewById(R.id.item_detail);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position =getAdapterPosition();

                    Snackbar.make(view, "Click detected on item" +position, Snackbar.LENGTH_SHORT).setAction("Action", null).show();

                }
            });
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {

        View view= LayoutInflator.from(viewGroup.getContext()).inflate(R.layout.cardlayout,viewGroup,false);
        RecyclerView.ViewHolder viewHolder=new ViewHolder(view);
        return (ViewHolder) viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {

        viewHolder.itemTitle.setText(titles[i]);
        viewHolder.itemDetail.setText(details[i]);
        viewHolder.itemImage.setImageResource(images[i]);


    }

    @Override
    public int getItemCount() {
        return titles.length;
    }
}
