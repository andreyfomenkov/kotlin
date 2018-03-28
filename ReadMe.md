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
In order to use local distribution, inside `build.gradle` add the reference to local Maven repository prior to `mavenCentral()`:

        buildscript {
           repositories {
              mavenLocal()
              mavenCentral()
           }
        }
       
Dependency:
        
        dependencies {
           implementation "org.jetbrains.kotlin:kotlin-gradle-plugin:1.2-fork-1.0",
           implementation "org.jetbrains.kotlin:kotlin-stdlib:1.2-fork-1.0",
        }
        
To specify or check the latest version, see property `extra["defaultSnapshotVersion"]` in [build.gradle.kts](https://github.com/andreyfomenkov/kotlin/blob/master/build.gradle.kts) buildscript.

### Changelog
The next code constructions are now being skipped by JaCoCo:</br>
#### 1.2-fork-1.0 / 25 Mar 2018:</br>
* Data Classes: toString(), hashCode(), equals(), componentN(), copy() methods;</br>
* Lateinit properties.</br>
#### 1.2-fork-1.1 / 29 Mar 2018:</br>
* Fix NoClassDefFoundError.</br>
