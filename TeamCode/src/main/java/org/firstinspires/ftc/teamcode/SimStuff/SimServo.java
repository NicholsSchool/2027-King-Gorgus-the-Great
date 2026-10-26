package org.firstinspires.ftc.teamcode.SimStuff;

import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.CurrentUnit;

public class SimServo {

    public double position;

    public SimServo(ServoType servoType){
       position = 0.0;

    }

    /**
     * sets the power of the Sim servo, -1, 1
     */
    public void setPower(double power){
        this.position = power;
    }

    /**
     * @return the power of the Sim servo, -1 to 1
     */
    public double getPower(){
        return position;
    }

}
