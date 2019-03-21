package Moba;

class PlayerFactory {
    private static int count = 1;
    static Hero getPlayer(int type) {
        Hero hero;
        switch (type) {
            case Player.ASSASSIN:
                hero = new Assassin(count, 150, 75);
                break;
            case Player.HEALER:
                hero = new Healer(count, 200, 0);
                break;
            case Player.WARRIOR:
                hero = new Warrior(count, 300, 35);
                break;
            default:
                hero = new Warrior(count, 300, 35);
        }
        count++;
        return hero;
    }
}
