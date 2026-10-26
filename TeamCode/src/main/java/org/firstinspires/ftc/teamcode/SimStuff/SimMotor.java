package org.firstinspires.ftc.teamcode.SimStuff;

import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.CurrentUnit;

public class SimMotor {

    public double power;
    public double velocity;
    public double maxVelocity;

    public SimMotor(MotorType motorType){
        velocity = 0.0;
        maxVelocity = (motorType.maxRpm * 6); // in degrees/second
        power = (Range.scale(velocity, -maxVelocity, maxVelocity, -1, 1));

    }

    /**
     *
     * @param velocity the value you want to set the velocity of the Sim motor to
     * @param angleUnit the unit for the angular velocity
     */
    public void setVelocity(double velocity, AngleUnit angleUnit){ //TODO: make this actually use different inputs :)
        if (angleUnit == AngleUnit.DEGREES){
            this.velocity = velocity;
        }else{
            this.velocity = velocity;
        }
    }

    /**
     *
     * @param velocity the value you want to set the velocity of the Sim motor to
     */
    public void setVelocity(double velocity){ //TODO: make this actually use different inputs :)
        this.velocity = velocity;
    }

    public double getVelocity(AngleUnit angleUnit){
        return velocity;
    }

    /**
     * sets the power of the Sim motor, rpm normalized to a "power" -1 to 1
     */
    public void setPower(double power){
        this.power = power;
    }

    /**
     * @return the power of the Sim motor, rpm normalized to a "power" -1 to 1
     */
    public double getPower(){
        return power;
    }

    public double getCurrent(CurrentUnit currentUnit){
        return velocity; //TODO: change pls
    }


}
