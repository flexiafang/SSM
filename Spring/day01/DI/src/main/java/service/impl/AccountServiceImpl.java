package service.impl;

import service.AccountService;

import java.util.Date;

/**
 * 账户的业务层实现类
 *
 * @Author hustffx
 * @Date 2020/6/13 15:02
 */
public class AccountServiceImpl implements AccountService {
    private String name;
    private Integer age;
    private Date birthday;

    public AccountServiceImpl(String name, Integer age, Date birthday) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    @Override
    public void saveAccount() {
        System.out.println("service中的saveAccount方法执行了..." + name + ", " + age + ", " + birthday);
    }
}
