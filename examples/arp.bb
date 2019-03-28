#
# This file is the arp recipe.
#

SUMMARY = "Simple arp application"
SECTION = "PETALINUX/apps"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "file://arp \
	"

S = "${WORKDIR}"
INSANE_SKIP_${PN} = "ldflags"
INHIBIT_PACKAGE_DEBUG_SPLIT = "1"
INHIBIT_PACKAGE_STRIP = "1"

do_install() {
    install -d ${D}/${bindir}
    install -m 0755 ${S}/arp ${D}/${bindir}
}
