package com.twu;

import com.twu.exception.HotSearchAlreadyExistException;
import java.util.Scanner;

abstract public class User {

    protected String name;
    protected HotSearchList hotSearchList;
    protected Scanner sc;

    public User(String name) {
        this.name = name;
        this.hotSearchList = HotSearchList.getInstance();
        sc = new Scanner(System.in);
    }

    public String getName() {
        return this.name;
    }

    public void checkHotSearchList() {
        System.out.println(hotSearchList.toString());
    }

    public void addOrdinaryHotSearch() {
        System.out.println("请输入您要添加热搜事件的名字：");
        String title = sc.nextLine();

        try {
            hotSearchList.addOrdinaryHotSearch(title);
            System.out.println("添加成功");
        } catch (HotSearchAlreadyExistException e) {
            System.out.println("添加失败：热搜已存在");
        }
    }

}
