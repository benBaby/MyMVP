package com.example.admin.mymvp.presenter;

import com.example.admin.mymvp.model.User;
import com.example.admin.mymvp.view.ILoginView;

import javax.inject.Inject;

/**
 * Created by admin on 2017/5/17.
 */

public class LoginPresenterCompl implements ILoginPresenter {

    private ILoginView loginView;
    private User user;

    @Inject
    public LoginPresenterCompl(ILoginView view){
        loginView = view ;
        user = new User("张三","123456");
    }

    @Override
    public void clear() {
        loginView.onClearText();
    }

    @Override
    public void doLogin(String name, String password){
        boolean result = false;
        int code = 0;
        if(name.equals(user.getName()) && password.equals(user.getAge())) {
            result = true;
            code = 1;
        } else {
            result = false;
            code = 0;
        }
        loginView.onLoginResult(result, code);
    }
}
