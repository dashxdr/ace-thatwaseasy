TOOLS=$(HOME)/android-sdk-linux/platform-tools
ADB=$(TOOLS)/adb
APP=ace_thatwaseasy
ZIPALIGN=$(TOOLS)/../tools/zipalign

all: release

debug:
	ant debug
	$(ADB) -d install -r bin/$(APP)-debug.apk

clean:
	ant clean
	rm -f *.apk

test: install

release:
	ant release
	$(ZIPALIGN) -f -v 4 bin/$(APP)-release.apk $(APP).apk
install:
	$(ADB) -d install -r $(APP).apk

log:
	$(ADB) logcat -s MyLog:*
