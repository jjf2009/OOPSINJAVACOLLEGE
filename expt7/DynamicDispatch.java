class Character {
    private String name;
    private int    health;
    private int    level;

     Character(String name, int health, int level) {
        this.name   = name;
        this.health = health;
        this.level  = level;
    }

    // Getters & Setters
    public String getName()           { return name; }
    public int    getHealth()         { return health; }
    public int    getLevel()          { return level; }
    public void   setName(String n)   { this.name = n; }
    public void   setHealth(int h)    { this.health = h; }
    public void   setLevel(int l)     { this.level = l; }

    public void attack() {
        System.out.println(name + " performs a basic attack.");
    }

    @Override
    public String toString() {
        return "Name   : " + name +
               "\nHealth : " + health +
               "\nLevel  : " + level;
    }
}

class Warrior extends Character {
    private String weaponType;
    private int    attackPower;

    Warrior(String name, int health, int level, String weaponType, int attackPower) {
        super(name, health, level);
        this.weaponType  = weaponType;
        this.attackPower = attackPower;
    }

    // Getters & Setters
    public String getWeaponType()                { return weaponType; }
    public int    getAttackPower()               { return attackPower; }
    public void   setWeaponType(String w)        { this.weaponType = w; }
    public void   setAttackPower(int p)          { this.attackPower = p; }

    @Override
    public void attack() {
        System.out.println("[Warrior] " + getName() +
                " swings a " + weaponType +
                " dealing " + attackPower + " physical damage!");
    }

    @Override
    public String toString() {
        return "[Warrior]\n" + super.toString() +
               "\nWeapon : " + weaponType +
               "\nPower  : " + attackPower;
    }
}

class Mage extends Character {
    private String spellName;


    Mage(String name, int health, int level,String spellName) {
        super(name, health, level);
        this.spellName   = spellName;
    }


    public String getSpellName()              { return spellName; }
    public void   setSpellName(String s)      { this.spellName = s; }
    @Override
    public void attack() {
        System.out.println("[Mage] " + getName() +
                " casts " + spellName );
    }

    @Override
    public String toString() {
        return "[Mage]\n" + super.toString() +
               "\nSpell  : " + spellName ;
    }
}

class Archer extends Character {
    private int    arrowCount;
    private double accuracy;   // in percentage

     Archer(String name, int health, int level, int arrowCount, double accuracy) {
        super(name, health, level);
        this.arrowCount = arrowCount;
        this.accuracy   = accuracy;
    }

    // Getters & Setters
    public int    getArrowCount()             { return arrowCount; }
    public double getAccuracy()               { return accuracy; }
    public void   setArrowCount(int a)        { this.arrowCount = a; }
    public void   setAccuracy(double acc)     { this.accuracy = acc; }

    @Override
    public void attack() {
        System.out.println("[Archer] " + getName() +
                " fires an arrow with " + accuracy + "% accuracy" +
                " (" + arrowCount + " arrows remaining)!");
    }

    @Override
    public String toString() {
        return "[Archer]\n" + super.toString() +
               "\nArrows   : " + arrowCount +
               "\nAccuracy : " + accuracy + "%";
    }
}

public class DynamicDispatch {
    public static void main(String[] args) {

        java.util.Scanner sc = new java.util.Scanner(System.in);

        System.out.println("Enter character details:");

        System.out.print("Warrior name: ");
        String warriorName = sc.nextLine();

        System.out.print("Mage name: ");
        String mageName = sc.nextLine();

        System.out.print("Archer name: ");
        String archerName = sc.nextLine();

        Character warrior = new Warrior(warriorName, 500, 10, "Sword", 120);
        Character mage    = new Mage(mageName, 300, 12, "Fireball");
        Character archer  = new Archer(archerName, 350, 8, 30, 95.5);

        System.out.println("\n=== Battle Round ===");
        Character[] party = { warrior, mage, archer };

        for (Character c : party) {
            c.attack(); // Dynamic dispatch
        }

        sc.close();
    }
}