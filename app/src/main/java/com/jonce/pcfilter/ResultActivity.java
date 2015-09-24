package com.jonce.pcfilter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.jonce.pcfilter.adapter.ComputerAdapter;
import com.jonce.pcfilter.adapter.SoftWareAdapter;
import com.jonce.pcfilter.modal.Computer;
import com.jonce.pcfilter.modal.SoftWare;

import java.util.ArrayList;
import java.util.List;

public class ResultActivity extends AppCompatActivity
{
    private List<Computer> computerList;
    private Button returnBtn;
    private ListView computerView;
    private TextView computerTv;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result_activity);

        Intent intent = this.getIntent();
        Bundle bundle = intent.getExtras();
        String selected = bundle.getString("selected");

        returnBtn = (Button) findViewById(R.id.returnBtn);
        computerTv = (TextView) findViewById(R.id.computerTv);
        computerView = (ListView) findViewById(R.id.computerLv);
        computerList = new ArrayList<Computer>();
        computerList = getInitComputer();
        computerList = selectedComputer(computerList, selected);

        if(computerList == null || computerList.size() < 1)
        {
            computerTv.setText("There is no computer to meet demand!");
        }
        else
        {
            ComputerAdapter computerAdapter = new ComputerAdapter(this, computerList);
            computerView.setAdapter(computerAdapter);
        }

        returnBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                finish();
            }
        });

    }

    public List<Computer> getInitComputer()
    {
        List<Computer> computerList = new ArrayList<Computer>();
        Computer computer = new Computer(R.drawable.yfourzero, "Lenovo Y40", 3, 4000, 1, 14.0f, 2.5f);
        computerList.add(computer);

        computer = new Computer(R.drawable.macbook, "Mac book", 6, 4500, 4, 12.0f, 3.0f);
        computerList.add(computer);

        computer = new Computer(R.drawable.imac, "iMac", 4, 3700, 2, 21.5f, 20f);
        computerList.add(computer);

        return computerList;
    }

    private List<Computer> selectedComputer(List<Computer> initComputer, String Selected)
    {
        List<Computer> computerList = new ArrayList<Computer>();
        List<SoftWare> isSelectList = getSelectPosition(Selected);

        int maxCpu = this.getMaxCpu(isSelectList);
        int maxGpu = this.getMaxGpu(isSelectList);
        int maxStg = this.getMaxStg(isSelectList);

        for (int i = 0; i < initComputer.size(); i++)
        {
            Computer computer = initComputer.get(i);
            if(computer.getPcCPU() >= maxCpu && computer.getPcGPU() >= maxGpu && computer.getPcStorage() >= maxStg)
            {
                computerList.add(computer);
            }
        }
        return computerList;
    }

    private List<SoftWare> getSelectPosition(String selected)
    {
        List<SoftWare> isSelected = new ArrayList<SoftWare>();
        String[] strSelect = selected.split(",");
        for (int i = 0; i < strSelect.length; i++)
        {
           isSelected.add(SoftWareAdapter.data.get(Integer.parseInt(strSelect[i])));
        }

        return isSelected;
    }

    private int getMaxCpu(List<SoftWare> isSelectList)
    {
        int max = 1;
        for (int i = 0; i < isSelectList.size(); i++)
        {
            if(isSelectList.get(i).getsFCPU() > max)
            {
                max = isSelectList.get(i).getsFCPU();
            }
        }
        return max;
    }

    private int getMaxGpu(List<SoftWare> isSelectList)
    {
        int max = 1;
        for (int i = 0; i < isSelectList.size(); i++)
        {
            if(isSelectList.get(i).getsFGPU() > max)
            {
                max = isSelectList.get(i).getsFGPU();
            }
        }
        return max;
    }

    private int getMaxStg(List<SoftWare> isSelectList)
    {
        int max = 1;
        for (int i = 0; i < isSelectList.size(); i++)
        {
            if(isSelectList.get(i).getsFStorage() > max)
            {
                max = isSelectList.get(i).getsFStorage();
            }
        }
        return max;
    }

}
