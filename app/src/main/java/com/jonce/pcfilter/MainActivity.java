package com.jonce.pcfilter;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.jonce.pcfilter.adapter.SoftWareAdapter;
import com.jonce.pcfilter.modal.Computer;
import com.jonce.pcfilter.modal.SoftWare;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
{

    private Button searchBtn;
    private ListView softwareLv;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        searchBtn = (Button) findViewById(R.id.searchBtn);
        softwareLv = (ListView) findViewById(R.id.softwareLv);

        SoftWareAdapter softWareAdapter = new SoftWareAdapter(this);
        softwareLv.setAdapter((ListAdapter) softWareAdapter);

        searchBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                String selected = "";
                for (int i = 0; i < SoftWareAdapter.isSelected.size(); i++)
                {
                    if(SoftWareAdapter.isSelected.get(i))
                    {
                        selected += i + ",";
                    }
                }
                if (selected.equals(""))
                {
                    Toast.makeText(MainActivity.this, "Please select at least a software!", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    intent.putExtra("selected", selected);
                    startActivity(intent);
                }
            }
        });

    }

}
