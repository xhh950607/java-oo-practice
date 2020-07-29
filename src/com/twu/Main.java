package com.twu;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("欢迎来到热搜排行榜，你是？");
            System.out.println("1.用户");
            System.out.println("2.管理员");
            System.out.println("3.退出");

            int op = Integer.parseInt(sc.nextLine());

            if (op == 1) {
                System.out.println("请输入您的昵称：");
                String username = sc.nextLine();
                OrdinaryUser user = new OrdinaryUser(username);

                while (true) {
                    System.out.println("你好，" + user.getName() + "，你可以：");
                    System.out.println("1.查看热搜排行榜");
                    System.out.println("2.给热搜事件投票");
                    System.out.println("3.购买热搜");
                    System.out.println("4.添加热搜");
                    System.out.println("5.退出");

                    op = Integer.parseInt(sc.nextLine());

                    if (op == 1) {
                        user.checkHotSearchList();
                    } else if (op == 2) {
                        user.voteForHotSearch();
                    } else if (op == 3) {
                        user.buyHotSearch();
                    } else if (op == 4) {
                        user.addOrdinaryHotSearch();
                    } else if (op == 5) {
                        break;
                    }
                }
            } else if (op == 2) {
                System.out.println("请输入您的昵称：");
                String username = sc.nextLine();
                Administrator admin = new Administrator(username);

                while (true) {
                    System.out.println("你好，" + admin.getName() + "，你可以：");
                    System.out.println("1.查看热搜排行榜");
                    System.out.println("2.添加热搜");
                    System.out.println("3.添加超级热搜");
                    System.out.println("4.退出");

                    op = Integer.parseInt(sc.nextLine());

                    if (op == 1) {
                        admin.checkHotSearchList();
                    } else if (op == 2) {
                        admin.addOrdinaryHotSearch();
                    } else if (op == 3) {
                        admin.addSuperHotSearch();
                    } else if (op == 4) {
                        break;
                    }
                }
            } else if (op == 3) {
                break;
            }
        }
    }
}
