package com.example.liuyueyue.test7;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import static android.R.attr.max;
import static com.example.liuyueyue.test7.R.layout.second;

/**
 * Created by liuyueyue on 2017/7/25.
 */

public class Second extends Activity implements View.OnClickListener {
    private ProgressBar progress;
    private Button add;
    private Button reduce;
    private Button reset;
    private TextView text;
    protected ProgressDialog prodialog;
    private Button show;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //启用窗口特征，启用带进度条和不带进度条的进度条
        requestWindowFeature(Window.FEATURE_PROGRESS);
        requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
        setContentView(second);
        //显示两种进度条
        setProgressBarVisibility(true);
        setProgressBarIndeterminateVisibility(false);
        //Max=10000
        setProgress(9999);
      init();
    }
    //初始化控件
    private void init() {
        progress = (ProgressBar) findViewById(R.id.horiz);
        add = (Button) findViewById(R.id.add);
        reduce = (Button) findViewById(R.id.reduce);
        reset = (Button) findViewById(R.id.reset);
        text = (TextView) findViewById(R.id.text);
        show = (Button) findViewById(R.id.show);
        //getProgress()获取第一进度条
       int first =  progress.getProgress();
        //getProgress()获取第二进度条
        int second = progress.getSecondaryProgress();
        //getProgress()获取最大进度条
        int max = progress.getMax();
        text.setText("第一进度百分比："+(int)(first/(float)max*100)+"% 第二进度百分比："+(int)(second/(float)max*100)+"%");
        add.setOnClickListener(this);
        reduce.setOnClickListener(this);
        reset.setOnClickListener(this);
        show.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.add:{
                //增加第一进度和第二进度十个刻度
                progress.incrementProgressBy(10);
                progress.incrementSecondaryProgressBy(10);
                break;
            }
            case R.id.reduce:{
                //减少第一进度和第二进度十个刻度
                progress.incrementProgressBy(-10);
                progress.incrementSecondaryProgressBy(-10);
                break;
            }
            case R.id.reset:{
                //重置进度条
                progress.setProgress(50);
                progress.setSecondaryProgress(80);
                break;
            }
            case R.id.show:{
                //新建progressDialog对象
                prodialog = new ProgressDialog(Second.this);
                //设置显示风格
                prodialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                //设置对话框标题
                prodialog.setTitle("么么哒");
                //设置对话框内容
                prodialog.setMessage("你对我的爱有多少？");
                //设置图标
                prodialog.setIcon(R.mipmap.ic_launcher);

                 /*设定关于progressBar*的一些属性
                 * */
                 //设定最大进度
                 prodialog.setMax(100);
                //设定初始化进度已经增长进度
                prodialog.incrementProgressBy(80);
                //进度条明确显示的进度
                prodialog.setIndeterminate(false);
                /*设定一个确定按钮*/
                prodialog.setButton(DialogInterface.BUTTON_POSITIVE, "确定吗？", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(Second.this,"谢谢你那么漂亮还喜欢我~_~",Toast.LENGTH_SHORT).show();
                    }
                });
                //是否可以通过返回按钮退出对话框
                prodialog.setCancelable(true);
                //显示progressDialog
                prodialog.show();
                break;
            }
        }
        text.setText("第一进度百分比："+(int)(progress.getProgress()/(float)progress.getMax()*100)+"% 第二进度百分比："+(int)(progress.getSecondaryProgress()/(float)progress.getMax()*100)+"%");
    }
}
