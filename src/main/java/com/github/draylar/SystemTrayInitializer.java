package com.github.draylar;


import java.awt.*;
import java.net.URL;

public class SystemTrayInitializer {

    private URL iconImage = null;

    private MenuItem bronze = new MenuItem("Bronze");
    private MenuItem silver = new MenuItem("Silver");
    private MenuItem gold = new MenuItem("Gold");
    private MenuItem platinum = new MenuItem("Platinum");
    private MenuItem diamond = new MenuItem("Diamond");
    private MenuItem masters = new MenuItem("Masters");
    private MenuItem grandmasters = new MenuItem("Grand Masters");


    public void initIcon() {
        if(!SystemTray.isSupported()) System.out.println("Can't access the system tray. Are you on an OS without one?");

        else {
            PopupMenu popupMenu = new PopupMenu();

            try {
                iconImage = getClass().getResource("/GM_16b.png");
            } catch (Exception e) {
                e.printStackTrace();
            }

            TrayIcon trayIcon = new TrayIcon(Toolkit.getDefaultToolkit().getImage(iconImage), "hi");
            SystemTray systemTray = SystemTray.getSystemTray();

            popupMenu.add(bronze);
            popupMenu.add(silver);
            popupMenu.add(gold);
            popupMenu.add(platinum);
            popupMenu.add(diamond);
            popupMenu.add(masters);
            popupMenu.add(grandmasters);

            trayIcon.setPopupMenu(popupMenu);

            try {
                systemTray.add(trayIcon);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        addClickEvents();
    }


    public void addClickEvents() {
        bronze.addActionListener(e -> Main.setCurrentRankIcon("bronze"));
        silver.addActionListener(e -> Main.setCurrentRankIcon("silver"));
        gold.addActionListener(e -> Main.setCurrentRankIcon("gold"));
        platinum.addActionListener(e -> Main.setCurrentRankIcon("platinum"));
        diamond.addActionListener(e -> Main.setCurrentRankIcon("diamond"));
        masters.addActionListener(e -> Main.setCurrentRankIcon("masters"));
        grandmasters.addActionListener(e -> Main.setCurrentRankIcon("grandmaster"));
    }
}
