TOOLS=/opt/android/platform-tools
ADB=$(TOOLS)/adb
APP=ace_thatwaseasy
ZIPALIGN=$(TOOLS)/../tools/zipalign

all:
	ant debug

clean:
	ant clean

test: all
	$(ADB) -d install -r bin/$(APP)-debug.apk

release:
	ant release
	$(ZIPALIGN) -f -v 4 bin/$(APP)-release.apk $(APP).apk
	#$(ADB) -d install -r $(APP).apk

log:
	$(ADB) logcat -s MyLog:*
