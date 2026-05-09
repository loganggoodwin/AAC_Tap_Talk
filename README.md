# AAC Tap Talk

AAC Tap Talk is a simple Android communication app for children who need quick tap-to-speak choices. It gives the child three large picture buttons: **Yes**, **No**, and **Bathroom**. When a button is tapped, the app shows the choice on screen and speaks it aloud.

## GitHub description

Simple Android AAC tap-to-speak app for disabled children with large Yes, No, and Bathroom picture buttons using Android Text-to-Speech.

## What it does

- Shows three large picture buttons
- Speaks the selected choice out loud
- Displays the selected word in large text
- Uses Android's built-in Text-to-Speech engine
- Uses a simple native Android layout, not a WebView
- Includes large tap targets for easier use
- Adds safe spacing so the screen content does not hide under the camera/notch area

## Buttons

| Button | What it shows | What it says |
|---|---|---|
| Yes | YES | Yes |
| No | NO | No |
| Bathroom | BATHROOM | I need the bathroom |

## Requirements

- Android Studio
- Android SDK 36 or newer if Android Studio asks to install it
- Android phone or emulator
- Java 17, which Android Studio normally provides through its Gradle JDK setting
- Gradle wrapper set to Gradle 9.4.1

## How to open and run

1. Download and unzip this project.
2. Open Android Studio.
3. Choose **Open**.
4. Select the unzipped `AAC_Tap_Talk` folder.
5. Let Android Studio sync the Gradle project.
6. Plug in your Android phone with USB debugging enabled.
7. Select the phone from the device dropdown.
8. Click the green **Run** button.

## How to build an APK

In Android Studio:

1. Go to **Build**.
2. Choose **Build Bundle(s) / APK(s)**.
3. Choose **Build APK(s)**.
4. After the build finishes, Android Studio will show a link to the APK.

## Project structure

```text
AAC_Tap_Talk/
├── app/
│   └── src/main/
│       ├── AndroidManifest.xml
│       ├── java/com/logangoodwin/aactaptalk/MainActivity.java
│       └── res/
│           ├── drawable/
│           └── values/
├── build.gradle.kts
├── settings.gradle.kts
├── gradle/wrapper/gradle-wrapper.properties
└── README.md
```

## Gradle note

This project uses Android Gradle Plugin 9.2.1 and includes a Gradle wrapper properties file set to Gradle 9.4.1. If Android Studio shows an older Gradle version, open `gradle/wrapper/gradle-wrapper.properties` and confirm this line is present:

```properties
distributionUrl=https\://services.gradle.org/distributions/gradle-9.4.1-bin.zip
```

Then choose **Sync Project with Gradle Files** or re-import the project.

## Notes

This is a basic communication helper app. It is not a medical device, diagnosis tool, or replacement for professional AAC support. It is meant to be a simple starter project that can be expanded with more buttons, custom pictures, or custom phrases.

## Author

Logan Garth Goodwin
