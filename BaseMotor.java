public class BaseMotor {
                 // מאפיינים משותפים לכל המנועים  
                 protected String name;  // protected as INSTANCE field
                 // if name were STATIC then BaseMotor.name would be valid
                 // but it would mean that all instances of BaseMotor 
                 // share the same name which is not what we want, 
                 // each motor should have its own name
                 // if we would declare private static String name; 
                 // as a Static field, then in the constructor we would 
                 // have to write BaseMotor.name = motorName;
                 protected double speed; 
                 protected double maxSpeed;
                 protected boolean isReversed;
            
               
                public BaseMotor(String motorName, double maxSpeedLimit) {
            // constructor = object creation, initialize essential properties
            // Initialize the motor with a name and a maximum speed limit
            // only add properties critical to motor's initial state
                this.name = motorName;
            // refers to instance field of current object
            // writing BaseMotor.name refers to STATIC field of BaseMotor
            // however here we want to set the instance variable
                    this.maxSpeed = maxSpeedLimit;
            // Initiate motor OPERATIONAL states speed to default values
            // could be included in in BaseMotor arguments, 
            // however would require caller to explicitely set them
            // writing BaseMotor.name = motorName implies 
            // that name is static field of BaseMotor class
            // in our case name is and INSTANCE variable, not STATIC
                    this.speed = 0.0; 
            // speed is an instance variable, not static
                    this.isReversed = false;
                }
            // read motorName from BaseMotor call input argument
                public String getName() {
                    return name;
                }
            // read maxSpeed from BaseMotor call input argument
            // read newSpeed from setSpeed call input argument 
            // the getspeed method is public so it can be accessed 
            // from any othe class as follows:
            // public class MotorTest {
                //   public static void main(String[] args) {
                //   Create an new instance of BaseMotor
                //     BaseMotor motor = new BaseMotor("Motor1", 100.0); 
                //      maxSpeed = 100.0 // Set the speed of the motor
                //     motor.setSpeed(50.0);
                //     double currentSpeed = motor.getSpeed()
                //     System.out.println("Current Speed: " + currentSpeed)

                public void setSpeed(double newSpeed) {
                   speed = newSpeed > maxSpeed ? maxSpeed 
                   : newSpeed < -maxSpeed ? -maxSpeed : newSpeed;
                // Ensure speed does not exceed maxSpeed in either direction
                // if newSpeed > maxSpeed, set to maxSpeed
                // elseif newSpeed < -maxSpeed, set to -maxSpeed
                // else set to newSpeed (if -maxSpeed<newSpeed<maxSpeed)
                }
                
                // method checks value of the isReversed boolean 
                // and returns either speed or -speed
                public double getSpeed() {
                    return isReversed ? -speed : speed;
                }
                
                public void stop() {
                    this.speed = 0.0;
                }
                
                // toggle value of isReversed boolean
                // dynamically change motor direction during runtime
                public void reverse() {
                // if isReversed is true, set it to false, and vice versa
                // write: this.isReversed refers to 
                // current instance of BaseMotor class
                // using this. ensures that the instance field is updated, 
                // and not a local variable with (by chance) the same name
                    this.isReversed = !this.isReversed;
                }
                

            }
            