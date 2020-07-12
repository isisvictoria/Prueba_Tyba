if not exist "..\.git\hooks" mkdir "..\.git\hooks"
if exist "..\.git\hooks\pre-push" del "..\.git\hooks\pre-push"
mklink /H "..\.git\hooks\pre-push" "windowsHook\pre-push"
