package org.firstinspires.ftc.teamcode.SimStuff;

import com.qualcomm.robotcore.util.Range;

public class SimCRServo {

    public double power;
    public double speed;
    public double maxSpeed;

    public SimCRServo(ServoType servoType){
        speed = servoType.rotationsPerMinute;
        power = (Range.scale(speed, -maxSpeed, maxSpeed, -1, 1));

    }

    /**
     * sets the power of the Sim CR servo, -1, 1
     */
    public void setPower(double power){
        this.power = power;
    }

    /**
     * @return the power of the Sim CR servo, -1 to 1
     */
    public double getPower(){
        return power;
    }
}
