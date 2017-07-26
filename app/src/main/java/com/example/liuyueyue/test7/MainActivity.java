package com.example.liuyueyue.test7;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static android.media.CamcorderProfile.get;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
private Spinner spinner;
    private TextView textView;
    private List<String> list;
    private ArrayAdapter<String>adapter;
    private Button btn1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = (Button) findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Second.class);
                MainActivity.this.startActivity(intent);
            }
        });

        textView = (TextView) findViewById(R.id.textView);
        spinner = (Spinner) findViewById(R.id.spinner);
        textView.setText("您选择的城市是：北京");
        //1.设置数据源
        list = new ArrayList<String>();
        list.add("北京");
        list.add("广东");
        list.add("上海");
        list.add("湖北");
        list.add("江苏");
        list.add("山东");
        list.add("贵州");
        list.add("浙江");
        list.add("云南");
        list.add("河北");
        list.add("四川");
        list.add("安徽");
        list.add("重庆");
        list.add("湖南");
        list.add("江西");
        list.add("福建");
        list.add("辽宁");
        list.add("山西");
        list.add("广西");
        list.add("河南");
        list.add("宁夏");
        list.add("海南");
        list.add("香港");
        list.add("澳门");
        list.add("台湾");
        list.add("陕西");
        list.add("甘肃");
        list.add("青海");
        list.add("天津");
        list.add("吉林");
        list.add("哈尔滨");
        list.add("西藏");
        list.add("新疆");
        list.add("内蒙古");
        ;
        //2.新建ArrayAdapter定义数据适配器
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,list);
        //3.adapter设置一个下拉菜单样式
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        //4.加载适配器
        spinner.setAdapter(adapter);
        //5.spinner监听器
        spinner.setOnItemSelectedListener(this);

    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String cityName = adapter.getItem(position);
        /*第二种方式实现
        String cityName2 = list.get(position);*/
        textView.setText("您选择的城市是："+cityName);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
