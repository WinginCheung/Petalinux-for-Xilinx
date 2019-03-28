#
# This file is the autoinit recipe.
#

SUMMARY = "Simple autoinit application"
SECTION = "PETALINUX/apps"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "file://autoinit \
	"

S = "${WORKDIR}"

inherit update-rc.d

INITSCRIPT_NAME = "autoinit"
INITSCRIPT_PARAMS = "start 99 S ."

do_install() {
	     install -d ${D}/${sysconfdir}/init.d
	     install -m 0755 ${S}/autoinit ${D}/${sysconfdir}/init.d/autoinit
}

FILES_${PN} += "${sysconfdir}/*"
