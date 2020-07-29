package com.twu;

import com.twu.exception.HotSearchAlreadyExistException;
import com.twu.exception.LowPriceException;
import com.twu.exception.NoSuchHotSearchException;

import java.util.*;

public class HotSearchList {

    private final List<HotSearch> list = new ArrayList<>();
    private static HotSearchList instance = new HotSearchList();

    private HotSearchList() {
    }

    public static HotSearchList getInstance() {
        return instance;
    }

    public void addOrdinaryHotSearch(String title) throws HotSearchAlreadyExistException {
        add(HotSearch.getOrdinaryHotSearch(title));
    }

    public void addSuperHotSearch(String title) throws HotSearchAlreadyExistException {
        add(HotSearch.getSuperHotSearch(title));
    }

    private void add(HotSearch hotSearch) throws HotSearchAlreadyExistException {
        if (list.stream()
                .noneMatch(s -> s.getTitle().equalsIgnoreCase(hotSearch.getTitle()))) {
            list.add(hotSearch);
        } else {
            throw new HotSearchAlreadyExistException();
        }
    }

    public void vote(String title, int number) throws NoSuchHotSearchException {
        find(title).vote(number);

        list.sort((a, b) ->
                (a.isBought() || b.isBought())
                        ? 0
                        : b.getHeat() - a.getHeat()
        );
    }

    public void buy(String title, int ranking, int price) throws NoSuchHotSearchException, LowPriceException {
        HotSearch hotSearch = find(title);

        HotSearch original = list.get(ranking - 1);
        if (original.isBought()) {
            if (original.getPrice() < price) {
                hotSearch.buy(price);
                list.remove(hotSearch);
                list.set(ranking - 1, hotSearch);
            } else {
                throw new LowPriceException();
            }
        } else {
            hotSearch.buy(price);
            list.remove(hotSearch);
            list.add(ranking - 1, hotSearch);
        }
    }

    private HotSearch find(String title) throws NoSuchHotSearchException {
        return list.stream().filter(s -> s.isSame(title))
                .findFirst()
                .orElseThrow(NoSuchHotSearchException::new);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            HotSearch hotSearch = list.get(i);
            sb.append(i + 1).append(" ")
                    .append(hotSearch.getTitle()).append(" ")
                    .append(hotSearch.getHeat()).append("\n");
        }
        return sb.toString();
    }
}
