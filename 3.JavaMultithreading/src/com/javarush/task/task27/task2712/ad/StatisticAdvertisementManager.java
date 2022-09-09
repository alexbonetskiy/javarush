package com.javarush.task.task27.task2712.ad;

import java.util.ArrayList;
import java.util.List;

public class StatisticAdvertisementManager {

    private AdvertisementStorage storage = AdvertisementStorage.getInstance();

    private final static  StatisticAdvertisementManager INSTANCE = new StatisticAdvertisementManager();

    private StatisticAdvertisementManager() {};

    public static StatisticAdvertisementManager getInstance() {
        return INSTANCE;
    }

    public List<Advertisement> getActiveVideoSet() {
        List<Advertisement> list = storage.list();
        List<Advertisement> result = new ArrayList<>();
        for (Advertisement advertisement : list){
            if (advertisement.getHits() > 0){
                result.add(advertisement);
            }
        }
        return result;
    }

    public List<Advertisement> getArchivedVideoSet() {
        List<Advertisement> list = storage.list();
        List<Advertisement> result = new ArrayList<>();
        for (Advertisement advertisement : list){
            if (advertisement.getHits()  == 0){
                result.add(advertisement);
            }
        }
        return result;
    }

}
