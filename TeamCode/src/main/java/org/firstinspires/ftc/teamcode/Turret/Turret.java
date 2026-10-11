package org.firstinspires.ftc.teamcode.Turret;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.Transfer.TransferIO;

public class Turret implements TurretConstants{

    private final TurretIO io;
    private final TurretIO.TurretIOInputs inputs = new TurretIO.TurretIOInputs();
    public Turret(TurretIO io){this.io = io;}

    public void setVariableTurretPower(double power){
        io.setTurretPower(power);
    }
    public double getTurretPower(){
        return inputs.turretPower;
    }
}
