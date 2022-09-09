package com.javarush.task.task27.task2712.ad;

import java.util.ArrayList;
import java.util.List;

public class AdvertisementStorage {

    private static final AdvertisementStorage instance = new AdvertisementStorage();
    private final List<Advertisement> videos = new ArrayList<>();


    private AdvertisementStorage() {
    Object someContent = new Object();
      videos.add( new Advertisement(someContent, "First Video", 5000, 100, 3 * 60)); // 3 min
      videos.add(new Advertisement(someContent, "second Video", 100, 10, 15 * 60));//15 min
      videos.add(new Advertisement(someContent, "Third Video", 400, 2, 10 * 60)); //10 min
      videos.add(new Advertisement(someContent, "fifth Video", 100, 3, 5 * 60));
      videos.add(new Advertisement(someContent, "первое", 4000, 1, 20 * 60));
      videos.add(new Advertisement(someContent, "Второе", 400, 2, 11 * 60));
      videos.add(new Advertisement(someContent, "третье", 400, 2, 10 * 60));
    }


    public static AdvertisementStorage getInstance () {
        return instance;
    }

    public List<Advertisement> list(){
        return videos;
    }

    public void add(Advertisement video) {
        videos.add(video);
    }
}
