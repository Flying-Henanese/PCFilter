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
import com.jonce.pcfilter.modal.Computer;
import com.jonce.pcfilter.modal.SoftWare;

import java.util.ArrayList;
import java.util.List;

public class ComputerAdapter extends BaseAdapter
{

    public List<Computer> list = new ArrayList<Computer>();
    private Context context;
    LayoutInflater inflater;

    public ComputerAdapter(Context context, List<Computer> list)
    {
        super();
        this.context = context;
        this.inflater = LayoutInflater.from(context);
        this.list = list;
    }

    public int getCount()
    {
        return list.size();
    }

    @Override
    public Object getItem(int position)
    {
        return list.get(position);
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
            view = inflater.inflate(R.layout.computer_item, null);
            viewHolder.pcImg =  (ImageView) view.findViewById(R.id.pcImg);
            viewHolder.pcName  = (TextView) view.findViewById(R.id.pcName);
            viewHolder.pcInfo  = (TextView) view.findViewById(R.id.pcInfo);
            view.setTag(viewHolder);
        }
        else
        {
            view = contentView;
            viewHolder = (ViewHolder) view.getTag();
        }

        String pcInfos = "CPU: " + list.get(position).getPcCPU();
        pcInfos += " GPU: " + list.get(position).getPcGPU();
        pcInfos += " Storage: " + list.get(position).getPcStorage();
        pcInfos += " Size: " + list.get(position).getPcSize();
        pcInfos += " BatteryLife: " + list.get(position).getPcBatteryLife() + "H";
        
        viewHolder.pcName.setText(list.get(position).getPcName());
        viewHolder.pcImg.setBackgroundResource(list.get(position).getImg());
        viewHolder.pcInfo.setText(pcInfos);

        return view;
    }

    public final class ViewHolder
    {
        public ImageView pcImg;
        public TextView pcName;
        public TextView pcInfo;
    }
}
