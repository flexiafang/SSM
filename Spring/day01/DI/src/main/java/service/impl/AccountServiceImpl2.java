package service.impl;

import service.AccountService;

import java.util.Date;

/**
 * 账户的业务层实现类
 *
 * @Author hustffx
 * @Date 2020/6/13 15:02
 */
public class AccountServiceImpl2 implements AccountService {
    private String name;
    private Integer age;
    private Date birthday;

    @Override
    public void saveAccount() {
        System.out.println("service中的saveAccount方法执行了..." + name + ", " + age + ", " + birthday);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
