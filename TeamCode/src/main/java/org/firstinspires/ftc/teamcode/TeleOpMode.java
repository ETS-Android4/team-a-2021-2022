package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.util.*;

@TeleOp(name = "TeleOpMode", group = "Tele-Op")
public class TeleOpMode extends OpMode {
    MecanumDrive drive;
    Carousel carousel;
    Slide slides;
    TubeIntake intake;
    Carriage carriage;
    IMU imu;
    Speed speed;
    ToggleButton btYSlowMode;
    @Override
    public void init() {
        drive = new MecanumDrive(hardwareMap);
        carousel = new Carousel(hardwareMap);
        slides = new Slide(hardwareMap);
        slides.stopAndResetEncoder();
        intake = new TubeIntake(hardwareMap);
        carriage = new Carriage(hardwareMap);
        imu = new IMU(hardwareMap);
        imu.initializeIMU();
        speed = Speed.FAST;
        btYSlowMode = new ToggleButton(() -> gamepad1.y);
    }

    public static int SLIDE_SAFE_CARRIAGE_MOTION_THRESHOLD = (Slide.getMinPosition() + Slide.getMaxPosition()) / 3;

    @Override
    public void loop() {
        double speedVal = speed==Speed.FAST ? 0.75 : 0.3;
        drive.teleOpRobotCentric(gamepad1,speedVal);
        if(gamepad1.right_bumper){
            double pwr = slides.getSafePower(0.9);
            slides.setPower(pwr);
        }
        else if(gamepad1.left_bumper){
            double pwr = slides.getSafePower(-0.9);
            slides.setPower(pwr);
        }
        else{
            slides.stop();
        }

        if(gamepad1.left_trigger>0.1){
            intake.setPower(-gamepad1.left_trigger);
        }
        else if(gamepad1.right_trigger>0.1){
            intake.setPower(gamepad1.right_trigger);
        }
        else{
            intake.stop();
        }



        if(btYSlowMode.isActive()){
            speed = Speed.SLOW;
        }
        else{
            speed = Speed.FAST;
        }


        if(gamepad1.b && slides.getCurrentPosition() >= SLIDE_SAFE_CARRIAGE_MOTION_THRESHOLD){
            carriage.dump();
        }
        else if(gamepad1.x){
            carriage.idle();
        }

        if(gamepad1.dpad_left){
            carousel.spinReverse(true);
        }
        else if(gamepad1.dpad_right){
            carousel.spin(true);
        }
        else{
            carousel.stop();
        }
        btYSlowMode.update();
        telemetry.addData("SLOW MODE",speed);
        telemetry.update();
    }
}
