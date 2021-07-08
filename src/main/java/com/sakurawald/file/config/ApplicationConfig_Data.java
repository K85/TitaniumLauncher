package com.sakurawald.file.config;


import com.github.ocraft.s2client.protocol.game.Difficulty;
import com.github.ocraft.s2client.protocol.game.Race;

import java.util.ArrayList;

public class ApplicationConfig_Data {

    public Debug Debug = new Debug();

    public static class Debug {
        public Boolean enable = true;
    }

    public Base Base = new Base();
    public static class Base {

        public Player Player = new Player();
        public static class Player {
            public Race race = Race.TERRAN;
        }

        public Opponent Opponent = new Opponent();
        public static class Opponent {

            public Vs_Computer Vs_Computer = new Vs_Computer();
            public static class Vs_Computer {
                public Race race = Race.TERRAN;
                public Difficulty difficulty = Difficulty.MEDIUM;
            }

            public Vs_AI Vs_AI = new Vs_AI();
            public static class Vs_AI {
                public Race race = Race.TERRAN;
            }

        }

        public String map = null;
    }



    public Settings Settings = new Settings();
    public static class Settings {

        public Client Client = new Client();
        public static class Client {

            public Boolean realTime = true;
            public Boolean multiThreads = true;
            public Boolean rawAffectsSelection = true;
            public Boolean showBurrowed = true;
            public Boolean showCloaked = true;
            public Boolean trace = true;
            public Boolean verbose = true;
            public Boolean needsSupportDir = true;
            public Boolean rawCropToPlayableArea = true;
            public Boolean useGeneralizedAbilityID = true;

            public String loadSettings = null;
            public String dataDir = null;
            public String dataVersion = null;
            public String eglPath = null;
            public String osMesaPath = null;
            public String processPath = null;
            public String tempDir = null;
            public Integer stepSize = ConfigFile.DefaultValue.INT_DEFAULT_VALUE;
            public Integer timeoutMS = ConfigFile.DefaultValue.INT_DEFAULT_VALUE;

            public WindowLocation WindowLocation = new WindowLocation();
            public static class WindowLocation {
                public Integer left = ConfigFile.DefaultValue.INT_DEFAULT_VALUE;
                public Integer top = ConfigFile.DefaultValue.INT_DEFAULT_VALUE;
            }

            public  WindowSize WindowSize = new WindowSize();
            public static class WindowSize {
                public Integer width = ConfigFile.DefaultValue.INT_DEFAULT_VALUE;
                public Integer height = ConfigFile.DefaultValue.INT_DEFAULT_VALUE;
            }

        }

        public Cheat Cheat = new Cheat();
        public static class Cheat {

            public Command Command = new Command();
            public static class Command {
                public Boolean disableWarFog = false;
                public Boolean giveAllTech = false;
                public Boolean giveAllUpgrades = false;
                public Boolean giveAllResources = false;
                public Boolean ignoreFood = false;
                public Boolean ignoreMineral = false;
                public Boolean ignoreResourceCost = false;
                public Boolean fastBuild = false;
                public Boolean enemyControl = false;
                public Boolean godMode = false;
                public Boolean noCooldowns = false;
                public Integer score = 10000;
            }

            public Draw Draw = new Draw();
            public static class Draw {
                public String drawType = null;
                public Integer colorR = 50;
                public Integer colorG = 50;
                public Integer colorB = 50;
                public Integer pointI_x = 50;
                public Integer pointI_y = 50;
                public Integer pointII_x = 100;
                public Integer pointII_y = 100;
                public Integer value = 10;
            }

            public ValueControl ValueControl = new ValueControl();
            public static class ValueControl {

                public ValuePercentageControl ValuePercentageControl = new ValuePercentageControl();
                public static class ValuePercentageControl {
                    public Double lifePercentage = 1.0;
                    public Double shieldPercentage = 1.0;
                    public Double energyPercentage = 1.0;
                }

                public ValueSpecificControl ValueSpecificControl = new ValueSpecificControl();
                public static class ValueSpecificControl {
                    public ArrayList<String> addedUnitTypeList = new ArrayList<>();

                    public AddItem AddItem = new AddItem();
                    public static class AddItem {
                        public Integer life = 50;
                        public Integer shield = 50;
                        public Integer energy = 50;
                    }
                }

            }


        }

        public Monitor Monitor = new Monitor();
        public static class Monitor {

            public Boolean monitor_events = true;

            public EventAlert EventAlert = new EventAlert();
            public static class EventAlert {
                public Boolean idleWorkerAlert = false;
                public Boolean nuclearLaunchDetectedAlert = false;
                public Boolean nydusDetectedAlert = false;
                public Boolean unitEnterVisionAlert = false;
                public Boolean unitCreatedAlert = false;
                public Boolean unitDestroyAlert = false;
                public Boolean upgradeCompletedAlert = false;
                public Boolean buildingCompletedAlert = false;
            }

        }

    }

}
