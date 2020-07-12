if [ ! -d "../.git/hooks" ]; then
	mkdir ../.git/hooks
fi
rm -f ../.git/hooks/pre-push
cd ../.git/hooks
ln -s -f ../../remoteHooks/linuxHook/hooks/pre-push ./pre-push
