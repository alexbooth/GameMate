# GameMate
Android game engine based on libGDX

## Usage
In App build.gradle add Jitpack
```
allprojects {
    ...
    repositories {
        ...
        maven { url "https://jitpack.io" }
        ...
    }
    ...
}
```
Add in ```project("core")``` in App build.gradle
```sh
implementation 'com.github.alexdbooth:GameMate:0.0.1'
```

Add in ```project("android")``` in App build.gradle
```sh
implementation 'com.github.alexdbooth:GameMate:0.0.1'
```

## Development usage
Clone repo to top level of libGDX project
```sh
cd ~/AndroidStudioProjects/myApp
git clone https://github.com/alexdbooth/GameMate.git
```

Add in ```project("core")``` in App build.gradle
```sh
implementation project(path: ':GameMate', configuration: 'default')
```

Add in ```project("android")``` in App build.gradle
```sh
implementation project(path: ':GameMate', configuration: 'default')
```
