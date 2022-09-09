package com.javarush.task.task14.task1408;

class UkrainianHen extends Hen implements Country{

    @Override
    public int getCountOfEggsPerMonth() {
        return 4;
    }
    @Override
    public String getDescription() {
        return super.getDescription()+" Моя страна - "+ Country.UKRAINE + ". Я несу "+ getCountOfEggsPerMonth() + " яиц в месяц.";
    }
}
