package com.example.admin.mymvp.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.admin.mymvp.R;
import com.example.admin.mymvp.presenter.ILoginPresenter;
import com.example.admin.mymvp.presenter.LoginPresenterCompl;

public class LoginActivity extends AppCompatActivity implements ILoginView{

    private Button mLogin ;
    private Button mClear ;
    private EditText mName ;
    private EditText mPassWord ;

    ILoginPresenter loginPresenter ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mLogin = (Button) findViewById(R.id.btn_login);
        mClear = (Button) findViewById(R.id.btn_clear);
        mName = (EditText) findViewById(R.id.et_name);
        mPassWord = (EditText) findViewById(R.id.et_password);

        loginPresenter = new LoginPresenterCompl(this);

        mLogin.setOnClickListener(onclicklistener);
        mClear.setOnClickListener(onclicklistener);
    }

    View.OnClickListener onclicklistener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int id = v.getId() ;
            String name = mName.getText().toString() ;
            String password = mPassWord.getText().toString() ;

            switch (id){
                case R.id.btn_login :
                    loginPresenter.doLogin(name,password);
                    break ;
                case R.id.btn_clear :
                    loginPresenter.clear();
                    break;
            }
        }
    };

    @Override
    public void onClearText() {
        mName.setText("");
        mPassWord.setText("");
        Toast.makeText(this,"clear",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLoginResult(Boolean result, int code) {
        mLogin.setEnabled(true);
        mClear.setEnabled(true);

        if(result){
            Toast.makeText(this,"登陆成功: "+code,Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this,"登陆失败："+code,Toast.LENGTH_SHORT).show();
        }
    }
}