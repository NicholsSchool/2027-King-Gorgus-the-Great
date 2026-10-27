package org.firstinspires.ftc.teamcode.FIntake;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class FIntakeIOReal implements FIntakeIO{

    public Servo fIntake;
    public boolean fIntakeUp;

    public FIntakeIOReal(HardwareMap hwMap){

        fIntake = hwMap.get(Servo.class, "fIntake");

    }

    @Override
    public void updateInputs (FIntakeIO.FIntakeIOInputs inputs) {
        inputs.fIntakePos = fIntake.getPosition();
        fIntakeUp = inputs.fIntakePos > 0.7 && inputs.fIntakePos < 0.9;
        inputs.fIntakeUp = fIntakeUp;
    }

    /**
     * @param position the position to set the FIntake to
     */
    @Override
    public void setPosition(double position){
        fIntake.setPosition(position);
    }
}
