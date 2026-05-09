# AAC Tap Talk

AAC Tap Talk is a simple Android AAC-style communication app for children who benefit from large picture buttons and spoken choices.

The app has three choices:

- YES
- NO
- BATHROOM

When a child taps a button, the app displays the selected word in large text and speaks it aloud using Android Text-to-Speech.

## Package name

```text
com.logangoodwin.aactaptalk
```

This package name is intended for Google Play publishing. Do not use `com.example.aactaptalk` for a Play Store release.

## Features

- Large visual buttons
- Built-in Android Text-to-Speech
- No internet permission
- No ads
- No analytics
- No login
- No personal data collection
- Portrait layout for phone use

## Technical settings

- Android Gradle Plugin: 9.2.1
- Gradle wrapper distribution: 9.4.1
- compileSdk: 36
- targetSdk: 36
- minSdk: 23
- Language: Java
- UI: Native Android views

## Open in Android Studio

1. Unzip the project.
2. Open Android Studio.
3. Choose **File > Open**.
4. Select the project folder.
5. Let Gradle sync finish.
6. Run the app on an Android phone or emulator.

## Build for Google Play

To publish on Google Play, build an Android App Bundle:

1. In Android Studio, choose **Build > Generate Signed App Bundle / APK**.
2. Select **Android App Bundle**.
3. Create or choose a release keystore.
4. Build the release `.aab` file.
5. Upload the `.aab` file in Google Play Console.

Read `PLAY_STORE_PUBLISHING.md` for suggested Play Store listing text, data safety notes, and privacy policy guidance.

## Privacy

This app does not collect or share user data. See `PRIVACY_POLICY.md` for privacy policy text that can be published on a public webpage and linked in Google Play Console.
