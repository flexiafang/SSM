package service.impl;

import service.AccountService;

import java.util.*;

/**
 * 账户的业务层实现类
 *
 * @Author hustffx
 * @Date 2020/6/13 15:02
 */
public class AccountServiceImpl3 implements AccountService {
    private String[] strs;
    private List<String> list;
    private Set<String> set;
    private Map<String, String> map;
    private Properties props;

    public void setStrs(String[] strs) {
        this.strs = strs;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public void setSet(Set<String> set) {
        this.set = set;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public void setProps(Properties props) {
        this.props = props;
    }

    @Override
    public void saveAccount() {
        System.out.println(Arrays.toString(strs));
        System.out.println(list);
        System.out.println(set);
        System.out.println(map);
        System.out.println(props);
    }
}
