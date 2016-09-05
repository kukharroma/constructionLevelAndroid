# Construction level android

## Description
This app shows angles of inclination of the device to the ground.
<p> The app uses an accelerometer, so you should have it on your device.

<img src="/app/src/main/assets/1.png">
<img src="/app/src/main/assets/2.png">
<img src="/app/src/main/assets/3.png">
<img src="/app/src/main/assets/4.png">
<img src="/app/src/main/assets/5.png">

## Requirements
Install the following software:

[Java] [java]

[Android SDK] [android sdk]

[Android Studio] [android studio]

## Usage

Run debug build
	`./gradlew :app:clean :app:assembleDebug`
	
Run unit tests
  `./gradlew testDebug` [More info] [android test info]

Install on device 
  `./gradlew :app:installDebug`
  
## Authors
* [Roman Kukhar](mailto:kukharroma@gmail.com) ([kukharoma][github-kukharoma])

[android test info]: http://tools.android.com/tech-docs/unit-testing-support
[android studio]: https://developer.android.com/intl/ru/sdk/index.html
[java]: http://www.oracle.com/technetwork/java/javase/overview/index.html
[android sdk]: https://developer.android.com/intl/ru/sdk/index.html
[github-kukharoma]: https://github.com/kukharroma
