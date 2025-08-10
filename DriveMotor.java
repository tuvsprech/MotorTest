public class DriveMotor extends BaseMotor {
        private double distanceTraveled;
        private int encoderTicks;
        private final double TICKS_PER_METER = 1000; // דוגמה
        
        // constructor for DriveMotor class, new instance of DriveMotor 
        // is created with a motorName, and sets a default maximum speed of 1.0 
        public DriveMotor(String motorName) {
            // call contructor of parent class (superclass) BaseMotor 
            // using the super keyword
           // passes two arguments to parent class constructor
            // motorName and a default max speed of 1.0
            // it also sets up any additional properties specific to DriveMotor
            // This allows DriveMotor to inherit properties 
            // and methods from BaseMotor
            super(motorName, 1.0); // קריאה לבנאי של מחלקת הבסיס
            distanceTraveled = 0.0;
            encoderTicks = 0;
        }
        
        // מתודה חדשה ייחודית למנועי הנעה
        public void updateEncoder(int newTicks) {
            encoderTicks = newTicks;
            distanceTraveled = encoderTicks / TICKS_PER_METER;
        }
        
        public double getDistanceTraveled() {
            return distanceTraveled;
        }
        
        public void resetDistance() {
            encoderTicks = 0;
            distanceTraveled = 0.0;
        }
        
        // indicate that the stop method in DriveMotor is overriding a method  
        // with same name in parent class BaseMotor
        // this allows DriveMotor to provide its own implementation 
        // of the stop method
        // if no such method exists in BaseMotor, 
        // this will result in a compile-time error
        @Override
        // first: call stop method from parent class to perform 
        // basic functionality, 
        // then adds custom behavior for DriveMotor class
        public void stop() { 
            // declaration/definition of stop method in DriveMotor class 
            super.stop(); 
            // calls the stop method of the parent class BaseMotor
            // this ensures that the functionality of the parent class 
            // stop method is executed before adding additional behavior 
            // in DrivMotor class
            // after calling the parent class stop method, 
            // we can add additional behavior specific to DriveMotor
            System.out.println(name + " Stop at: " + distanceTraveled + "meters'");
            // adding additional behavior specific to DriveMotor class
        }
    }
    

