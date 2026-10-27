package org.firstinspires.ftc.teamcode.Turret;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class TurretIOReal implements TurretIO{

    public CRServo turret;
    public TurretIOReal(HardwareMap hwMap){

        turret = hwMap.get(CRServo.class, "turret");

    }

    @Override
    public void updateInputs (TurretIO.TurretIOInputs inputs) {
        inputs.turretPower = turret.getPower();
    }

    @Override
    public void setTurretPower(double power){
        turret.setPower(power);
    }

}
