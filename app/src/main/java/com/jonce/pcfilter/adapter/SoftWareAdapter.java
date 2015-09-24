package com.jonce.pcfilter.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.jonce.pcfilter.R;
import com.jonce.pcfilter.modal.SoftWare;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SoftWareAdapter extends BaseAdapter
{

    public static List<SoftWare> data = new ArrayList<SoftWare>();
    int[] img = {R.drawable.visualstudio, R.drawable.androidstudio, R.drawable.google,
            R.drawable.notepad, R.drawable.ie, R.drawable.eclipse};
    public static List<Boolean> isSelected;

    private Context context;
    LayoutInflater inflater;

    public SoftWareAdapter(Context context)
    {
        super();
        this.context = context;
        this.inflater = LayoutInflater.from(context);
        data = new ArrayList<SoftWare>();
        init();
    }

    private void init()
    {
        SoftWare softWare = new SoftWare(img[0], "Visual Studio", 5, 3650, 4);
        data.add(softWare);

        softWare = new SoftWare(img[1], "Android Studio", 4, 3850, 4);
        data.add(softWare);

        softWare = new SoftWare(img[2], "Google Chrome", 3, 3900, 2);
        data.add(softWare);

        softWare = new SoftWare(img[3], "Notepad++", 2, 3400, 2);
        data.add(softWare);

        softWare = new SoftWare(img[4], "Internet Explorer", 1, 3400, 1);
        data.add(softWare);

        softWare = new SoftWare(img[5], "Eclipse", 4, 3650, 2);
        data.add(softWare);

        isSelected = new ArrayList<>();

        for (int i = 0; i < data.size(); i++)
        {
            isSelected.add(i, false);
        }
    }

    public int getCount()
    {
        return data.size();
    }

    @Override
    public Object getItem(int position)
    {
        return data.get(position);
    }

    @Override
    public long getItemId(int position)
    {
        return position;
    }

    @Override
    public View getView(final int position, View contentView, ViewGroup parent)
    {
        ViewHolder viewHolder = null;
        View view;
        if (contentView == null)
        {
            viewHolder = new ViewHolder();
            view = inflater.inflate(R.layout.software_item, null);
            viewHolder.softImg =  (ImageView) view.findViewById(R.id.softwareImages);
            viewHolder.softName  = (TextView) view.findViewById(R.id.softName);
            viewHolder.softInfo  = (TextView) view.findViewById(R.id.softInfo);
            viewHolder.softSelect = (CheckBox) view.findViewById(R.id.softSelect);

            viewHolder.softSelect.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    CheckBox cb = (CheckBox)v;
                    isSelected.set(position, cb.isChecked());
                }
            });
            view.setTag(viewHolder);
        }
        else
        {
            view = contentView;
            viewHolder = (ViewHolder) view.getTag();
        }

        String softInfos = "CPU: " + data.get(position).getsFCPU();
        softInfos += " GPU: " + data.get(position).getsFGPU();
        softInfos += " Storage: " + data.get(position).getsFStorage();
        viewHolder.softName.setText(data.get(position).getSfName());
        viewHolder.softImg.setBackgroundResource(data.get(position).getImg());
        viewHolder.softInfo.setText(softInfos);
        viewHolder.softSelect.setChecked(isSelected.get(position));

        return view;
    }

    public final class ViewHolder
    {
        public ImageView softImg;
        public TextView softName;
        public TextView softInfo;
        public CheckBox softSelect;
    }
}
