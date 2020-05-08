package com.swufe.exercise;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private final String TAG ="Rate" ;
    private float dollarRate = 0.1f;//设置汇率
    private float euroRate = 0.2f;
    private float wonRate = 0.3f;

    EditText rmb;
    TextView show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rmb = findViewById(R.id.rmb);//输入框
        show = findViewById(R.id.showOut);//输出框
    }

    //事件处理（处理按钮事件）在代码中获取控件后对其进行事件处理；
    // 法三：使用配置文件<Button  android:onClick="onClick"/>
    public void onClick(View btn) { //一定是View类型的参数；//满足public void、view，作为按钮事件处理
        Log.i(TAG,"onClick: ");
        //获取当前用户输入+异常处理
        String str = rmb.getText().toString();
        float r = 0;
        if (str.length() > 0) {
            r = Float.parseFloat(str);//可能出现异常。如果str长度>0→有输入→将str float为r
        }else{
            //提示用户输入内容（当用户没有输入时）
            Toast.makeText(this,"请输入金额",Toast.LENGTH_SHORT).show();
            //①当前Activity；②真正想告诉用户的内容；③该消息显示时间长短long/short(差别不大)，①②③构造消息对象
            //真正显示出来，调用.show()
        }
        //计算过程
        //if (btn.getId() == R.id.btn_dollar) {
            //float val = r * (1/6.7f);//需要float，6.7double，强转，在6.7后+f
            //show.setText(String.valueOf(val));//法一：正确setText(String)错误setText(val)val是float,float强转string
        //} else if (btn.getId() == R.id.btn_euro) {
            //float val = r * (1 / 11f);//r*(1/11)运行结果0.0，整数/整数=整数(四舍五入为0)→修改：11f/11.0f
            //show.setText(val + "");//法二：val(float)+""(空字符串)，val+""→String
        //} else {
            //float val = r * 500;
            //show.setText(String.valueOf(val));
        //}
        
        //计算过程简化+val格式化（输出两位小数）
        if (btn.getId() == R.id.btn_dollar) {
            show.setText(String.format("%.2f",r*dollarRate));
        } else if (btn.getId() == R.id.btn_euro) {
            show.setText(String.format("%.2f",r*euroRate));
        } else {
            show.setText(String.format("%.2f",r*wonRate)) ;
        }
        
        //打开新窗口5.2.3
        //public void openOne(View btn){}
        
        //打开一个新的窗口，修改三个币种汇率6.2.1
        //①<Button/>②指定一个打开方法
    }
}