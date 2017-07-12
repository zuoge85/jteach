package org.forkjoin.jteach.open.form;

import org.forkjoin.apikit.core.Message;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;

/**
 * @author zuoge85@gmail.com on 2017/6/6.
 */
@Message
public class LoginForm {

    /**秘钥id*/
    @NotNull
    @Length(max=32)
    private String name;

    /**秘钥值*/
    @NotNull
    @Length(min=5,max=33)
    private String password;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "LoginForm{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
