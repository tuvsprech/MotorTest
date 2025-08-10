public class ShooterMotor extends BaseMotor {
        // public is access modifier, allowing this class to be accessed 
        //   from any other class
        // public (like global) determines the visibility of a class, 
        //   method or variable, requires an object to be created to access it
        // static is keyword that indicates that the method or variable 
        //   belongs to the class itself, rather than an instance of the class
        //    allows access w/o creating object of the class
        // use static for utility methods, constatns or data that dont depend 
        //   on instance variables 
        // instance variables specific to ShooterMotor
        private double targetRPM;
        private double currentRPM;
        private final double MaxRPM = 6000; // rpm
        private final double MaxError = 50; // rpm
        // constructor
        public ShooterMotor(String motorName) {
            super(motorName, 1.0);
            targetRPM = 0.0;
            currentRPM = 0.0;
        }
        
        public void setTargetRPM(double rpm) {
            targetRPM = rpm;
            double motorSpeed = rpm / MaxRPM;
            setSpeed(motorSpeed);
        }
        
        public void updateCurrentRPM(double rpm) {
            currentRPM = rpm;
        }
        
        public boolean isReadyToShoot() {
            return Math.abs(currentRPM - targetRPM) < MaxError && targetRPM > 0;
        }
        
        @Override
        public void stop() {
            this.targetRPM = 0.0;
            super.stop(); // calls parent class stop method to stop the motor
        }
    }
    

