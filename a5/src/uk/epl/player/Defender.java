package uk.epl.player;

public class Defender extends Player{
    private int STRENGTH_POINT = 10;

    public Defender(String name, int jerseyNumber, int speed, int stamina, int passing) {
        super(name, jerseyNumber, speed, stamina, passing);
    }

    @Override
    protected float getStamina() {
        return super.getStamina()+STRENGTH_POINT;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
