@echo off
setlocal

echo.
echo ==========================================
echo   Minecraft Paper Plugin Build
echo ==========================================
echo.

echo [1/4] Checking Java installation...

for /f "tokens=2,*" %%A in ('java -XshowSettings:properties -version 2^>^&1 ^| findstr "java.home"') do (
    set "JAVA_HOME=%%B"
)

if not defined JAVA_HOME (
    echo.
    echo ERROR: Java was not found.
    echo Please install Java 25 and try again.
    echo.
    pause
    exit /b 1
)

echo Java found:
echo %JAVA_HOME%
echo.

echo [2/4] Downloading required libraries if needed...
echo This includes the Paper API and Maven build tools.
echo.

echo [3/4] Compiling your Java code and creating the plugin JAR...
echo.

call mvnw.cmd -q package 2>nul

if errorlevel 1 (
    echo.
    echo ==========================================
    echo BUILD FAILED
    echo ==========================================
    echo.
    echo Check the Java errors above and try again.
    echo.
    pause
    exit /b 1
)

echo.
echo [4/4] Build complete.
echo.

echo ==========================================
echo BUILD SUCCESSFUL
echo ==========================================
echo.
echo Your plugin JAR was created here:
echo.
dir /b target\*.jar
echo.
echo Next step:
echo Copy the JAR file into your Paper server's plugins folder.
echo.
pause