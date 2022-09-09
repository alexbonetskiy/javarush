package com.javarush.task.task27.task2712.ad;

public class Advertisement {
    private Object content;
    private String name;
    private long initialAmount;
    private int hits;
    private int duration;
    private long amountPerOneDisplaying;

    @Override
    public String toString() {
        return name + " is displaying... " + amountPerOneDisplaying + ", " + calcCostInThousands();
    }

    public Advertisement(Object content, String name, long initialAmount, int hits, int duration) {
        this.content = content;
        this.name = name;
        this.initialAmount = initialAmount;
        this.hits = hits;
        this.duration = duration;
        if (hits != 0)
        amountPerOneDisplaying = initialAmount/hits;
    }

    public int getHits() {
        return hits;
    }

    public String getName() {
        return name;
    }

    public int getDuration() {
        return duration;
    }

    public long getAmountPerOneDisplaying() {
        return amountPerOneDisplaying;
    }

    public void revalidate() {
        if (hits == 0) {throw new UnsupportedOperationException();}
        hits--;

    }

    public  int calcCostInThousands() {
        float costPerSecond = ((float) amountPerOneDisplaying/(float) duration);
        int cost =(int) (costPerSecond*1000);
        return cost;
    }

    public boolean isActive() {
        return hits > 0;
    }



}
