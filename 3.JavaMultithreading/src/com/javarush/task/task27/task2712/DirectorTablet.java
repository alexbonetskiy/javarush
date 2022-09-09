package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.ad.Advertisement;
import com.javarush.task.task27.task2712.ad.AdvertisementStorage;
import com.javarush.task.task27.task2712.ad.StatisticAdvertisementManager;
import com.javarush.task.task27.task2712.statistic.StatisticManager;

import java.util.*;

public class DirectorTablet {

    public void printAdvertisementProfit(){
        StatisticManager statisticManager = StatisticManager.getInstance();
         TreeMap<String, Double> map = statisticManager.advertisementProfitStatistic();
         double total = 0;
         for (Map.Entry<String, Double> entry : map.entrySet())
         {
             total += entry.getValue()/100;
             System.out.printf(Locale.ENGLISH, "%s - %.2f%n", entry.getKey(), entry.getValue()/100);
         }
        System.out.printf(Locale.ENGLISH, "%s - %.2f%n", "Total", total );

    }
    public void printCookWorkloading() {
        StatisticManager statisticManager = StatisticManager.getInstance();
        TreeMap<String, TreeMap<String, Integer>> map = statisticManager.cooksStatistics();
        for (Map.Entry<String, TreeMap<String, Integer>> entry : map.entrySet())
        {
            System.out.println(entry.getKey());
            for (Map.Entry<String, Integer> innerEntry : entry.getValue().entrySet())
                System.out.println(innerEntry.getKey() + " - "+ innerEntry.getValue() + " min");
        }


    }
    public void printActiveVideoSet() {
        StatisticAdvertisementManager manager = StatisticAdvertisementManager.getInstance();
        List<Advertisement> list = manager.getActiveVideoSet();
        list.sort((o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName()));
        for (Advertisement advertisement : list){
            System.out.println(advertisement.getName() + " - " + advertisement.getHits());
        }

    }
    public void printArchivedVideoSet() {
        StatisticAdvertisementManager manager = StatisticAdvertisementManager.getInstance();
        List<Advertisement> list = manager.getArchivedVideoSet();
        list.sort((o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName()));
        for (Advertisement advertisement : list){
            System.out.println(advertisement.getName());
        }
    }
}
