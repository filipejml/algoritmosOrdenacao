$ErrorActionPreference = "Stop"

& ".\compilar.ps1"
if ($LASTEXITCODE -ne 0) {
    exit $LASTEXITCODE
}

& java -cp "out" algoritmos.Main
