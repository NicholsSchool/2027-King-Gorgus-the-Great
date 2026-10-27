package org.firstinspires.ftc.teamcode.Intake;

public class Intake implements IntakeConstant{


    private final IntakeIO io;
    private final IntakeIO.IntakeIOInputs inputs = new IntakeIO.IntakeIOInputs();
    public Intake(IntakeIO io){
        this.io = io;
    }

    public void periodic(){}

    public void intake(){
        io.setIntakePower(intakePower);
    }

    public void outtake(){
        io.setIntakePower(outtakePower);
    }

    public void off(){ io.setIntakePower(0); }

    /**
     * @return The current of the Intake Motor in Amps
     */
    public double getIntakeCurrent() {return inputs.intakeCurrent;}

    /**
     * @return The power of the Intake Motor
     */
    public double getIntakePower() {return inputs.intakePower;}



}
