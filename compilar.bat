@echo off
setlocal

set "JAVAC_CMD="

if defined JAVA_HOME (
    if exist "%JAVA_HOME%\bin\javac.exe" (
        set "JAVAC_CMD=%JAVA_HOME%\bin\javac.exe"
    )
)

if not defined JAVAC_CMD (
    where javac >nul 2>nul
    if errorlevel 1 (
        echo javac nao encontrado.
        echo Instale o JDK e configure JAVA_HOME ou adicione a pasta bin do JDK ao PATH.
        exit /b 1
    )
    set "JAVAC_CMD=javac"
)

if not exist out mkdir out
"%JAVAC_CMD%" -encoding UTF-8 -d out src\algoritmos\*.java
if errorlevel 1 exit /b 1

echo Compilacao concluida em out.
