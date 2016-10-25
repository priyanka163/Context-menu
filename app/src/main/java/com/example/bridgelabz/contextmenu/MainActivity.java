package com.example.bridgelabz.contextmenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
 ListView listView;
    String contacts[]={"khusi","vinu","soumya","rakshu","shubham","chinnu","fgbg","rgthy","fgghb","dfgh",
            "dfvgb","fbghnh","dvfg","hghby" ,"priya","putty"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView= (ListView) findViewById(R.id.Listview);

        ArrayAdapter<String> adapter= new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,contacts);
        listView.setAdapter(adapter);


        // Register the ListView  for Context menu
        registerForContextMenu(listView);





    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("select the action");
        menu.add(0,v.getId(),0,"sms");    //groupid,item id,order,tittle
        menu.add(0,v.getId(),0,"call");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        if (item.getTitle()=="call"){

            Toast.makeText(getApplicationContext(),"calling code", Toast.LENGTH_LONG).show();
        }

        else  if (item.getTitle()=="sms"){

            Toast.makeText(getApplicationContext(),"Sending sms code",Toast.LENGTH_LONG).show();
        }
        else {
            return false;

        }
        return true;
    }
}
