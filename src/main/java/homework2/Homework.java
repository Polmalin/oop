package homework2;

public class Homework {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";


    public static void main(String[] args) {
        Render render = new Render();
        render.showIndicator(new Building(100,120));
        render.showIndicator(new Hero (100,120, 110,300));
    }

    private interface HealthKeeper {
        void setHealthPoint (int healthPoint);

        int getHealthPoint ();

        void setMaxHealthPoint (int maxHealthPoint);

        int getMaxHealthPoint ();
    }

    private interface PowerKeeper {
        void setPowerPoint (int powerPoint);

        int getPowerPoint ();

        void setMaxPowerPoint (int maxPowerPoint);

        int getMaxPowerPoint ();
    }

    private abstract static class AbstractHealthKeeper implements HealthKeeper {
        private int healthPoint;
        private int maxHealthPoint;

        private AbstractHealthKeeper(int healthPoint, int maxHealthPoint) {
            this.healthPoint=healthPoint;
            this.maxHealthPoint=maxHealthPoint;
        }

        @Override
        public void setHealthPoint(int healthPoint) {
            this.healthPoint=healthPoint;
        }

        @Override
        public int getHealthPoint() {
            return healthPoint;
        }

        @Override
        public void setMaxHealthPoint(int maxHealthPoint) {
            this.maxHealthPoint=maxHealthPoint;
        }

        @Override
        public int getMaxHealthPoint() {
            return maxHealthPoint;
        }
    }

    private abstract static class AbstractPowerKeeper extends AbstractHealthKeeper implements PowerKeeper {
        private int powerPoint;
        private int maxPowerPoint;

        private AbstractPowerKeeper(int healthPoint, int maxHealthPoint,int powerPoint, int maxPowerPoint) {
            super(healthPoint, maxHealthPoint);
            this.powerPoint=powerPoint;
            this.maxPowerPoint=maxPowerPoint;
        }

        @Override
        public void setPowerPoint(int powerPoint) {
            this.powerPoint=powerPoint;
        }

        @Override
        public int getPowerPoint() {
            return powerPoint;
        }

        @Override
        public void setMaxPowerPoint(int maxPowerPoint) {
            this.maxPowerPoint=maxPowerPoint;
        }

        @Override
        public int getMaxPowerPoint() {
            return maxPowerPoint;
        }
    }

    static class Render {

        /**
         * Если объект обладает уровнем здоровья, то отображается индикатор с текущим уровнем здоровья.
         * Если объект обладает уровнем магический энергии, то отображается индикатор с текущим уровнем энергии.
         * * В качестве упрощения, пусть вывод на дисплей = запись информации в консоль.
         */
        public void showIndicator(Object object) {
            if (object instanceof HealthKeeper) {
                HealthKeeper healthKeeper=(HealthKeeper)object;
                System.out.println(ANSI_GREEN + "health points: "+healthKeeper.getHealthPoint()
                        +"/"+healthKeeper.getMaxHealthPoint() + ANSI_RESET);

            }
            if (object instanceof PowerKeeper) {
                PowerKeeper powerKeeper=(PowerKeeper)object;
                System.out.println(ANSI_BLUE + "power points: "+powerKeeper.getPowerPoint()
                        +"/"+powerKeeper.getMaxPowerPoint() + ANSI_RESET);

            }
        }

    }

    static class Building extends AbstractHealthKeeper {

        private Building(int healthPoint, int maxHealthPoint) {
            super(healthPoint, maxHealthPoint);
        }
    }
    static class Hero extends AbstractPowerKeeper {

        private Hero(int healthPoint, int maxHealthPoint, int powerPoint, int maxPowerPoint) {
            super(healthPoint, maxHealthPoint, powerPoint, maxPowerPoint);
        }
    }

    static class Neutral extends AbstractHealthKeeper{

        private Neutral(int healthPoint, int maxHealthPoint) {
            super(healthPoint, maxHealthPoint);
        }
    }

}
