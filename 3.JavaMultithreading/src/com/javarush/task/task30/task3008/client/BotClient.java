package com.javarush.task.task30.task3008.client;


import com.javarush.task.task30.task3008.ConsoleHelper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class BotClient extends Client{

    @Override
    protected SocketThread getSocketThread() {
        return new BotSocketThread();
    }

    @Override
    protected boolean shouldSendTextFromConsole() {
        return false;
    }

    @Override
    protected String getUserName() {
        int x =(int) (Math.random()*100);
        return "date_bot_" + x;
    }

    public static void main(String[] args) {
        BotClient botClient = new BotClient();
        botClient.run();
    }

    public class BotSocketThread extends Client.SocketThread {

        @Override
        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            sendTextMessage("Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.");
            super.clientMainLoop();
        }

        @Override
        protected void processIncomingMessage(String message) {
            ConsoleHelper.writeMessage(message);
            String[] messageArray = message.split(":");
            if (!message.contains(":") && messageArray.length != 2) return;
            String userName = messageArray[0].trim();
            String text = messageArray[1].trim();
            SimpleDateFormat dateFormat = new SimpleDateFormat("d.MM.YYYY");
            Calendar calendar = Calendar.getInstance();
            switch (text){
                case ("дата"): dateFormat = new SimpleDateFormat("d.MM.YYYY"); sendTextMessage("Информация для "+ userName + ": " + dateFormat.format(calendar.getTime()));
                break;
                case ("день"): dateFormat = new SimpleDateFormat("d"); sendTextMessage("Информация для "+ userName + ": " + dateFormat.format(calendar.getTime()));
                break;
                case ("месяц"): dateFormat = new SimpleDateFormat("MMMM"); sendTextMessage("Информация для "+ userName + ": " + dateFormat.format(calendar.getTime()));
                break;
                case ("год"): dateFormat = new SimpleDateFormat("YYYY"); sendTextMessage("Информация для "+ userName + ": " + dateFormat.format(calendar.getTime()));
                break;
                case ("время"): dateFormat = new SimpleDateFormat("H:mm:ss"); sendTextMessage("Информация для "+ userName + ": " + dateFormat.format(calendar.getTime()));
                break;
                case ("час"): dateFormat = new SimpleDateFormat("H"); sendTextMessage("Информация для "+ userName + ": " + dateFormat.format(calendar.getTime()));
                break;
                case ("минуты"): dateFormat = new SimpleDateFormat("m"); sendTextMessage("Информация для "+ userName + ": " + dateFormat.format(calendar.getTime()));
                break;
                case ("секунды"): dateFormat = new SimpleDateFormat("s"); sendTextMessage("Информация для "+ userName + ": " + dateFormat.format(calendar.getTime()));
                break;
            }



        }
    }
}
