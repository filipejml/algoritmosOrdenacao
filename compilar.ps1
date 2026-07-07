$ErrorActionPreference = "Stop"

function Resolve-Javac {
    if ($env:JAVA_HOME) {
        $javaHomeJavac = Join-Path $env:JAVA_HOME "bin\javac.exe"
        if (Test-Path $javaHomeJavac) {
            return $javaHomeJavac
        }
    }

    $javacCommand = Get-Command javac -ErrorAction SilentlyContinue
    if ($javacCommand) {
        return $javacCommand.Source
    }

    return $null
}

$javac = Resolve-Javac
if (-not $javac) {
    Write-Host "javac nao encontrado."
    Write-Host "Instale o JDK e configure JAVA_HOME ou adicione a pasta bin do JDK ao PATH."
    exit 1
}

$sources = Get-ChildItem -Path "src\algoritmos" -Filter "*.java" | ForEach-Object { $_.FullName }
if (-not $sources) {
    Write-Host "Nenhum arquivo .java encontrado em src\algoritmos."
    exit 1
}

New-Item -ItemType Directory -Force -Path "out" | Out-Null
& $javac -encoding UTF-8 -d "out" $sources

Write-Host "Compilacao concluida em out."
