# SensorApplication

I have created an Android app that displays the user's current location on a map using Google Maps API. It also implements a dead reckoning algorithm to estimate the user's location when the GPS signal is weak or unavailable. The app requests location updates from the LocationManager and registers a listener to receive these updates. When the user presses the "Location" button, the app displays the user's current location on the map, along with latitude and longitude coordinates.
The dead reckoning algorithm calculates the user's displacement and velocity based on accelerometer data. It uses a low-pass filter to smooth the accelerometer data and then integrates the acceleration to estimate velocity and displacement.
Dead reckoning is a navigation technique used to estimate the current position of an object based on its previously known position and its direction and speed of travel. It is often used when GPS signals are unavailable, such as in indoor environments or in tunnels.
The dead reckoning algorithm uses data from sensors such as accelerometers, gyroscopes, and compasses to estimate the object's position, velocity, and direction of travel. The algorithm works by integrating the measurements from these sensors over time to estimate the object's displacement, velocity, and direction.
Here is a step-by-step description of how the dead reckoning algorithm works:
Initialize the starting position: The dead reckoning algorithm starts with a known starting position, such as the last known GPS location.
Measure the acceleration: The algorithm measures the acceleration of the object using an accelerometer. The accelerometer measures the acceleration in three dimensions, along the X, Y, and Z axes.
Apply a low-pass filter: The accelerometer data is typically noisy and contains high-frequency components that need to be removed. The algorithm applies a low-pass filter to smooth the data and remove the high-frequency noise.
Integrate the acceleration: The algorithm integrates the acceleration data over time to calculate the velocity of the object. This is done by multiplying the acceleration by the time interval between measurements and adding it to the previous velocity estimate.
Integrate the velocity: The algorithm integrates the velocity over time to calculate the displacement of the object. This is done by multiplying the velocity by the time interval between measurements and adding it to the previous displacement estimate.
Update the position: The algorithm updates the current position of the object by adding the calculated displacement to the starting position.
Repeat: The algorithm repeats steps 2-6 for each new measurement from the sensors.
The dead reckoning algorithm is effective when the sensors are accurate and the motion of the object is predictable. However, errors can accumulate over time, leading to significant drift in the estimated position. For example, small errors in the accelerometer measurements can lead to large errors in the estimated position over time. To mitigate these errors, the dead reckoning algorithm can be combined with other techniques, such as landmark detection or map matching, to improve the accuracy of the estimated position.
The code registers a listener for accelerometer data and uses it to update the lastAccelerometerData variable. When the location is updated, the dead reckoning algorithm calculates the velocity and displacement based on the time elapsed since the last update and the accelerometer data.
The app also checks for the necessary permissions to access the user's location and requests them if they are not granted. If the permissions are granted, the app requests location updates and registers a listener for accelerometer data. When the app is paused, it stops requesting location updates and unregisters the listener for accelerometer data.
The application consists of a button and two EditText views to display the latitude and longitude values of the current location. When the button is clicked, the application adds a marker to the Google Map at the current location and zooms in on it. The latitude and longitude values are also displayed in the EditText views.
The location updates are obtained using the GPS_PROVIDER, and the onLocationChanged() method is used to update the location coordinates. Dead reckoning is performed using the accelerometer data obtained in the onSensorChanged() method. A low-pass filter is applied to the accelerometer data to remove high-frequency noise, and the displacement and velocity are calculated using the acceleration data.
The dead reckoning calculations are performed in the onLocationChanged() method. The current time and the time of the last update are used to calculate the time difference, and the acceleration, velocity, and displacement are updated accordingly.
The application also implements the SensorEventListener and LocationListener interfaces to receive updates from the accelerometer and GPS sensors, respectively. Finally, the application implements the OnMapReadyCallback interface to display the Google Map.

