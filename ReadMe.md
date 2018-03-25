# Kotlin Programming Language fork for JaCoCo

**Intended to be used together with JaCoCo v0.8.0 and higher for better coverage analysis.</br>
Patched compiler annotates some generated methods and thus they will not be displayed in the final coverage report.**</br>

To setup Kotlin project please refer the original documentation [ReadMe.md](https://github.com/JetBrains/kotlin)

### Building
To try and debug new changes I'd suggest to build compiler only. Run from the command line:

        ./gradlew dist
        
Compiler distribution is located in `dist/kotlinc/bin/`.</br>
When you are ready to use patched compiler in your project, run this command to build and put all artifacts into local Maven repository:

        ./gradlew install
        
### Gradle Setup
Inside build.gradle script add the reference to local Maven repository prior to `mavenCentral()` and dependency:

        buildscript {
           repositories {
              mavenLocal()
              mavenCentral()
           }
           dependencies {
              kotlinPlugin : "org.jetbrains.kotlin:kotlin-gradle-plugin:1.2-fork-1.0",
              kotlinStdLib : "org.jetbrains.kotlin:kotlin-stdlib:1.2-fork-1.0",
           }
        }
        
To specify or check the latest version, see [build.gradle.kts](https://github.com/andreyfomenkov/kotlin/blob/master/build.gradle.kts) buildscript, property `extra["defaultSnapshotVersion"]`.
