package com.twu;

import com.twu.exception.LowPriceException;
import com.twu.exception.NoSuchHotSearchException;


public class OrdinaryUser extends User {

    private int ticketNumber;

    public OrdinaryUser(String name) {
        super(name);
        ticketNumber = 10;
    }

    public void voteForHotSearch() {
        System.out.println("请输入您要投票的热搜名称：");
        String title = sc.nextLine();
        System.out.println("请输入您要投票的热搜票数：（您目前还有" + getTicketNumber() + "票）");
        int number = Integer.parseInt(sc.nextLine());

        if (number > ticketNumber) {
            System.out.println("投票失败：剩余票数不足");
            return;
        }

        try {
            hotSearchList.vote(title, number);
            ticketNumber -= number;
            System.out.println("投票成功");
        } catch (NoSuchHotSearchException e) {
            System.out.println("投票失败：热搜不存在");
        }
    }

    public void buyHotSearch() {
        System.out.println("请输入您要购买的热搜名称：");
        String title = sc.nextLine();
        System.out.println("请输入您要购买的热搜排名：");
        int rank = Integer.parseInt(sc.nextLine());
        System.out.println("请输入您要购买的热搜金额：");
        int price = Integer.parseInt(sc.nextLine());

        try {
            hotSearchList.buy(title, rank, price);
            System.out.println("购买成功");
        } catch (NoSuchHotSearchException e) {
            System.out.println("购买失败：热搜不存在");
        } catch (LowPriceException e) {
            System.out.println("购买失败：价格过低");
        }
    }

    private int getTicketNumber() {
        return ticketNumber;
    }
}
