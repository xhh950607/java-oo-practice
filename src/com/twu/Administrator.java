package com.twu;


import com.twu.exception.HotSearchAlreadyExistException;


public class Administrator extends User {

    public Administrator(String name) {
        super(name);

    }

    public void addSuperHotSearch() {
        System.out.println("请输入您要添加热搜事件的名字：");
        String title = sc.nextLine();

        try {
            hotSearchList.addSuperHotSearch(title);
            System.out.println("添加成功");
        } catch (HotSearchAlreadyExistException e) {
            System.out.println("添加失败：热搜已存在");
        }
    }


}
