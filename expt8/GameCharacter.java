

abstract class Character {
    private String name;
    private int    health;
    private int    level;

    public Character(String name, int health, int level) {
        this.name   = name;
        this.health = health;
        this.level  = level;
    }

    public String getName()          { return name; }
    public int    getHealth()        { return health; }
    public int    getLevel()         { return level; }
    public void   setName(String n)  { this.name = n; }
    public void   setHealth(int h)   { this.health = h; }
    public void   setLevel(int l)    { this.level = l; }

    public abstract void attack();
    public abstract void defend();

  
    public void displayStats() {
        System.out.println("=== Character Stats ===");
        System.out.println(this);
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
    private int    armor;
    private int    attackPower;

    public Warrior(String name, int health, int level,
                   String weaponType, int armor, int attackPower) {
        super(name, health, level);
        this.weaponType  = weaponType;
        this.armor       = armor;
        this.attackPower = attackPower;
    }

    public String getWeaponType()              { return weaponType; }
    public int    getArmor()                   { return armor; }
    public int    getAttackPower()             { return attackPower; }
    public void   setWeaponType(String w)      { this.weaponType = w; }
    public void   setArmor(int a)              { this.armor = a; }
    public void   setAttackPower(int p)        { this.attackPower = p; }

    @Override
    public void attack() {
        System.out.println("[Warrior] " + getName() +
                " charges forward and strikes with a " + weaponType +
                " dealing " + attackPower + " physical damage!");
    }

    @Override
    public void defend() {
        System.out.println("[Warrior] " + getName() +
                " raises shield — blocking with " + armor + " armor points.");
    }

    @Override
    public String toString() {
        return "[Warrior]\n" + super.toString() +
               "\nWeapon : " + weaponType +
               "\nArmor  : " + armor +
               "\nPower  : " + attackPower;
    }
}

class Mage extends Character {
    private String spellName;
    private int    manaCost;
    private int    spellDamage;
    private int    manaShield;

    public Mage(String name, int health, int level,
                String spellName, int manaCost, int spellDamage, int manaShield) {
        super(name, health, level);
        this.spellName   = spellName;
        this.manaCost    = manaCost;
        this.spellDamage = spellDamage;
        this.manaShield  = manaShield;
    }

    public String getSpellName()              { return spellName; }
    public int    getManaCost()               { return manaCost; }
    public int    getSpellDamage()            { return spellDamage; }
    public int    getManaShield()             { return manaShield; }
    public void   setSpellName(String s)      { this.spellName = s; }
    public void   setManaCost(int m)          { this.manaCost = m; }
    public void   setSpellDamage(int d)       { this.spellDamage = d; }
    public void   setManaShield(int ms)       { this.manaShield = ms; }

    @Override
    public void attack() {
        System.out.println("[Mage] " + getName() +
                " casts " + spellName +
                " consuming " + manaCost + " mana" +
                " and dealing " + spellDamage + " magic damage!");
    }

    @Override
    public void defend() {
        System.out.println("[Mage] " + getName() +
                " raises a mana shield absorbing " + manaShield + " damage!");
    }

    @Override
    public String toString() {
        return "[Mage]\n" + super.toString() +
               "\nSpell       : " + spellName +
               "\nMana Cost   : " + manaCost +
               "\nSpell Damage: " + spellDamage +
               "\nMana Shield : " + manaShield;
    }
}

public class GameCharacter {
    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);

        System.out.print("Enter warrior name: ");
        String wName = sc.nextLine();
        System.out.print("Enter warrior health: ");
        int wHealth = Integer.parseInt(sc.nextLine());
        System.out.print("Enter warrior level: ");
        int wLevel = Integer.parseInt(sc.nextLine());

        System.out.print("Enter mage name: ");
        String mName = sc.nextLine();
        System.out.print("Enter mage health: ");
        int mHealth = Integer.parseInt(sc.nextLine());
        System.out.print("Enter mage level: ");
        int mLevel = Integer.parseInt(sc.nextLine());

        Character warrior = new Warrior(wName, wHealth, wLevel, "Sword", 80, 120);
        Character mage = new Mage(mName, mHealth, mLevel, "Blizzard", 90, 210, 150);

        System.out.println("\n=== Character Details ===");
        System.out.println(warrior);
        System.out.println();
        System.out.println(mage);

        System.out.println("\n=== Actions ===");
        warrior.attack();
        warrior.defend();
        mage.attack();
        mage.defend();

        sc.close();
    }
}