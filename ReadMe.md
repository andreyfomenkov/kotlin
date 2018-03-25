# Kotlin Programming Language fork for JaCoCo

**Intended to be used together with JaCoCo v0.8.0 and higher for better coverage analysis.</br>
Patched compiler annotates some generated methods so they will not be displayed in the final coverage report.**</br>

For the project setup please refer the original [ReadMe.md](https://github.com/JetBrains/kotlin)

### Building
To debug new changes it's better to build compiler only. Run from the command line:

        ./gradlew dist
        
Distribution will be located in `dist/kotlinc/`.</br>
When you are ready to use patched compiler in a project, run this command to build and put all artifacts into local Maven repository:

        ./gradlew install
        
### Gradle Setup
