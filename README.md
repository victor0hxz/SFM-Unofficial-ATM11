<!-- VERSION-LOCKED-PUBLICATION:START -->
# Super Factory Manager: Version Locked

<img src="https://raw.githubusercontent.com/victor0hxz/SFM-Version-Locked/main/publication/BANNER-VERSION-LOCKED.png" alt="Super Factory Manager: Version Locked" width="100%" />

**Minecraft 26.1.2 · NeoForge · Java 25**

[CurseForge](https://www.curseforge.com/minecraft/mc-mods/super-factory-manager-unofficial-fan-build-26-1-2) · [Downloads](https://github.com/victor0hxz/SFM-Version-Locked/releases) · [Source](https://github.com/victor0hxz/SFM-Version-Locked) · [Report an issue](https://github.com/victor0hxz/SFM-Version-Locked/issues)

An unofficial community port for Minecraft 26.1.2 and NeoForge.

A programmable resource automation mod using factory managers and its scripting language.

**Requirements:** No required mod dependencies beyond NeoForge.

## 🔒 Version Locked

The builds distributed here target Minecraft 26.1.2 and Java 25. Files for newer Minecraft versions are not provided by this release.

## Community project

This is a fan-maintained compatibility project by victor0hxz. The upstream developers and the All the Mods team have not endorsed this port. Original contributions remain credited to their respective authors.

## Original project

Original project: https://github.com/TeamDman/SuperFactoryManager

Original authors: **TeamDman and the Super Factory Manager contributors**. Visit the upstream project for official releases and to support its developers.

## Credits and license

This port does not claim ownership of the original code, artwork or assets. The original **MPL-2.0** license and copyright notices are preserved with the distribution.

## 🛠️ Bugs and compatibility

Please report port-specific issues at https://github.com/victor0hxz/SFM-Version-Locked/issues. Include your Minecraft and NeoForge versions, installed mod list, relevant logs and any crash report. Compatibility with every mod combination has not been verified.

## 🧪 ATM11 compatibility

This distribution was prepared for the ATM11 compatibility project. Recompiled artifact located in the previous ATM11 server correction package. Archive integrity and metadata verified; no new full-pack runtime validation was performed for this publication.

## Installation at a glance

- Minecraft: 26.1.2
- Loader: NeoForge
- Java: 25
- Project type: unofficial community port
- License: MPL-2.0
- GitHub, downloads and source documentation: https://github.com/victor0hxz/SFM-Version-Locked
- Installation: replace older copies of this mod and avoid duplicate mod IDs.

Thank you to TeamDman and the Super Factory Manager contributors for the original project.

<!-- VERSION-LOCKED-PUBLICATION:END -->

---

## Build and port documentation

# Super Factory Manager Version Locked

Provides programmable factory automation and resource routing through a controller and cable network. This fan-maintained compatibility build preserves the SFM programming workflow and includes the Buffer item registration correction from the local ATM11 project.

## Unofficial fan build and credits

This adaptation was prepared by **victor0hxz** for the ATM11 compatibility project. It is an **unofficial version made by fans**, not an official release. It is not affiliated with or endorsed by the original authors or the All the Mods team.

Original authors: **TeamDman and the Super Factory Manager contributors**. [Original source project](https://github.com/TeamDman/SuperFactoryManager). The original MPL-2.0 license and copyright notices are preserved. The original mod authors retain credit for the mod and its content.

## Requirements and installation

Minecraft **26.1.2**, NeoForge and **Java 25**. No required mod dependencies beyond NeoForge.

Replace the older copy of the same mod; do not install the official build and this build together because the mod ID is unchanged. Keep Mekanism modules on matching versions. This older source build is a separate alternative to the Version Locked modules used by the newer Extras tests; mixing them has not been validated. Dependencies are not bundled.

## Validation and release status

Recompiled artifact located in the previous ATM11 server correction package. Archive integrity and metadata verified; no new full-pack runtime validation was performed for this publication.

This initial file should be submitted as **Beta**, pending full-pack community gameplay tests. Do not interpret a compiled JAR as a guarantee that every gameplay scenario has been tested.

## Source availability

The corresponding local source snapshot is provided in `sfm-corresponding-source.zip`, under MPL-2.0. Make this source archive available alongside the binary when publishing, preserving existing third-party notices.

## Downloads and support

Download the unofficial prerelease JAR from [this repository's releases](https://github.com/victor0hxz/SFM-Version-Locked/releases). Report problems to [this port's issue tracker](https://github.com/victor0hxz/SFM-Version-Locked/issues). Do not direct port-specific support requests to the original authors.

## Build source

This repository preserves the local production source snapshot used by the compatibility project, including the original license. Install Java 25 and use the Gradle wrapper. Torchmaster: `gradlew.bat :neoforge:jar`; Mekanism and modules: `gradlew.bat jar`; SFM: run `gradlew.bat build` inside `platform/minecraft`. Original optional dependency versions remain in the inherited Gradle configuration. An uncached rebuild of this snapshot has not been validated in this publication step.

SFM build dependency: place the matching Mekanism JAR in platform/minecraft/libs/; obtain it from the matching Mekanism release.
