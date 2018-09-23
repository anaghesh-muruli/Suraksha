package anaghesh.suraksha;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<ContactViewHolder>{


   private List<anaghesh.suraksha.Datas> st;
   private Context mcontext;
   public static String []n = new String[3];
   public static String con[] = new String[3];
    public MyAdapter(List<anaghesh.suraksha.Datas> st, Context mcontext)
   {
       this.st=st;
       this.mcontext=mcontext;
   }
   @Override
    public ContactViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
   {
       View view = LayoutInflater.from(mcontext).inflate(R.layout.cont_item,null);
       ContactViewHolder cvh = new ContactViewHolder(view);
       return cvh;


   }

   @Override
    public void onBindViewHolder(final ContactViewHolder holder, int position)
   {
       anaghesh.suraksha.Datas data = st.get(position);
       holder.cb.setChecked(data.getSelected());
       holder.str.setText(data.getDt());
       holder.cb.setTag(position);

       holder.cb.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               Integer pos = (Integer)holder.cb.getTag();
               Toast.makeText(mcontext, st.get(pos).getDt() + " Selected ", Toast.LENGTH_SHORT).show();
               for(int i=0; i<3;i++)
               {

                   if (st.get(pos).getSelected())
                   {
                       st.get(pos).setSelected(false);

                   }
                   else {
                   st.get(pos).setSelected(true);
                   n[i]=st.get(pos).getDt();
                   con[i]=st.get(pos).getPhno();

                   }
               }



           }
       });

   }
   @Override
    public int getItemCount()
   {
       return st.size();
   }

   public void filteredList(ArrayList<anaghesh.suraksha.Datas> filteredList)
   {
       st = filteredList;
       notifyDataSetChanged();
   }
}

class ContactViewHolder extends RecyclerView.ViewHolder{

    TextView str;
    CheckBox cb;

    public ContactViewHolder(View itemView)
    {
        super(itemView);
        str= itemView.findViewById(R.id.contacttextview);
        cb = itemView.findViewById(R.id.checked);
    }
}