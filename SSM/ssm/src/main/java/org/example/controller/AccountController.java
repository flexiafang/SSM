package org.example.controller;

import org.example.domain.Account;
import org.example.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 账户web
 *
 * @Author hustffx
 * @Date 2020/6/26 10:58
 */
@Controller
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private AccountService accountService;

    /**
     * 查询所有
     *
     * @param model
     * @return
     */
    @RequestMapping("/findAll")
    public String findAll(Model model) {
        System.out.println("表现层：查询所有账户...");
        // 调用service的方法
        List<Account> accounts = accountService.findAll();
        model.addAttribute("list", accounts);
        return "list";
    }

    /**
     * 保存
     *
     * @param account
     * @return
     */
    @RequestMapping("/save")
    public void save(Account account, HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("表现层：保存账户...");
        // 调用service的方法
        accountService.saveAccount(account);
        // 重定向
        response.sendRedirect(request.getContextPath() + "/account/findAll");
    }
}
